/**
 * Copyright (c) COMMSEN International. All rights reserved.
 *	
 * This library is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library.  If not, see http://www.gnu.org/licenses/lgpl.html.
 */
package com.liferay.portlet.communities.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.commsen.liferay.multidevice.rules.DeviceRulesUtil;
import com.liferay.portal.ImageTypeException;
import com.liferay.portal.LayoutFriendlyURLException;
import com.liferay.portal.LayoutHiddenException;
import com.liferay.portal.LayoutNameException;
import com.liferay.portal.LayoutParentLayoutIdException;
import com.liferay.portal.LayoutSetVirtualHostException;
import com.liferay.portal.LayoutTypeException;
import com.liferay.portal.NoSuchLayoutException;
import com.liferay.portal.RemoteExportException;
import com.liferay.portal.RemoteOptionsException;
import com.liferay.portal.RequiredLayoutException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.staging.StagingUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.communities.util.CommunitiesUtil;
import com.liferay.portlet.tasks.NoSuchProposalException;
import com.liferay.util.servlet.UploadException;

/**
 * @author Milen Dyankov
 * 
 */
public class MultideviceEditPagesAction extends EditPagesAction {
	/*
	 * (non-Javadoc)
	 * @see
	 * com.liferay.portlet.communities.action.EditPagesAction#processAction(org.apache.struts.action
	 * .ActionMapping, org.apache.struts.action.ActionForm, javax.portlet.PortletConfig,
	 * javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	@Override
	public void processAction(ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
	        ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		try {
			checkPermissions(actionRequest);
		} catch (PrincipalException pe) {
			return;
		}

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			Layout layout = null;
			String oldFriendlyURL = StringPool.BLANK;

			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				Object[] returnValue = updateLayout(actionRequest, actionResponse);

				layout = (Layout) returnValue[0];
				oldFriendlyURL = (String) returnValue[1];
			} else if (cmd.equals(Constants.DELETE)) {
				CommunitiesUtil.deleteLayout(actionRequest, actionResponse);
			} else if (cmd.equals("copy_from_live")) {
				StagingUtil.copyFromLive(actionRequest);
			} else if (cmd.equals("display_order")) {
				updateDisplayOrder(actionRequest);
			} else if (cmd.equals("logo")) {
				updateLogo(actionRequest);
			} else if (cmd.equals("look_and_feel")) {
				updateLookAndFeel(actionRequest);
			} else if (cmd.equals("merge_pages")) {
				updateMergePages(actionRequest);
			} else if (cmd.equals("monitoring")) {
				updateMonitoring(actionRequest);
			} else if (cmd.equals("publish_to_live")) {
				StagingUtil.publishToLive(actionRequest);
			} else if (cmd.equals("publish_to_remote")) {
				StagingUtil.publishToRemote(actionRequest);
			} else if (cmd.equals("schedule_copy_from_live")) {
				StagingUtil.scheduleCopyFromLive(actionRequest);
			} else if (cmd.equals("schedule_publish_to_live")) {
				StagingUtil.schedulePublishToLive(actionRequest);
			} else if (cmd.equals("schedule_publish_to_remote")) {
				StagingUtil.schedulePublishToRemote(actionRequest);
			} else if (cmd.equals("staging")) {
				StagingUtil.updateStaging(actionRequest);
			} else if (cmd.equals("unschedule_copy_from_live")) {
				StagingUtil.unscheduleCopyFromLive(actionRequest);
			} else if (cmd.equals("unschedule_publish_to_live")) {
				StagingUtil.unschedulePublishToLive(actionRequest);
			} else if (cmd.equals("unschedule_publish_to_remote")) {
				StagingUtil.unschedulePublishToRemote(actionRequest);
			} else if (cmd.equals("virtual_host")) {
				updateVirtualHost(actionRequest);
			} else {
				List<String> errors = DeviceRulesUtil.handleRulesRequest(actionRequest);
				if (!errors.isEmpty()) {
					for (String error : errors) {
						SessionErrors.add(actionRequest, error);
                    }
				}
			}

			String redirect = (String) actionRequest.getAttribute(WebKeys.REDIRECT);

			if (Validator.isNull(redirect)) {
				redirect = ParamUtil.getString(actionRequest, "pagesRedirect");
			}

			if ((layout != null) && Validator.isNotNull(oldFriendlyURL)) {
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

				if (layout.getPlid() == themeDisplay.getPlid()) {
					Group group = layout.getGroup();

					String oldPath = group.getFriendlyURL() + oldFriendlyURL;
					String newPath = group.getFriendlyURL() + layout.getFriendlyURL();

					redirect = StringUtil.replace(redirect, oldPath, newPath);

					redirect = StringUtil.replace(redirect, HttpUtil.encodeURL(oldPath), HttpUtil.encodeURL(newPath));
				}
			}

			sendRedirect(actionRequest, actionResponse, redirect);
		} catch (Exception e) {
			if (e instanceof NoSuchLayoutException || e instanceof NoSuchProposalException
			        || e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.communities.error");
			} else if (e instanceof ImageTypeException || e instanceof LayoutFriendlyURLException
			        || e instanceof LayoutHiddenException || e instanceof LayoutNameException
			        || e instanceof LayoutParentLayoutIdException || e instanceof LayoutSetVirtualHostException
			        || e instanceof LayoutTypeException || e instanceof RequiredLayoutException
			        || e instanceof UploadException) {

				if (e instanceof LayoutFriendlyURLException) {
					SessionErrors.add(actionRequest, LayoutFriendlyURLException.class.getName(), e);
				} else {
					SessionErrors.add(actionRequest, e.getClass().getName(), e);
				}
			} else if (e instanceof RemoteExportException || e instanceof RemoteOptionsException
			        || e instanceof SystemException) {

				SessionErrors.add(actionRequest, e.getClass().getName(), e);

				String redirect = ParamUtil.getString(actionRequest, "pagesRedirect");

				sendRedirect(actionRequest, actionResponse, redirect);
			} else {
				throw e;
			}
		}
	}
}