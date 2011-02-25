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
import java.util.Map;

/**
 * Class represents unknown device
 * 
 * @author Milen Dyankov
 * 
 */
public class UnknownDevice extends AbstractDevice {

	public static final String UNKNOWN = "unknown";

	private static UnknownDevice instance = null;
	
	private UnknownDevice() {
		// private constructor
	}
	
	public static UnknownDevice getInstance () {
		if (instance == null) instance = new UnknownDevice();
		return instance;
    } 
	
	@Override
	public Map<String, String> getCapabilities() {
		return Collections.emptyMap();
	}


	@Override
	public String getCapability(String name) {
		return null;
	}


	@Override
	public String getBrand() {
		return UNKNOWN;
	}


	@Override
	public String getModel() {
		return UNKNOWN;
	}


	@Override
	public String getOS() {
		return UNKNOWN;
	}


	@Override
	public String getOSVersion() {
		return UNKNOWN;
	}


	@Override
	public String getBrowser() {
		return UNKNOWN;
	}


	@Override
	public String getBrowserVersion() {
		return UNKNOWN;
	}


	@Override
	public String getPointingMethod() {
		return UNKNOWN;
	}


	@Override
	public boolean isTablet() {
		return false;
	}


	@Override
	public boolean hasQwertyKeyboard() {
		return true;
	}

}
