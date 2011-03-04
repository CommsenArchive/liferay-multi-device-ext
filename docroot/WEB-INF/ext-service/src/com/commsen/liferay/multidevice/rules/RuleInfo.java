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
package com.commsen.liferay.multidevice.rules;

import com.commsen.liferay.multidevice.rules.actions.DeviceAction;


/**
 * @author Milen Dyankov
 *
 */
public class RuleInfo {

	private long id;

	private String text;
	
	private int priority;
	
	private DeviceAction deviceAction;

	
	public RuleInfo(long id, String text, int priority, DeviceAction deviceAction) {
	    super();
	    this.id = id;
	    this.text = text;
	    this.priority = priority;
	    this.deviceAction = deviceAction;
    }

	public String getText() {
    	return text;
    }

	public int getPriority() {
    	return priority;
    }

	public DeviceAction getDeviceAction() {
    	return deviceAction;
    }

	public long getId() {
    	return id;
    }
}
