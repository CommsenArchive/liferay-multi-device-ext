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

package com.commsen.liferay.multidevice.service.http;

import com.commsen.liferay.multidevice.model.ThemeRule;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

/**
 * @author    Milen Dyankov
 * @generated
 */
public class ThemeRuleJSONSerializer {
	public static JSONObject toJSONObject(ThemeRule model) {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("rid", model.getRid());
		jsonObj.put("companyId", model.getCompanyId());
		jsonObj.put("groupId", model.getGroupId());
		jsonObj.put("brand", model.getBrand());
		jsonObj.put("model", model.getModel());
		jsonObj.put("os", model.getOs());
		jsonObj.put("osVersion", model.getOsVersion());
		jsonObj.put("browser", model.getBrowser());
		jsonObj.put("browserVersion", model.getBrowserVersion());
		jsonObj.put("pointingMethod", model.getPointingMethod());
		jsonObj.put("tablet", model.getTablet());
		jsonObj.put("qwertyKeyboad", model.getQwertyKeyboad());
		jsonObj.put("themeId", model.getThemeId());
		jsonObj.put("colorSchemeId", model.getColorSchemeId());
		jsonObj.put("priority", model.getPriority());

		return jsonObj;
	}

	public static JSONArray toJSONArray(
		com.commsen.liferay.multidevice.model.ThemeRule[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ThemeRule model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.commsen.liferay.multidevice.model.ThemeRule[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ThemeRule[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.commsen.liferay.multidevice.model.ThemeRule> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ThemeRule model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}