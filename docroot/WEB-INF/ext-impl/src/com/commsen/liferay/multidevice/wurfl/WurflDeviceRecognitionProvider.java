package com.commsen.liferay.multidevice.wurfl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.wurfl.core.Device;
import net.sourceforge.wurfl.core.WURFLHolder;
import net.sourceforge.wurfl.core.WURFLUtils;

import org.apache.commons.lang.StringUtils;

import com.commsen.liferay.multidevice.CapabilityValue;
import com.commsen.liferay.multidevice.DeviceRecognitionProvider;
import com.commsen.liferay.multidevice.VersionableName;
import com.commsen.liferay.multidevice.VersionableNameImpl;

public class WurflDeviceRecognitionProvider implements DeviceRecognitionProvider {

	private WURFLHolder wurflHolder;
	private Set<VersionableName> operatingSystems;
	private Set<VersionableName> browsers;
	private Set<VersionableName> brands;
	private Set<String> pointingMethods = new TreeSet<String>();
	private Map<CapabilityValue, Set<String>> devicesByCapability = new HashMap<CapabilityValue, Set<String>>();
	
	public WurflDeviceRecognitionProvider(WURFLHolder wurflHolder) {
		this.wurflHolder = wurflHolder;

		Map<String, VersionableName> tmpOS = new HashMap<String, VersionableName>();
		Map<String, VersionableName> tmpBrowsers = new HashMap<String, VersionableName>();
		Map<String, VersionableName> tmpBrands = new HashMap<String, VersionableName>();

		WURFLUtils wurflUtils = wurflHolder.getWURFLUtils();
		
		long t = System.currentTimeMillis();
		for (Object o : wurflUtils.getAllDevicesId()) {
			Device device = wurflUtils.getDeviceById((String) o);
			updateVersionableProduct(device, tmpBrands, "brand_name", "model_name", "marketing_name");
			updateVersionableProduct(device, tmpOS, "device_os", "device_os_version");
			updateVersionableProduct(device, tmpBrowsers, "mobile_browser", "mobile_browser_version");
			updateStringSet(device, pointingMethods, "pointing_method");
			
			updateDevicesByCapabilities(device, "device_os");
		}
		
		operatingSystems = new TreeSet<VersionableName>(tmpOS.values());
		browsers = new TreeSet<VersionableName>(tmpBrowsers.values());
		brands = new TreeSet<VersionableName>(tmpBrands.values());
		
		System.out.println("INIT complete in " + (System.currentTimeMillis() - t) + " milliseconds!!!");
	}
	
	public  Map<CapabilityValue, Set<String>> getDevicesByCapabilities () {
		return devicesByCapability;
	}

	public Set<VersionableName> getBrands() {
		return brands ;
	}

	public Set<VersionableName> getOperatingSystems() {
		return operatingSystems ;
	}

	public Set<VersionableName> getBrowsers() {
		return browsers;
	}

	public Set<String> getPointingMethods() {
		return pointingMethods;
	}

	@Override
	public com.commsen.liferay.multidevice.Device getDeviceFromRequest(HttpServletRequest request) {
		com.commsen.liferay.multidevice.Device device = null;
		Device wurflDevice = wurflHolder.getWURFLManager().getDeviceForRequest(request);
		if (wurflDevice != null) {
			@SuppressWarnings("unchecked")
			Map<String, String> capabilities = wurflDevice.getCapabilities();
			if (capabilities != null) device = new com.commsen.liferay.multidevice.Device(capabilities);
		}
		return device;
	}
	
	
	
	
	

	private void updateVersionableProduct(Device device, Map<String, VersionableName> map, String nameAttribute, String versionAttribute) {
		updateVersionableProduct(device, map, nameAttribute, versionAttribute, null);
	}
	
	private void updateVersionableProduct(Device device, Map<String, VersionableName> map, String nameAttribute, String versionAttribute, String subversionAttribute) {
		String name = device.getCapability(nameAttribute);
		if (StringUtils.isNotBlank(name)) {
			VersionableNameImpl versionableProduct = (VersionableNameImpl) map.get(name);
			if (versionableProduct == null) {
				versionableProduct = new VersionableNameImpl(name);
				map.put(name, versionableProduct);
			}
			String version = device.getCapability(versionAttribute);
			if (StringUtils.isNotBlank(version)) {
				if (subversionAttribute != null) {
					String subversion = device.getCapability(subversionAttribute);
					if (StringUtils.isNotBlank(subversion)) {
						version += " (" + subversion + ")";
					}
				}
				versionableProduct.addVersion(version);
			} else if (subversionAttribute != null) {
				String subversion = device.getCapability(subversionAttribute);
				if (StringUtils.isNotBlank(subversion)) {
					versionableProduct.addVersion(subversion);
				}
			}
		}
	}

	private  void updateDevicesByCapabilities(Device device, String... capabilities) {
		if (capabilities == null || capabilities.length == 0) return; 
		for (String capability : capabilities) {
			String value = device.getCapability(capability);
			if (StringUtils.isNotBlank(value)) {
				CapabilityValue capabilityValue = new CapabilityValue(capability,value);
				Set<String> ids = new TreeSet<String>(); 
				if (devicesByCapability.containsKey(capabilityValue)) {
					ids = devicesByCapability.get(capabilityValue);
				} else {
					devicesByCapability.put(capabilityValue, ids);
				}
				ids.add(device.getId());
			}
		}
	}

	private  void updateStringSet(Device device, Set<String> set, String attribute) {
		String value = device.getCapability(attribute);
		if (StringUtils.isNotBlank(value)) {
			set.add(value);
		}
	}

}
