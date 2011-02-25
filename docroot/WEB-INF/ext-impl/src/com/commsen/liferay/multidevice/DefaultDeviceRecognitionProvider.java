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

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * 
 * @author Milen Dyankov
 *
 */
public class DefaultDeviceRecognitionProvider implements DeviceRecognitionProvider {

	private static Log _log = LogFactoryUtil.getLog(DefaultDeviceRecognitionProvider.class);

	@Override
	public KnownDevices getKnownDevices() {
		_log.warn("DEVICE RECOGNITION PROVIDER NOT INSTALLED! LIST OF KNOWN DEVICES IS NOT AVAILABLE!");
		return NoKnownDevices.getInstance();
	}


	@Override
	public Device getDeviceFromRequest(HttpServletRequest request) {
		_log.warn("DEVICE RECOGNITION PROVIDER NOT INSTALLED! UNABLE TO RECOGNIZE USER'S DEVICE!");
		return UnknownDevice.getInstance();
	}

}
