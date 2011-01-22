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
	
	
}
