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

import com.liferay.portal.kernel.messaging.BaseDestinationEventListener;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;

/**
 * This destination event listener reacts on register an unregister events. When new
 * {@link DeviceRecognitionMessageListener} is registered it removes the one base one. When external
 * {@link DeviceRecognitionMessageListener} is removed it registers back the base one.
 * 
 * @author Milen Dyankov
 * 
 */
public class DeviceRecognitionDestinationEventListener extends BaseDestinationEventListener {

	private DeviceRecognitionMessageListener deviceRecognitionMessageListener;


	@Override
	public void messageListenerRegistered(String destinationName, MessageListener messageListener) {
		if (!isProceed(destinationName, messageListener)) {
			return;
		}
		MessageBusUtil.unregisterMessageListener(MultideviceConstants.DESTINATION_DEVICE_RECOGNITION_PROVIDER,
		        deviceRecognitionMessageListener);
	}


	@Override
	public void messageListenerUnregistered(String destinationName, MessageListener messageListener) {
		if (!isProceed(destinationName, messageListener)) {
			return;
		}
		MessageBusUtil.registerMessageListener(MultideviceConstants.DESTINATION_DEVICE_RECOGNITION_PROVIDER,
		        deviceRecognitionMessageListener);
	}


	public void setDeviceRecognitionMessageListener(DeviceRecognitionMessageListener deviceRecognitionMessageListener) {
		this.deviceRecognitionMessageListener = deviceRecognitionMessageListener;
	}


	protected boolean isProceed(String destinationName, MessageListener messageListener) {

		if ((!destinationName.equals(MultideviceConstants.DESTINATION_DEVICE_RECOGNITION_PROVIDER))
		        || (messageListener == deviceRecognitionMessageListener)
		        || !(messageListener instanceof DeviceRecognitionMessageListener)) {

			return false;
		} else {
			return true;
		}
	}

}
