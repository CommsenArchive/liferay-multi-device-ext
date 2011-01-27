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
 * <p>
 * This class is a wrapper for {@link ThemeRule}.
 * </p>
 *
 * @author    Milen Dyankov
 * @see       ThemeRule
 * @generated
 */
public class ThemeRuleWrapper implements ThemeRule {
	public ThemeRuleWrapper(ThemeRule themeRule) {
		_themeRule = themeRule;
	}

	public long getPrimaryKey() {
		return _themeRule.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_themeRule.setPrimaryKey(pk);
	}

	public long getRid() {
		return _themeRule.getRid();
	}

	public void setRid(long rid) {
		_themeRule.setRid(rid);
	}

	public long getCompanyId() {
		return _themeRule.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_themeRule.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _themeRule.getGroupId();
	}

	public void setGroupId(long groupId) {
		_themeRule.setGroupId(groupId);
	}

	public java.lang.String getBrand() {
		return _themeRule.getBrand();
	}

	public void setBrand(java.lang.String brand) {
		_themeRule.setBrand(brand);
	}

	public java.lang.String getModel() {
		return _themeRule.getModel();
	}

	public void setModel(java.lang.String model) {
		_themeRule.setModel(model);
	}

	public java.lang.String getOs() {
		return _themeRule.getOs();
	}

	public void setOs(java.lang.String os) {
		_themeRule.setOs(os);
	}

	public java.lang.String getOsVersion() {
		return _themeRule.getOsVersion();
	}

	public void setOsVersion(java.lang.String osVersion) {
		_themeRule.setOsVersion(osVersion);
	}

	public java.lang.String getBrowser() {
		return _themeRule.getBrowser();
	}

	public void setBrowser(java.lang.String browser) {
		_themeRule.setBrowser(browser);
	}

	public java.lang.String getBrowserVersion() {
		return _themeRule.getBrowserVersion();
	}

	public void setBrowserVersion(java.lang.String browserVersion) {
		_themeRule.setBrowserVersion(browserVersion);
	}

	public java.lang.String getPointingMethod() {
		return _themeRule.getPointingMethod();
	}

	public void setPointingMethod(java.lang.String pointingMethod) {
		_themeRule.setPointingMethod(pointingMethod);
	}

	public java.lang.String getTablet() {
		return _themeRule.getTablet();
	}

	public void setTablet(java.lang.String tablet) {
		_themeRule.setTablet(tablet);
	}

	public java.lang.String getQwertyKeyboad() {
		return _themeRule.getQwertyKeyboad();
	}

	public void setQwertyKeyboad(java.lang.String qwertyKeyboad) {
		_themeRule.setQwertyKeyboad(qwertyKeyboad);
	}

	public java.lang.String getThemeId() {
		return _themeRule.getThemeId();
	}

	public void setThemeId(java.lang.String themeId) {
		_themeRule.setThemeId(themeId);
	}

	public java.lang.String getColorSchemeId() {
		return _themeRule.getColorSchemeId();
	}

	public void setColorSchemeId(java.lang.String colorSchemeId) {
		_themeRule.setColorSchemeId(colorSchemeId);
	}

	public int getPriority() {
		return _themeRule.getPriority();
	}

	public void setPriority(int priority) {
		_themeRule.setPriority(priority);
	}

	public com.commsen.liferay.multidevice.model.ThemeRule toEscapedModel() {
		return _themeRule.toEscapedModel();
	}

	public boolean isNew() {
		return _themeRule.isNew();
	}

	public void setNew(boolean n) {
		_themeRule.setNew(n);
	}

	public boolean isCachedModel() {
		return _themeRule.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_themeRule.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _themeRule.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_themeRule.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _themeRule.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _themeRule.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_themeRule.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _themeRule.clone();
	}

	public int compareTo(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule) {
		return _themeRule.compareTo(themeRule);
	}

	public int hashCode() {
		return _themeRule.hashCode();
	}

	public java.lang.String toString() {
		return _themeRule.toString();
	}

	public java.lang.String toXmlString() {
		return _themeRule.toXmlString();
	}

	public java.lang.String asText() {
		return _themeRule.asText();
	}

	public ThemeRule getWrappedThemeRule() {
		return _themeRule;
	}

	private ThemeRule _themeRule;
}