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

import java.util.Collections;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * This class provides convenient methods for device recognition
 * 
 * 
 * @author Milen Dyankov
 * 
 */
public class DevicesUtil {

	protected static DeviceRecognitionProvider _deviceRecognitionProvider;

	protected static KnownDevices knownDevices;

	private static Log _log = LogFactoryUtil.getLog(DevicesUtil.class);


//	public void afterPropertiesSet() {
//		refresh();
//	}


	/**
	 * Refreshes the list of know devices from {@link DeviceRecognitionProvider}
	 */
	public static void refresh() {
		knownDevices = _deviceRecognitionProvider.getKnownDevices();
	}


	/**
	 * Returns all devices having given capability value
	 * 
	 * @param capabilityValue the name and value of the capability
	 * @return all devices having given capability value
	 */
	public static Set<String> getDeviceIdsByCapabilityValue(CapabilityValue capabilityValue) {
		if (capabilityValue != null && knownDevices.getDevicesByCapabilities() != null) {
			return Collections.unmodifiableSet(knownDevices.getDevicesByCapabilities().get(capabilityValue));
		}
		return null;
	}


	public static Set<VersionableName> getBrands() {
		if (knownDevices == null || knownDevices.getBrands() == null) return null;
		return Collections.unmodifiableSet(knownDevices.getBrands());
	}


	public static Set<VersionableName> getOperatingSystems() {
		if (knownDevices == null || knownDevices.getOperatingSystems() == null) return null;
		return Collections.unmodifiableSet(knownDevices.getOperatingSystems());
	}


	public static Set<VersionableName> getBrowsers() {
		if (knownDevices == null || knownDevices.getBrowsers() == null) return null;
		return Collections.unmodifiableSet(knownDevices.getBrowsers());
	}


	public static Set<String> getPointingMethods() {
		if (knownDevices == null || knownDevices.getPointingMethods() == null) return null;
		return Collections.unmodifiableSet(knownDevices.getPointingMethods());
	}


	public static Device getDeviceFromRequest(HttpServletRequest request) {
		if (_deviceRecognitionProvider == null) {
			_log.warn("No device recognition provider added to DeviceUtil !!!");
			return null;
		}
		return _deviceRecognitionProvider.getDeviceFromRequest(request);
	}


	public void setDeviceRecognitionProvider(DeviceRecognitionProvider deviceRecognitionProvider) {
		_deviceRecognitionProvider = deviceRecognitionProvider;
	}

}