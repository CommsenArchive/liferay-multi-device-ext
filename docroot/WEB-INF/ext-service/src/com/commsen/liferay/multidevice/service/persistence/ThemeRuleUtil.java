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

package com.commsen.liferay.multidevice.service.persistence;

import com.commsen.liferay.multidevice.model.ThemeRule;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the theme rule service. This utility wraps {@link ThemeRulePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Milen Dyankov
 * @see ThemeRulePersistence
 * @see ThemeRulePersistenceImpl
 * @generated
 */
public class ThemeRuleUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ThemeRule themeRule) {
		getPersistence().clearCache(themeRule);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ThemeRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ThemeRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ThemeRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static ThemeRule remove(ThemeRule themeRule)
		throws SystemException {
		return getPersistence().remove(themeRule);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ThemeRule update(ThemeRule themeRule, boolean merge)
		throws SystemException {
		return getPersistence().update(themeRule, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ThemeRule update(ThemeRule themeRule, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(themeRule, merge, serviceContext);
	}

	/**
	* Caches the theme rule in the entity cache if it is enabled.
	*
	* @param themeRule the theme rule to cache
	*/
	public static void cacheResult(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule) {
		getPersistence().cacheResult(themeRule);
	}

	/**
	* Caches the theme rules in the entity cache if it is enabled.
	*
	* @param themeRules the theme rules to cache
	*/
	public static void cacheResult(
		java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> themeRules) {
		getPersistence().cacheResult(themeRules);
	}

	/**
	* Creates a new theme rule with the primary key. Does not add the theme rule to the database.
	*
	* @param rid the primary key for the new theme rule
	* @return the new theme rule
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule create(
		long rid) {
		return getPersistence().create(rid);
	}

	/**
	* Removes the theme rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rid the primary key of the theme rule to remove
	* @return the theme rule that was removed
	* @throws com.commsen.liferay.multidevice.NoSuchThemeRuleException if a theme rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule remove(
		long rid)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(rid);
	}

	public static com.commsen.liferay.multidevice.model.ThemeRule updateImpl(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(themeRule, merge);
	}

	/**
	* Finds the theme rule with the primary key or throws a {@link com.commsen.liferay.multidevice.NoSuchThemeRuleException} if it could not be found.
	*
	* @param rid the primary key of the theme rule to find
	* @return the theme rule
	* @throws com.commsen.liferay.multidevice.NoSuchThemeRuleException if a theme rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule findByPrimaryKey(
		long rid)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(rid);
	}

	/**
	* Finds the theme rule with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rid the primary key of the theme rule to find
	* @return the theme rule, or <code>null</code> if a theme rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule fetchByPrimaryKey(
		long rid) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(rid);
	}

	/**
	* Finds all the theme rules where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @return the matching theme rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findByCompanyAndGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyAndGroup(companyId, groupId);
	}

	/**
	* Finds a range of all the theme rules where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @param start the lower bound of the range of theme rules to return
	* @param end the upper bound of the range of theme rules to return (not inclusive)
	* @return the range of matching theme rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findByCompanyAndGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndGroup(companyId, groupId, start, end);
	}

	/**
	* Finds an ordered range of all the theme rules where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @param start the lower bound of the range of theme rules to return
	* @param end the upper bound of the range of theme rules to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching theme rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findByCompanyAndGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Finds the first theme rule in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching theme rule
	* @throws com.commsen.liferay.multidevice.NoSuchThemeRuleException if a matching theme rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule findByCompanyAndGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Finds the last theme rule in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching theme rule
	* @throws com.commsen.liferay.multidevice.NoSuchThemeRuleException if a matching theme rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule findByCompanyAndGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Finds the theme rules before and after the current theme rule in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param rid the primary key of the current theme rule
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next theme rule
	* @throws com.commsen.liferay.multidevice.NoSuchThemeRuleException if a theme rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule[] findByCompanyAndGroup_PrevAndNext(
		long rid, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndGroup_PrevAndNext(rid, companyId, groupId,
			orderByComparator);
	}

	/**
	* Finds all the theme rules where companyId = &#63; and groupId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @param brand the brand to search with
	* @param model the model to search with
	* @param os the os to search with
	* @param osVersion the os version to search with
	* @param browser the browser to search with
	* @param browserVersion the browser version to search with
	* @param pointingMethod the pointing method to search with
	* @param tablet the tablet to search with
	* @param qwertyKeyboad the qwerty keyboad to search with
	* @return the matching theme rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findByConditions(
		long companyId, long groupId, java.lang.String brand,
		java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConditions(companyId, groupId, brand, model, os,
			osVersion, browser, browserVersion, pointingMethod, tablet,
			qwertyKeyboad);
	}

	/**
	* Finds a range of all the theme rules where companyId = &#63; and groupId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @param brand the brand to search with
	* @param model the model to search with
	* @param os the os to search with
	* @param osVersion the os version to search with
	* @param browser the browser to search with
	* @param browserVersion the browser version to search with
	* @param pointingMethod the pointing method to search with
	* @param tablet the tablet to search with
	* @param qwertyKeyboad the qwerty keyboad to search with
	* @param start the lower bound of the range of theme rules to return
	* @param end the upper bound of the range of theme rules to return (not inclusive)
	* @return the range of matching theme rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findByConditions(
		long companyId, long groupId, java.lang.String brand,
		java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConditions(companyId, groupId, brand, model, os,
			osVersion, browser, browserVersion, pointingMethod, tablet,
			qwertyKeyboad, start, end);
	}

	/**
	* Finds an ordered range of all the theme rules where companyId = &#63; and groupId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @param brand the brand to search with
	* @param model the model to search with
	* @param os the os to search with
	* @param osVersion the os version to search with
	* @param browser the browser to search with
	* @param browserVersion the browser version to search with
	* @param pointingMethod the pointing method to search with
	* @param tablet the tablet to search with
	* @param qwertyKeyboad the qwerty keyboad to search with
	* @param start the lower bound of the range of theme rules to return
	* @param end the upper bound of the range of theme rules to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching theme rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findByConditions(
		long companyId, long groupId, java.lang.String brand,
		java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConditions(companyId, groupId, brand, model, os,
			osVersion, browser, browserVersion, pointingMethod, tablet,
			qwertyKeyboad, start, end, orderByComparator);
	}

	/**
	* Finds the first theme rule in the ordered set where companyId = &#63; and groupId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @param brand the brand to search with
	* @param model the model to search with
	* @param os the os to search with
	* @param osVersion the os version to search with
	* @param browser the browser to search with
	* @param browserVersion the browser version to search with
	* @param pointingMethod the pointing method to search with
	* @param tablet the tablet to search with
	* @param qwertyKeyboad the qwerty keyboad to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching theme rule
	* @throws com.commsen.liferay.multidevice.NoSuchThemeRuleException if a matching theme rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule findByConditions_First(
		long companyId, long groupId, java.lang.String brand,
		java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConditions_First(companyId, groupId, brand, model,
			os, osVersion, browser, browserVersion, pointingMethod, tablet,
			qwertyKeyboad, orderByComparator);
	}

	/**
	* Finds the last theme rule in the ordered set where companyId = &#63; and groupId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @param brand the brand to search with
	* @param model the model to search with
	* @param os the os to search with
	* @param osVersion the os version to search with
	* @param browser the browser to search with
	* @param browserVersion the browser version to search with
	* @param pointingMethod the pointing method to search with
	* @param tablet the tablet to search with
	* @param qwertyKeyboad the qwerty keyboad to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching theme rule
	* @throws com.commsen.liferay.multidevice.NoSuchThemeRuleException if a matching theme rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule findByConditions_Last(
		long companyId, long groupId, java.lang.String brand,
		java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConditions_Last(companyId, groupId, brand, model, os,
			osVersion, browser, browserVersion, pointingMethod, tablet,
			qwertyKeyboad, orderByComparator);
	}

	/**
	* Finds the theme rules before and after the current theme rule in the ordered set where companyId = &#63; and groupId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param rid the primary key of the current theme rule
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @param brand the brand to search with
	* @param model the model to search with
	* @param os the os to search with
	* @param osVersion the os version to search with
	* @param browser the browser to search with
	* @param browserVersion the browser version to search with
	* @param pointingMethod the pointing method to search with
	* @param tablet the tablet to search with
	* @param qwertyKeyboad the qwerty keyboad to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next theme rule
	* @throws com.commsen.liferay.multidevice.NoSuchThemeRuleException if a theme rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.commsen.liferay.multidevice.model.ThemeRule[] findByConditions_PrevAndNext(
		long rid, long companyId, long groupId, java.lang.String brand,
		java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConditions_PrevAndNext(rid, companyId, groupId,
			brand, model, os, osVersion, browser, browserVersion,
			pointingMethod, tablet, qwertyKeyboad, orderByComparator);
	}

	/**
	* Finds all the theme rules.
	*
	* @return the theme rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the theme rules.
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
	public static java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the theme rules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of theme rules to return
	* @param end the upper bound of the range of theme rules to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of theme rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the theme rules where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyAndGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyAndGroup(companyId, groupId);
	}

	/**
	* Removes all the theme rules where companyId = &#63; and groupId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @param brand the brand to search with
	* @param model the model to search with
	* @param os the os to search with
	* @param osVersion the os version to search with
	* @param browser the browser to search with
	* @param browserVersion the browser version to search with
	* @param pointingMethod the pointing method to search with
	* @param tablet the tablet to search with
	* @param qwertyKeyboad the qwerty keyboad to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByConditions(long companyId, long groupId,
		java.lang.String brand, java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByConditions(companyId, groupId, brand, model, os,
			osVersion, browser, browserVersion, pointingMethod, tablet,
			qwertyKeyboad);
	}

	/**
	* Removes all the theme rules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the theme rules where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @return the number of matching theme rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyAndGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyAndGroup(companyId, groupId);
	}

	/**
	* Counts all the theme rules where companyId = &#63; and groupId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @param brand the brand to search with
	* @param model the model to search with
	* @param os the os to search with
	* @param osVersion the os version to search with
	* @param browser the browser to search with
	* @param browserVersion the browser version to search with
	* @param pointingMethod the pointing method to search with
	* @param tablet the tablet to search with
	* @param qwertyKeyboad the qwerty keyboad to search with
	* @return the number of matching theme rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByConditions(long companyId, long groupId,
		java.lang.String brand, java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByConditions(companyId, groupId, brand, model, os,
			osVersion, browser, browserVersion, pointingMethod, tablet,
			qwertyKeyboad);
	}

	/**
	* Counts all the theme rules.
	*
	* @return the number of theme rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ThemeRulePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ThemeRulePersistence)PortalBeanLocatorUtil.locate(ThemeRulePersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(ThemeRulePersistence persistence) {
		_persistence = persistence;
	}

	private static ThemeRulePersistence _persistence;
}