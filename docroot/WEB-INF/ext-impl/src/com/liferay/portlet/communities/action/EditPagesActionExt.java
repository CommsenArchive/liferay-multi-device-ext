package com.liferay.portlet.communities.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.commsen.liferay.multidevice.model.ThemeRule;
import com.commsen.liferay.multidevice.service.ThemeRuleLocalServiceUtil;
import com.commsen.liferay.multidevice.service.ThemeRuleServiceUtil;
import com.commsen.liferay.multidevice.service.persistence.ThemeRuleUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ColorScheme;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ThemeLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.communities.action.EditPagesAction;

public class EditPagesActionExt extends EditPagesAction {

	@Override
	public void processAction(ActionMapping mapping, ActionForm form ,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		try {
			checkPermissions(actionRequest);
		}
		catch (PrincipalException pe) {
			return;
		}

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (cmd.equals("save_theme_rule")) {
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long companyId = themeDisplay.getCompanyId();
			
			ThemeRule themeRule = ThemeRuleLocalServiceUtil.createThemeRule(CounterLocalServiceUtil.increment(ThemeRule.class.getName()));
			themeRule.setCompanyId(companyId);
			
			long liveGroupId = ParamUtil.getLong(actionRequest, "liveGroupId");
			long stagingGroupId = ParamUtil.getLong(actionRequest, "stagingGroupId");
			if (stagingGroupId > 0) {
				themeRule.setGroupId(stagingGroupId);
			} else {
				themeRule.setGroupId(liveGroupId);
			}

			boolean emptyRule = true;
			
			String tmp = ParamUtil.getString(actionRequest, "brand", null);
			if (!StringUtils.isBlank(tmp)) {
				emptyRule = false;
				themeRule.setBrand(tmp);
			}
			tmp = ParamUtil.getString(actionRequest, "model", null);
			if (!StringUtils.isBlank(tmp)) {
				emptyRule = false;
				themeRule.setModel(tmp);
			}
			tmp = ParamUtil.getString(actionRequest, "os", null);
			if (!StringUtils.isBlank(tmp)) {
				emptyRule = false;
				themeRule.setOs(tmp);
			}
			tmp = ParamUtil.getString(actionRequest, "osVersion", null);
			if (!StringUtils.isBlank(tmp)) {
				emptyRule = false;
				themeRule.setOsVersion(tmp);
			}
			tmp = ParamUtil.getString(actionRequest, "browser", null);
			if (!StringUtils.isBlank(tmp)) {
				emptyRule = false;
				themeRule.setBrowser(tmp);
			}
			tmp = ParamUtil.getString(actionRequest, "browserVersion", null);
			if (!StringUtils.isBlank(tmp)) {
				emptyRule = false;
				themeRule.setBrowserVersion(tmp);
			}
			tmp = ParamUtil.getString(actionRequest, "pointingMethod", null);
			if (!StringUtils.isBlank(tmp)) {
				emptyRule = false;
				themeRule.setPointingMethod(tmp);
			}
			tmp = ParamUtil.getString(actionRequest, "isTablet", null);
			if ("yes".equalsIgnoreCase(tmp)) {
				emptyRule = false;
				themeRule.setTablet(Boolean.TRUE.toString());
			} else if ("no".equalsIgnoreCase(tmp)) {
				emptyRule = false;
				themeRule.setTablet(Boolean.FALSE.toString());
			}
			tmp = ParamUtil.getString(actionRequest, "hasQwertyKeyboard", null);
			if ("yes".equalsIgnoreCase(tmp)) {
				emptyRule = false;
				themeRule.setQwertyKeyboad(Boolean.TRUE.toString());
			} else if ("no".equalsIgnoreCase(tmp)) {
				emptyRule = false;
				themeRule.setQwertyKeyboad(Boolean.FALSE.toString());
			}
			
			if (emptyRule) {
				SessionErrors.add(actionRequest, "rule-is-empty");
				setForward(actionRequest, "portlet.communities.error");
				return;
			}
			
			
			String themeId = ParamUtil.getString(actionRequest, "dynamicThemeId");
			String colorSchemeId = ParamUtil.getString(actionRequest, "dynamicColorSchemeId");
//			boolean wapTheme = ParamUtil.getBoolean(actionRequest, "wapTheme");
//			if (Validator.isNotNull(themeId) && Validator.isNull(colorSchemeId)) {
//				ColorScheme colorScheme = ThemeLocalServiceUtil.getColorScheme(companyId, themeId, colorSchemeId, wapTheme);
//				colorSchemeId = colorScheme.getColorSchemeId();
//			}

			themeRule.setThemeId(themeId);
			themeRule.setColorSchemeId(colorSchemeId);
			
			int priority = ParamUtil.getInteger(actionRequest, "rulePriority", 100);
			themeRule.setPriority(priority);
			
			
			ThemeRuleLocalServiceUtil.addThemeRule(themeRule);
			

		} else if (cmd.equals("delete_theme_rule")) {
			long ruleId = ParamUtil.getLong(actionRequest, "deleteRuleId");
			ThemeRuleLocalServiceUtil.deleteThemeRule(ruleId);
		}
		
		super.processAction(mapping, form, portletConfig, actionRequest, actionResponse);
	}
}
