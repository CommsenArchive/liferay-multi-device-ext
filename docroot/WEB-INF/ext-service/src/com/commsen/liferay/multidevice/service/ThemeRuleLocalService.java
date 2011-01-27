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

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the theme rule local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ThemeRuleLocalServiceUtil} to access the theme rule local service. Add custom service methods to {@link com.commsen.liferay.multidevice.service.impl.ThemeRuleLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Milen Dyankov
 * @see ThemeRuleLocalServiceUtil
 * @see com.commsen.liferay.multidevice.service.base.ThemeRuleLocalServiceBaseImpl
 * @see com.commsen.liferay.multidevice.service.impl.ThemeRuleLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ThemeRuleLocalService {
	/**
	* Adds the theme rule to the database. Also notifies the appropriate model listeners.
	*
	* @param themeRule the theme rule to add
	* @return the theme rule that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.commsen.liferay.multidevice.model.ThemeRule addThemeRule(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new theme rule with the primary key. Does not add the theme rule to the database.
	*
	* @param rid the primary key for the new theme rule
	* @return the new theme rule
	*/
	public com.commsen.liferay.multidevice.model.ThemeRule createThemeRule(
		long rid);

	/**
	* Deletes the theme rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rid the primary key of the theme rule to delete
	* @throws PortalException if a theme rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteThemeRule(long rid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the theme rule from the database. Also notifies the appropriate model listeners.
	*
	* @param themeRule the theme rule to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteThemeRule(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the theme rule with the primary key.
	*
	* @param rid the primary key of the theme rule to get
	* @return the theme rule
	* @throws PortalException if a theme rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.commsen.liferay.multidevice.model.ThemeRule getThemeRule(
		long rid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> getThemeRules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of theme rules.
	*
	* @return the number of theme rules
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getThemeRulesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the theme rule in the database. Also notifies the appropriate model listeners.
	*
	* @param themeRule the theme rule to update
	* @return the theme rule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.commsen.liferay.multidevice.model.ThemeRule updateThemeRule(
		com.commsen.liferay.multidevice.model.ThemeRule themeRule)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> getRules(
		long companyId, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.commsen.liferay.multidevice.model.ThemeRule> getMatchingRules(
		long companyId, long groupId,
		com.commsen.liferay.multidevice.Device device);
}