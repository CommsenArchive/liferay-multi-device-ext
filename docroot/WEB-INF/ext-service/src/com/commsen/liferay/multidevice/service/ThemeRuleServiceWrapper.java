/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.commsen.liferay.multidevice.service;

/**
 * <p>
 * This class is a wrapper for {@link ThemeRuleService}.
 * </p>
 *
 * @author    Milen Dyankov
 * @see       ThemeRuleService
 * @generated
 */
public class ThemeRuleServiceWrapper implements ThemeRuleService {
	public ThemeRuleServiceWrapper(ThemeRuleService themeRuleService) {
		_themeRuleService = themeRuleService;
	}

	public ThemeRuleService getWrappedThemeRuleService() {
		return _themeRuleService;
	}

	private ThemeRuleService _themeRuleService;
}