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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the theme rule service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ThemeRuleUtil} to access the theme rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Milen Dyankov
 * @see ThemeRulePersistenceImpl
 * @see ThemeRuleUtil
 * @generated
 */
public interface ThemeRulePersistence extends BasePersistence<ThemeRule> {
	/**
	* Caches the theme rule in the entity cache if it is enabled.
	*
	* @param themeRule the theme rule to cache
	*/
	public void cacheResult(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule);

	/**
	* Caches the theme rules in the entity cache if it is enabled.
	*
	* @param themeRules the theme rules to cache
	*/
	public void cacheResult(
		java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> themeRules);

	/**
	* Creates a new theme rule with the primary key. Does not add the theme rule to the database.
	*
	* @param rid the primary key for the new theme rule
	* @return the new theme rule
	*/
	public com.commsen.liferay.multidevice.model.ThemeRule create(long rid);

	/**
	* Removes the theme rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rid the primary key of the theme rule to remove
	* @return the theme rule that was removed
	* @throws com.commsen.liferay.multidevice.NoSuchThemeRuleException if a theme rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.commsen.liferay.multidevice.model.ThemeRule remove(long rid)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.commsen.liferay.multidevice.model.ThemeRule updateImpl(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the theme rule with the primary key or throws a {@link com.commsen.liferay.multidevice.NoSuchThemeRuleException} if it could not be found.
	*
	* @param rid the primary key of the theme rule to find
	* @return the theme rule
	* @throws com.commsen.liferay.multidevice.NoSuchThemeRuleException if a theme rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.commsen.liferay.multidevice.model.ThemeRule findByPrimaryKey(
		long rid)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the theme rule with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rid the primary key of the theme rule to find
	* @return the theme rule, or <code>null</code> if a theme rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.commsen.liferay.multidevice.model.ThemeRule fetchByPrimaryKey(
		long rid) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the theme rules where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @return the matching theme rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findByCompanyAndGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findByCompanyAndGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findByCompanyAndGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.commsen.liferay.multidevice.model.ThemeRule findByCompanyAndGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.commsen.liferay.multidevice.model.ThemeRule findByCompanyAndGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.commsen.liferay.multidevice.model.ThemeRule[] findByCompanyAndGroup_PrevAndNext(
		long rid, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findByConditions(
		long companyId, long groupId, java.lang.String brand,
		java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findByConditions(
		long companyId, long groupId, java.lang.String brand,
		java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findByConditions(
		long companyId, long groupId, java.lang.String brand,
		java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.commsen.liferay.multidevice.model.ThemeRule findByConditions_First(
		long companyId, long groupId, java.lang.String brand,
		java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.commsen.liferay.multidevice.model.ThemeRule findByConditions_Last(
		long companyId, long groupId, java.lang.String brand,
		java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.commsen.liferay.multidevice.model.ThemeRule[] findByConditions_PrevAndNext(
		long rid, long companyId, long groupId, java.lang.String brand,
		java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.commsen.liferay.multidevice.NoSuchThemeRuleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the theme rules.
	*
	* @return the theme rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the theme rules where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyAndGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public void removeByConditions(long companyId, long groupId,
		java.lang.String brand, java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the theme rules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the theme rules where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company id to search with
	* @param groupId the group id to search with
	* @return the number of matching theme rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyAndGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByConditions(long companyId, long groupId,
		java.lang.String brand, java.lang.String model, java.lang.String os,
		java.lang.String osVersion, java.lang.String browser,
		java.lang.String browserVersion, java.lang.String pointingMethod,
		java.lang.String tablet, java.lang.String qwertyKeyboad)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the theme rules.
	*
	* @return the number of theme rules
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}