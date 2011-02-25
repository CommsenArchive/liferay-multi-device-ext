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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Class represents unknown device
 * 
 * @author Milen Dyankov
 * 
 */
public class NoKnownDevices implements KnownDevices {

	private Set<VersionableName> brands = new HashSet<VersionableName>();
	private Set<VersionableName> os = new HashSet<VersionableName>();
	private Set<VersionableName> browsers = new HashSet<VersionableName>();
	private Set<String> pointingMethods = new HashSet<String>();
	
	private static NoKnownDevices instance = null;
	
	private NoKnownDevices () {
		brands.add(new VersionableNameImpl(UnknownDevice.UNKNOWN, UnknownDevice.UNKNOWN));
		os.add(new VersionableNameImpl(UnknownDevice.UNKNOWN, UnknownDevice.UNKNOWN));
		browsers.add(new VersionableNameImpl(UnknownDevice.UNKNOWN, UnknownDevice.UNKNOWN));
		pointingMethods.add(UnknownDevice.UNKNOWN);
	} 
	
	public static NoKnownDevices getInstance () {
		if (instance == null) instance = new NoKnownDevices();
		return instance;
	}
	
	
	@Override
    public Map<CapabilityValue, Set<String>> getDevicesByCapabilities() {
	    return Collections.emptyMap();
    }

	@Override
    public Set<VersionableName> getBrands() {
	    return Collections.unmodifiableSet(brands);
    }

	@Override
    public Set<VersionableName> getOperatingSystems() {
	    return Collections.unmodifiableSet(os);
    }

	@Override
    public Set<VersionableName> getBrowsers() {
	    return Collections.unmodifiableSet(browsers);
    }

	@Override
    public Set<String> getPointingMethods() {
	    return Collections.unmodifiableSet(pointingMethods);
    }

}
