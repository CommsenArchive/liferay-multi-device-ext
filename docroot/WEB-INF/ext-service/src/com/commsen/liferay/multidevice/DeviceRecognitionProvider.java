package com.commsen.liferay.multidevice;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.commsen.liferay.multidevice.CapabilityValue;
import com.commsen.liferay.multidevice.Device;
import com.commsen.liferay.multidevice.VersionableName;

public interface DeviceRecognitionProvider {

	public Map<CapabilityValue, Set<String>> getDevicesByCapabilities ();

	public Set<VersionableName> getBrands();

	public Set<VersionableName> getOperatingSystems();

	public Set<VersionableName> getBrowsers();

	public Set<String> getPointingMethods();

	public Device getDeviceFromRequest(HttpServletRequest request);
	
}
