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

import java.util.Map;

/**
 * Represents user's device as recognized by {@link DeviceRecognitionProvider}
 * 
 * @author Milen Dyankov
 * 
 */
public interface Device {

	/**
	 * Provides map of all capabilities known to {@link DeviceRecognitionProvider}
	 * 
	 * @return map of all capabilities known to {@link DeviceRecognitionProvider}
	 */
	public abstract Map<String, String> getCapabilities();


	/**
	 * Gets the value of given capability for this device
	 * 
	 * @param name the name of the capability
	 * @return the value of this capability for this device
	 */
	public abstract String getCapability(String name);


	/**
	 * Returns device's brand name
	 * 
	 * @return device's brand name
	 */
	public abstract String getBrand();


	/**
	 * Returns device's model name
	 * 
	 * @return device's model name
	 */
	public abstract String getModel();


	/**
	 * Returns operating system's name for this device
	 * 
	 * @return operating system's name for this device
	 */
	public abstract String getOS();


	/**
	 * Returns operating system's version for this device
	 * 
	 * @return operating system's version for this device
	 */
	public abstract String getOSVersion();


	/**
	 * Returns web browser's name for this device
	 * 
	 * @return web browser's name for this device
	 */
	public abstract String getBrowser();


	/**
	 * Returns web browser's version for this device
	 * 
	 * @return web browser's version for this device
	 */
	public abstract String getBrowserVersion();


	/**
	 * Provides the recognized pointing method (touchscreen, trackball, ...)
	 * 
	 * @return the recognized pointing method
	 */
	public abstract String getPointingMethod();


	/**
	 * Returns <code>true</code> if device is tablet and <code>false</code> otherwise
	 * 
	 * @return <code>true</code> if device is tablet and <code>false</code> otherwise
	 */
	public abstract boolean isTablet();


	/**
	 * Returns <code>true</code> if device has QWERTY keyboard and <code>false</code> otherwise
	 * 
	 * @return <code>true</code> if device has QWERTY keyboard and <code>false</code> otherwise
	 */
	public abstract boolean hasQwertyKeyboard();

}