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
package com.commsen.liferay.multidevice.command;

import com.commsen.liferay.multidevice.Device;

/**
 * @author Milen Dyankov
 *
 */
public class ActionForDeviceCommand extends DeviceCommand {
	
	public ActionForDeviceCommand(Device device, long companyId, long groupId, long layoutId) {
	    super();
	    this.device = device;
	    this.companyId = companyId;
	    this.groupId = groupId;
	    this.layoutId = layoutId;
    }
}
