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

/**
 * 
 * @author Milen Dyankov
 *
 */
public interface MultideviceConstants {
	public static final String DESTINATION_DEVICE_RECOGNITION_PROVIDER = "commsen/device_recognition_provider";
	public static final String DESTINATION_DEVICE_RECOGNITION_PROVIDER_RESPONSE = "commsen/device_recognition_provider/response";

	public static final String DESTINATION_THEME_SELECTING_PROVIDER = "commsen/theme_selecting_provider";
	public static final String DESTINATION_THEME_SELECTING_PROVIDER_RESPONSE = "commsen/theme_selecting_provider/response";

	public static final String COMMAND_GET_KNOWN_DEVICES = "KNOWN_DEVICES";
}
