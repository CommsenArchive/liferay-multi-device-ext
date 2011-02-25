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
 * Class represents combination of capability name and value to be used as key in a map containing
 * all devices having given capability.
 * 
 * @author Milen Dyankov
 * 
 */
public class CapabilityValue {

	/**
	 * Capability name
	 */
	private String name;

	/**
	 * Capability vaue
	 */
	private String value;


	public CapabilityValue(String name, String value) {
		if (name == null)
		    throw new IllegalArgumentException(
		            "Capabilty name is null. Can not create CapabilityValue object without capability name!");
		this.name = name;
		this.value = value;
	}


	public String getName() {
		return name;
	}


	public String getValue() {
		return value;
	}

	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null || !(obj instanceof CapabilityValue)) return false;
	    CapabilityValue other = (CapabilityValue)obj;
	    return name.equals(other.name) && ((value == null && other.value == null) || (value != null && value.equals(other.value)));
	}
	
	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash * 31 + name.hashCode();
		if (value != null) {
			hash = hash * 31 + value.hashCode();
		}
		return hash;
	}
}
