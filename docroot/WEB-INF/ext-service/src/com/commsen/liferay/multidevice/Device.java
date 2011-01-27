package com.commsen.liferay.multidevice;

import java.util.Map;

public class Device {

	private Map<String, String> capabilities;

	public Device(Map<String, String> capabilities) {
		super();
		this.capabilities = capabilities;
	} 
	
	public Map<String, String> getCapabilities() {
		return capabilities;
	}

	public String getCapability(String name) {
		if (capabilities == null) return null;
		return capabilities.get(name);
	}
	
	public String getBrand() {
		if (capabilities == null) return null;
		return capabilities.get("brand_name");
	}

	public String getModel() {
		if (capabilities == null) return null;
		return capabilities.get("model_name");
	}

	public String getOS() {
		if (capabilities == null) return null;
		return capabilities.get("device_os");
	}
	public String getOSVersion() {
		if (capabilities == null) return null;
		return capabilities.get("device_os_version");
	}
	public String getBrowser() {
		if (capabilities == null) return null;
		return capabilities.get("mobile_browser");
	}
	public String getBrowserVersion() {
		if (capabilities == null) return null;
		return capabilities.get("mobile_browser_version");
	}
	public String getPointingMethod() {
		if (capabilities == null) return null;
		return capabilities.get("pointing_method");
	}
	public boolean isTablet() {
		if (capabilities == null) return false;
		return Boolean.parseBoolean(capabilities.get("is_tablet"));
	}
	public boolean hasQwertyKeyboard() {
		if (capabilities == null) return false;
		return Boolean.parseBoolean(capabilities.get("has_qwerty_keyboard"));
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Device(")
		.append("brand:").append(getBrand())
		.append(", model:").append(getModel())
		.append(", os:").append(getOS())
		.append(", osVersion:").append(getOSVersion())
		.append(", browser:").append(getBrowser())
		.append(", browserVersion:").append(getBrowserVersion())
		.append(", pointingMethod:").append(getPointingMethod())
		.append(", isTablet:").append(isTablet())
		.append(", hasQwertyKeyboard:").append(hasQwertyKeyboard())
		.append(")");
		return sb.toString();
	}

}
