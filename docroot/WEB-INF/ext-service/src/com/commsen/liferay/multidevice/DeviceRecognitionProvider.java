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

/**
 * Contract for device recognition providers. Implementors should be able to provide information
 * about all known devices and must be able to recognize user's device form provided 
 * {@link HttpServletRequest} object.
 * 
 * @author Milen Dyankov
 * 
 */
public interface DeviceRecognitionProvider {

	/**
	 * Returns all known devices for this provider
	 * 
	 * @return all known devices for this provider
	 */
	public KnownDevices getKnownDevices();


	/**
	 * Returns user's device as recognized from provided {@link HttpServletRequest}
	 * 
	 * @param request the request
	 * @return user's device as recognized from provided {@link HttpServletRequest}
	 */
	public Device getDeviceFromRequest(HttpServletRequest request);

}
