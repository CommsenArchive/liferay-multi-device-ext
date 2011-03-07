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

import java.util.List;

import javax.portlet.PortletRequest;

import com.commsen.liferay.multidevice.Device;
import com.commsen.liferay.multidevice.rules.actions.DeviceAction;

/**
 * 
 * @author Milen Dyankov
 * 
 */
public interface DeviceRulesProvider {

	/**
	 * Returns theme and color scheme based on rules configured for given device
	 * 
	 * @param device user's device
	 * @param companyId current portal instance id
	 * @param groupId current community/organization id
	 * @param layoutId current page id
	 * 
	 * @return portal theme and color scheme to apply
	 */
	public DeviceAction getAction(Device device, long companyId, long groupId, long layoutId);


	/**
	 * Returns a list of rules all matching current company, group and layout.
	 * 
	 * @param companyId current portal instance id
	 * @param groupId current community/organization id
	 * @param layoutId current page id
	 * 
	 * @return list of rules all matching current company, group and layout.
	 */
	public List<RuleInfo> getRules(long companyId, long groupId, long layoutId);

	
	/**
	 * Attempts to recognize and handle appropriately rule requests (for example add/delete rule requests)
	 * 
	 * @param request user's request 
	 * @return list of error messages
	 */
	public List<String> handleRulesRequest(PortletRequest request);

}
