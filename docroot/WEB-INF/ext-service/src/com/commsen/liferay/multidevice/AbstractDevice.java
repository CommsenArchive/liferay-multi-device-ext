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
 * Abstract class containing common methods for all devices
 * 
 * @author Milen Dyankov
 * 
 */
public abstract class AbstractDevice implements Device {

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
