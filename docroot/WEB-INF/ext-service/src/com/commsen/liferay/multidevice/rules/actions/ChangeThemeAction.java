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
package com.commsen.liferay.multidevice.rules.actions;

import com.commsen.liferay.multidevice.rules.ThemeAndColorScheme;


/**
 * @author Milen Dyankov
 *
 */
public class ChangeThemeAction extends DeviceAction {

	private ThemeAndColorScheme themeAndColorScheme;

	public static final String NAME = "change theme"; 
	
	/**
	 * 
	 * @param ruleAction
	 * @param themeAndColorScheme
	 */
	public ChangeThemeAction(ThemeAndColorScheme themeAndColorScheme) {
	    this.themeAndColorScheme = themeAndColorScheme;
    }

	public ThemeAndColorScheme getThemeAndColorScheme() {
    	return themeAndColorScheme;
    }

}
