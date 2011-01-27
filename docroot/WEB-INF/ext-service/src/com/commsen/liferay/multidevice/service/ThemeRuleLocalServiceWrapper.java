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
 * This class is a wrapper for {@link ThemeRuleLocalService}.
 * </p>
 *
 * @author    Milen Dyankov
 * @see       ThemeRuleLocalService
 * @generated
 */
public class ThemeRuleLocalServiceWrapper implements ThemeRuleLocalService {
	public ThemeRuleLocalServiceWrapper(
		ThemeRuleLocalService themeRuleLocalService) {
		_themeRuleLocalService = themeRuleLocalService;
	}

	/**
	* Adds the theme rule to the database. Also notifies the appropriate model listeners.
	*
	* @param themeRule the theme rule to add
	* @return the theme rule that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.commsen.liferay.multidevice.model.ThemeRule addThemeRule(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _themeRuleLocalService.addThemeRule(themeRule);
	}

	/**
	* Creates a new theme rule with the primary key. Does not add the theme rule to the database.
	*
	* @param rid the primary key for the new theme rule
	* @return the new theme rule
	*/
	public com.commsen.liferay.multidevice.model.ThemeRule createThemeRule(
		long rid) {
		return _themeRuleLocalService.createThemeRule(rid);
	}

	/**
	* Deletes the theme rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rid the primary key of the theme rule to delete
	* @throws PortalException if a theme rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteThemeRule(long rid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_themeRuleLocalService.deleteThemeRule(rid);
	}

	/**
	* Deletes the theme rule from the database. Also notifies the appropriate model listeners.
	*
	* @param themeRule the theme rule to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteThemeRule(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		_themeRuleLocalService.deleteThemeRule(themeRule);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _themeRuleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _themeRuleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _themeRuleLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _themeRuleLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the theme rule with the primary key.
	*
	* @param rid the primary key of the theme rule to get
	* @return the theme rule
	* @throws PortalException if a theme rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.commsen.liferay.multidevice.model.ThemeRule getThemeRule(
		long rid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _themeRuleLocalService.getThemeRule(rid);
	}

	/**
	* Gets a range of all the theme rules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of theme rules to return
	* @param end the upper bound of the range of theme rules to return (not inclusive)
	* @return the range of theme rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> getThemeRules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _themeRuleLocalService.getThemeRules(start, end);
	}

	/**
	* Gets the number of theme rules.
	*
	* @return the number of theme rules
	* @throws SystemException if a system exception occurred
	*/
	public int getThemeRulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _themeRuleLocalService.getThemeRulesCount();
	}

	/**
	* Updates the theme rule in the database. Also notifies the appropriate model listeners.
	*
	* @param themeRule the theme rule to update
	* @return the theme rule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.commsen.liferay.multidevice.model.ThemeRule updateThemeRule(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _themeRuleLocalService.updateThemeRule(themeRule);
	}

	/**
	* Updates the theme rule in the database. Also notifies the appropriate model listeners.
	*
	* @param themeRule the theme rule to update
	* @param merge whether to merge the theme rule with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the theme rule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.commsen.liferay.multidevice.model.ThemeRule updateThemeRule(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _themeRuleLocalService.updateThemeRule(themeRule, merge);
	}

	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> getRules(
		long companyId, long groupId) {
		return _themeRuleLocalService.getRules(companyId, groupId);
	}

	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> getMatchingRules(
		long companyId, long groupId,
		com.commsen.liferay.multidevice.Device device) {
		return _themeRuleLocalService.getMatchingRules(companyId, groupId,
			device);
	}

	public ThemeRuleLocalService getWrappedThemeRuleLocalService() {
		return _themeRuleLocalService;
	}

	private ThemeRuleLocalService _themeRuleLocalService;
}