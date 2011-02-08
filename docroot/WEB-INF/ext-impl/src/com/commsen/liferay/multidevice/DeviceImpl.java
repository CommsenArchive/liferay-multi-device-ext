/**
 *	This file is part of multi-device portal extension for Liferay.
 *	
 * Multi-device portal extension for Liferay is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * Multi-device portal extension for Liferay is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with multi-device portal extension for Liferay.  If not, see <http://www.gnu.org/licenses/lgpl.html>.
 */
package com.commsen.liferay.multidevice;

import java.util.Map;

/**
 * Class represents user's device
 * 
 * @author Milen Dyankov
 * 
 */
public class DeviceImpl implements Device {

	private Map<String, String> capabilities;


	public DeviceImpl(Map<String, String> capabilities) {
		super();
		this.capabilities = capabilities;
	}


	@Override
	public Map<String, String> getCapabilities() {
		return capabilities;
	}


	@Override
	public String getCapability(String name) {
		if (capabilities == null) return null;
		return capabilities.get(name);
	}


	@Override
	public String getBrand() {
		if (capabilities == null) return null;
		return capabilities.get("brand_name");
	}


	@Override
	public String getModel() {
		if (capabilities == null) return null;
		return capabilities.get("model_name");
	}


	@Override
	public String getOS() {
		if (capabilities == null) return null;
		return capabilities.get("device_os");
	}


	@Override
	public String getOSVersion() {
		if (capabilities == null) return null;
		return capabilities.get("device_os_version");
	}


	@Override
	public String getBrowser() {
		if (capabilities == null) return null;
		return capabilities.get("mobile_browser");
	}


	@Override
	public String getBrowserVersion() {
		if (capabilities == null) return null;
		return capabilities.get("mobile_browser_version");
	}


	@Override
	public String getPointingMethod() {
		if (capabilities == null) return null;
		return capabilities.get("pointing_method");
	}


	@Override
	public boolean isTablet() {
		if (capabilities == null) return false;
		return Boolean.parseBoolean(capabilities.get("is_tablet"));
	}


	@Override
	public boolean hasQwertyKeyboard() {
		if (capabilities == null) return false;
		return Boolean.parseBoolean(capabilities.get("has_qwerty_keyboard"));
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Device(").append("brand:").append(getBrand()).append(", model:")
		        .append(getModel()).append(", os:").append(getOS()).append(", osVersion:").append(getOSVersion())
		        .append(", browser:").append(getBrowser()).append(", browserVersion:").append(getBrowserVersion())
		        .append(", pointingMethod:").append(getPointingMethod()).append(", isTablet:").append(isTablet())
		        .append(", hasQwertyKeyboard:").append(hasQwertyKeyboard()).append(")");
		return sb.toString();
	}

}
