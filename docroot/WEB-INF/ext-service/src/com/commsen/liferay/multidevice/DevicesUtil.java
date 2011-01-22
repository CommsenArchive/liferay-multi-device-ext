package com.commsen.liferay.multidevice;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import com.commsen.liferay.multidevice.CapabilityValue;
import com.commsen.liferay.multidevice.Device;
import com.commsen.liferay.multidevice.DeviceRecognitionProvider;
import com.commsen.liferay.multidevice.VersionableName;


public class DevicesUtil {


	protected static Set<DeviceRecognitionProvider> deviceRecognitionProviders = new HashSet<DeviceRecognitionProvider>();
	
	
	protected static Set<VersionableName> operatingSystems;
	protected static Set<VersionableName> browsers;
	protected static Set<VersionableName> brands;
	protected static Set<String> pointingMethods;
	protected static Map<CapabilityValue, Set<String>> devicesByCapability;
	
	public static void refresh() {
		operatingSystems = new TreeSet<VersionableName>();
		browsers = new TreeSet<VersionableName>();
		brands = new TreeSet<VersionableName>();
		pointingMethods = new TreeSet<String>();
		devicesByCapability = new HashMap<CapabilityValue, Set<String>>();

		for (DeviceRecognitionProvider provider : deviceRecognitionProviders) {
			operatingSystems.addAll(provider.getOperatingSystems());
			browsers.addAll(provider.getBrowsers());
			brands.addAll(provider.getBrands());
			pointingMethods.addAll(provider.getPointingMethods());
			devicesByCapability.putAll(provider.getDevicesByCapabilities());
		}
	}
	
	public static void registerDeviceRecognitionProvider (DeviceRecognitionProvider provider) {
		if (provider != null) deviceRecognitionProviders.add(provider);
	}

	public static void unregisterDeviceRecognitionProvider (DeviceRecognitionProvider provider) {
		if (provider != null) deviceRecognitionProviders.remove(provider);
	}
	
	public static Set<String> getDeviceIdsByCapabilityValue(CapabilityValue capabilityValue) {
		if (capabilityValue == null) return null;
		return Collections.unmodifiableSet(devicesByCapability.get(capabilityValue));
	}

	public static Set<VersionableName> getBrands() {
		if (brands == null) return null;
		return Collections.unmodifiableSet(brands) ;
	}

	public static Set<VersionableName> getOperatingSystems() {
		if (operatingSystems == null) return null;
		return Collections.unmodifiableSet(operatingSystems) ;
	}

	public static Set<VersionableName> getBrowsers() {
		if (browsers == null) return null;
		return Collections.unmodifiableSet(browsers);
	}

	public static Set<String> getPointingMethods() {
		if (pointingMethods == null) return null;
		return Collections.unmodifiableSet(pointingMethods);
	}

	
	public static Device getDeviceFromRequest(HttpServletRequest request) {
		Device device = null;
		for (DeviceRecognitionProvider provider : deviceRecognitionProviders) {
			device = provider.getDeviceFromRequest(request);
			if (device != null) break;
		}
		return device;
	}

}