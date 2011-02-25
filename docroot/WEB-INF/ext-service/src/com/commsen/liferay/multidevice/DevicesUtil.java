/**
 * Copyright (c) COMMSEN International. All rights reserved.
 *	
 * This library is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library.  If not, see http://www.gnu.org/licenses/lgpl.html.
 */
package com.commsen.liferay.multidevice;

import java.util.Collections;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * This class provides convenient methods for device recognition
 * 
 * 
 * @author Milen Dyankov
 * 
 */
public class DevicesUtil {

	protected static DeviceRecognitionProvider _deviceRecognitionProvider;

	/**
	 * Returns all devices having given capability value
	 * 
	 * @param capabilityValue the name and value of the capability
	 * @return all devices having given capability value
	 */
	public static Set<String> getDeviceIdsByCapabilityValue(CapabilityValue capabilityValue) {
		return Collections.unmodifiableSet(_deviceRecognitionProvider.getKnownDevices().getDevicesByCapabilities().get(capabilityValue));
	}


	public static Set<VersionableName> getBrands() {
		return Collections.unmodifiableSet(_deviceRecognitionProvider.getKnownDevices().getBrands());
	}


	public static Set<VersionableName> getOperatingSystems() {
		return Collections.unmodifiableSet(_deviceRecognitionProvider.getKnownDevices().getOperatingSystems());
	}


	public static Set<VersionableName> getBrowsers() {
		return Collections.unmodifiableSet(_deviceRecognitionProvider.getKnownDevices().getBrowsers());
	}


	public static Set<String> getPointingMethods() {
		return Collections.unmodifiableSet(_deviceRecognitionProvider.getKnownDevices().getPointingMethods());
	}


	public static Device getDeviceFromRequest(HttpServletRequest request) {
		return _deviceRecognitionProvider.getDeviceFromRequest(request);
	}


	public void setDeviceRecognitionProvider(DeviceRecognitionProvider deviceRecognitionProvider) {
		_deviceRecognitionProvider = deviceRecognitionProvider;
	}

}