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

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * The utility for the theme rule remote service. This utility wraps {@link com.commsen.liferay.multidevice.service.impl.ThemeRuleServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.commsen.liferay.multidevice.service.impl.ThemeRuleServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Milen Dyankov
 * @see ThemeRuleService
 * @see com.commsen.liferay.multidevice.service.base.ThemeRuleServiceBaseImpl
 * @see com.commsen.liferay.multidevice.service.impl.ThemeRuleServiceImpl
 * @generated
 */
public class ThemeRuleServiceUtil {
	public static ThemeRuleService getService() {
		if (_service == null) {
			_service = (ThemeRuleService)PortalBeanLocatorUtil.locate(ThemeRuleService.class.getName());
		}

		return _service;
	}

	public void setService(ThemeRuleService service) {
		_service = service;
	}

	private static ThemeRuleService _service;
}