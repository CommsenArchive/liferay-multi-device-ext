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

package com.commsen.liferay.multidevice.model.impl;

import com.commsen.liferay.multidevice.model.ThemeRule;

/**
 * The model implementation for the ThemeRule service. Represents a row in the &quot;ThemeRule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.commsen.liferay.multidevice.model.ThemeRule} interface.
 * </p>
 *
 * <p>
 * Never reference this class directly. All methods that expect a theme rule model instance should use the {@link ThemeRule} interface instead.
 * </p>
 */
public class ThemeRuleImpl extends ThemeRuleModelImpl implements ThemeRule {
	public ThemeRuleImpl() {
	}
	
	public String asText () {
		boolean addAnd = false;
		StringBuilder text = new StringBuilder("When ");
		if (getBrand() != null) {
			if (addAnd) text.append(" and ");
			text.append(" brand is ").append(getBrand());
			addAnd = true;
		}
		if (getModel() != null) {
			if (addAnd) text.append(" and ");
			text.append(" model is ").append(getModel());
			addAnd = true;
		}
		if (getOs() != null) {
			if (addAnd) text.append(" and ");
			text.append(" operating system is ").append(getOs());
			addAnd = true;
			if (getOsVersion() != null) {
				text.append("(").append(getOsVersion()).append(") ");
				addAnd = true;
			}
		}
		if (getBrowser() != null) {
			if (addAnd) text.append(" and ");
			text.append(" browser is ").append(getBrowser());
			addAnd = true;
			if (getBrowserVersion() != null) {
				text.append("(").append(getBrowserVersion()).append(") ");
				addAnd = true;
			}
		}
		if (getPointingMethod() != null) {
			if (addAnd) text.append(" and ");
			text.append(" pointing method is ").append(getPointingMethod());
			addAnd = true;
		}
		if (getTablet() != null) {
			if (addAnd) text.append(" and ");
			if (Boolean.parseBoolean(getTablet())) {
				text.append(" device is tablet ");
			} else {
				text.append(" device is not tablet ");
			}
			addAnd = true;
		}
		if (getQwertyKeyboad() != null) {
			if (addAnd) text.append(" and ");
			if (Boolean.parseBoolean(getQwertyKeyboad())) {
				text.append(" device has qwerty keyboard ");
			} else {
				text.append(" device does not have qwerty keyboard ");
			}
			addAnd = true;
		}
		return text.toString();
	}
}