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
package com.liferay.portlet.grouppages.action;

import javax.portlet.PortletRequest;

import com.liferay.portal.model.Group;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;

/**
 * @author Milen Dyankov
 * 
 */
public class MultideviceEditPagesAction extends com.liferay.portlet.communities.action.MultideviceEditPagesAction {
	protected Group getGroup(PortletRequest portletRequest) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Group group = themeDisplay.getScopeGroup();

		portletRequest.setAttribute(WebKeys.GROUP, group);

		return group;
	}
}