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

import com.commsen.liferay.multidevice.command.DeviceFromRequestCommand;
import com.commsen.liferay.multidevice.command.KnownDevicesCommand;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.MessageBusException;
import com.liferay.portal.kernel.messaging.MessageBusUtil;

/**
 * 
 * @author Milen Dyankov
 * 
 */
public class DeviceRecognitionProviderDelegate implements DeviceRecognitionProvider {

	private static Log _log = LogFactoryUtil.getLog(DeviceRecognitionProviderDelegate.class);


	@Override
	public KnownDevices getKnownDevices() {
		try {
			Object result = MessageBusUtil.sendSynchronousMessage(
			        MultideviceConstants.DESTINATION_DEVICE_RECOGNITION_PROVIDER, new KnownDevicesCommand(),
			        MultideviceConstants.DESTINATION_DEVICE_RECOGNITION_PROVIDER_RESPONSE);
			if (!(result instanceof KnownDevices)) {
				_log.error("Unexpected response! Expected " + KnownDevices.class.getName() + " but got "
				        + result.getClass().getName());
				return null;
			}
			return (KnownDevices) result;
		} catch (MessageBusException e) {
			_log.error("Failed to get known devices!", e);
		}
		return null;
	}


	@Override
	public Device getDeviceFromRequest(HttpServletRequest request) {
		try {
			Object result = MessageBusUtil.sendSynchronousMessage(
			        MultideviceConstants.DESTINATION_DEVICE_RECOGNITION_PROVIDER,
			        new DeviceFromRequestCommand(request),
			        MultideviceConstants.DESTINATION_DEVICE_RECOGNITION_PROVIDER_RESPONSE);
			if (!(result instanceof Device)) {
				_log.error("Unexpected response! Expected " + Device.class.getName() + " but got "
				        + result.getClass().getName());
				return null;
			}
			return (Device) result;
		} catch (MessageBusException e) {
			_log.error("Failed to get device from request!", e);
		}
		return null;
	}

}
