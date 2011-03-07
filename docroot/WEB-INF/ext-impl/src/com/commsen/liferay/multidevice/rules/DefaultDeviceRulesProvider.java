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

import java.util.Collections;
import java.util.List;

import javax.portlet.PortletRequest;

import com.commsen.liferay.multidevice.Device;
import com.commsen.liferay.multidevice.rules.actions.DeviceAction;
import com.commsen.liferay.multidevice.rules.actions.NoAction;

/**
 * @author Milen Dyankov
 *
 */
public class DefaultDeviceRulesProvider implements DeviceRulesProvider {

	/* (non-Javadoc)
     * @see com.commsen.liferay.multidevice.rules.themes.ThemeSelectingProvider#getThemeAndColorScheme(com.commsen.liferay.multidevice.Device)
     */
    @Override
    public DeviceAction getAction(Device device, long companyId, long groupId, long pageId) {
    	return new NoAction();
    }

	/* (non-Javadoc)
     * @see com.commsen.liferay.multidevice.rules.themes.ThemeSelectingProvider#getThemeRulesInfo(long, long, long)
     */
    @Override
    public List<RuleInfo> getRules(long companyId, long groupId, long layoutId) {
	    return Collections.emptyList();
    }

	/* (non-Javadoc)
     * @see com.commsen.liferay.multidevice.rules.DeviceRulesProvider#handleRulesRequest(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public List<String> handleRulesRequest(PortletRequest request) {
	    return Collections.emptyList();
    }

}
