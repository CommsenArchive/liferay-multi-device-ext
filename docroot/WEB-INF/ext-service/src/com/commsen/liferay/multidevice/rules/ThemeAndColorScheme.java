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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ColorScheme;
import com.liferay.portal.model.Theme;
import com.liferay.portal.service.ThemeLocalServiceUtil;

/**
 * @author Milen Dyankov
 *
 */
public class ThemeAndColorScheme {

	private String themeId;
	private String colorSchemeId;
	
	/**
	 * 
	 * @param themeId
	 * @param colorSchemeId
	 */
	public ThemeAndColorScheme(String themeId, String colorSchemeId) {
	    super();
	    this.themeId = themeId;
	    this.colorSchemeId = colorSchemeId;
    }

	public String getThemeId() {
    	return themeId;
    }

	public String getColorSchemeId() {
    	return colorSchemeId;
    }
	
	public Theme getTheme (long companyId) throws SystemException {
		return getTheme(companyId, false);
	}

	public Theme getTheme (long companyId, boolean isWap) throws SystemException {
		if (themeId == null) return null;
		return ThemeLocalServiceUtil.getTheme(companyId, themeId, isWap);
	}

	public ColorScheme getColorScheme (long companyId) throws SystemException {
		return getColorScheme(companyId, false);
	}

	public ColorScheme getColorScheme (long companyId, boolean isWap) throws SystemException {
		if (themeId == null || colorSchemeId == null) return null;
		return ThemeLocalServiceUtil.getColorScheme(companyId, themeId, colorSchemeId, isWap);
	}
	
}
