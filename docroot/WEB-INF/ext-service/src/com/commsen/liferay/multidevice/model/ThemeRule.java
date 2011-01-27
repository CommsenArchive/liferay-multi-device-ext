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

package com.commsen.liferay.multidevice.model;

/**
 * The model interface for the ThemeRule service. Represents a row in the &quot;ThemeRule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.commsen.liferay.multidevice.model.impl.ThemeRuleImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. All methods that expect a theme rule model instance should use the {@link ThemeRule} interface instead.
 * </p>
 *
 * @author Milen Dyankov
 * @see ThemeRuleModel
 * @see com.commsen.liferay.multidevice.model.impl.ThemeRuleImpl
 * @see com.commsen.liferay.multidevice.model.impl.ThemeRuleModelImpl
 * @generated
 */
public interface ThemeRule extends ThemeRuleModel {
	public java.lang.String asText();
}