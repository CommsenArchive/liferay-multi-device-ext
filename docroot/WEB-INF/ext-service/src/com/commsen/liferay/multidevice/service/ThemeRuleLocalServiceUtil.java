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
 * The utility for the theme rule local service. This utility wraps {@link com.commsen.liferay.multidevice.service.impl.ThemeRuleLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.commsen.liferay.multidevice.service.impl.ThemeRuleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Milen Dyankov
 * @see ThemeRuleLocalService
 * @see com.commsen.liferay.multidevice.service.base.ThemeRuleLocalServiceBaseImpl
 * @see com.commsen.liferay.multidevice.service.impl.ThemeRuleLocalServiceImpl
 * @generated
 */
public class ThemeRuleLocalServiceUtil {
	/**
	* Adds the theme rule to the database. Also notifies the appropriate model listeners.
	*
	* @param themeRule the theme rule to add
	* @return the theme rule that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule addThemeRule(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addThemeRule(themeRule);
	}

	/**
	* Creates a new theme rule with the primary key. Does not add the theme rule to the database.
	*
	* @param rid the primary key for the new theme rule
	* @return the new theme rule
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule createThemeRule(
		long rid) {
		return getService().createThemeRule(rid);
	}

	/**
	* Deletes the theme rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rid the primary key of the theme rule to delete
	* @throws PortalException if a theme rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteThemeRule(long rid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThemeRule(rid);
	}

	/**
	* Deletes the theme rule from the database. Also notifies the appropriate model listeners.
	*
	* @param themeRule the theme rule to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteThemeRule(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThemeRule(themeRule);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the theme rule with the primary key.
	*
	* @param rid the primary key of the theme rule to get
	* @return the theme rule
	* @throws PortalException if a theme rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule getThemeRule(
		long rid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getThemeRule(rid);
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
	public static java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> getThemeRules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThemeRules(start, end);
	}

	/**
	* Gets the number of theme rules.
	*
	* @return the number of theme rules
	* @throws SystemException if a system exception occurred
	*/
	public static int getThemeRulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThemeRulesCount();
	}

	/**
	* Updates the theme rule in the database. Also notifies the appropriate model listeners.
	*
	* @param themeRule the theme rule to update
	* @return the theme rule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule updateThemeRule(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateThemeRule(themeRule);
	}

	/**
	* Updates the theme rule in the database. Also notifies the appropriate model listeners.
	*
	* @param themeRule the theme rule to update
	* @param merge whether to merge the theme rule with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the theme rule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule updateThemeRule(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateThemeRule(themeRule, merge);
	}

	public static java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> getRules(
		long companyId, long groupId) {
		return getService().getRules(companyId, groupId);
	}

	public static java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> getMatchingRules(
		long companyId, long groupId,
		com.commsen.liferay.multidevice.Device device) {
		return getService().getMatchingRules(companyId, groupId, device);
	}

	public static ThemeRuleLocalService getService() {
		if (_service == null) {
			_service = (ThemeRuleLocalService)PortalBeanLocatorUtil.locate(ThemeRuleLocalService.class.getName());
		}

		return _service;
	}

	public void setService(ThemeRuleLocalService service) {
		_service = service;
	}

	private static ThemeRuleLocalService _service;
}