<%
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
%>

<%@ include file="/html/portlet/communities/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "public-pages");
String tabs2 = ParamUtil.getString(request, "tabs2");
String tabs3 = ParamUtil.getString(request, "tabs3");
String tabs4 = ParamUtil.getString(request, "tabs4");

String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL", redirect);

if (portletName.equals(PortletKeys.LAYOUT_MANAGEMENT) || portletName.equals(PortletKeys.MY_ACCOUNT)) {
	portletDisplay.setURLBack(backURL);
}

if (portletName.equals(PortletKeys.LAYOUT_MANAGEMENT) && tabs1.equals("settings")) {
	renderResponse.setTitle(LanguageUtil.get(pageContext, "settings"));
}

Group selGroup = (Group)request.getAttribute(WebKeys.GROUP);

Group liveGroup = null;
Group stagingGroup = null;

int pagesCount = 0;

if (selGroup.isStagingGroup()) {
	liveGroup = selGroup.getLiveGroup();
	stagingGroup = selGroup;
}
else {
	liveGroup = selGroup;

	if (selGroup.hasStagingGroup()) {
		stagingGroup = selGroup.getStagingGroup();
	}
}

Group group = null;

if (stagingGroup != null) {
	group = stagingGroup;
}
else {
	group = liveGroup;
}

long groupId = liveGroup.getGroupId();

if (group != null) {
	groupId = group.getGroupId();
}

long liveGroupId = liveGroup.getGroupId();

long stagingGroupId = 0;

if (stagingGroup != null) {
	stagingGroupId = stagingGroup.getGroupId();
}

long selPlid = ParamUtil.getLong(request, "selPlid", LayoutConstants.DEFAULT_PLID);
long refererPlid = ParamUtil.getLong(request, "refererPlid", LayoutConstants.DEFAULT_PLID);
long layoutId = LayoutConstants.DEFAULT_PARENT_LAYOUT_ID;

UnicodeProperties groupTypeSettings = null;

if (group != null) {
	groupTypeSettings = group.getTypeSettingsProperties();
}
else {
	groupTypeSettings = new UnicodeProperties();
}

UnicodeProperties liveGroupTypeSettings = liveGroup.getTypeSettingsProperties();

Layout selLayout = null;

try {
	if (selPlid != LayoutConstants.DEFAULT_PLID) {
		selLayout = LayoutLocalServiceUtil.getLayout(selPlid);
	}
}
catch (NoSuchLayoutException nsle) {
}

Layout refererLayout = null;

try {
	if (refererPlid != LayoutConstants.DEFAULT_PLID) {
		refererLayout = LayoutLocalServiceUtil.getLayout(refererPlid);
	}
}
catch (NoSuchLayoutException nsle) {
}

if (selLayout != null) {
	layoutId = selLayout.getLayoutId();
}

if (Validator.isNull(tabs2) && !tabs1.equals("settings")) {
	tabs2 = "pages";
}

if (tabs1.endsWith("-pages") && !tabs2.equals("pages") && !tabs2.equals("look-and-feel") && !tabs2.equals("export-import") && !tabs2.equals("proposals")) {
	tabs2 = "pages";
}
else if (tabs1.equals("settings") && !tabs2.equals("virtual-host") && !tabs2.equals("logo") && !tabs2.equals("sitemap") && !tabs2.equals("monitoring") && !tabs2.equals("merge-pages") && !tabs2.equals("staging")) {
	tabs2 = "virtual-host";
}

if ((selLayout == null) && tabs2.equals("pages")) {
	tabs3 = "children";
}

if (tabs2.equals("pages") && !tabs3.equals("look-and-feel") && (!tabs3.equals("children") || ((selLayout != null) && !PortalUtil.isLayoutParentable(selLayout)))) {
	tabs3 = "page";
}

if (!tabs2.equals("export-import") && (tabs2.equals("look-and-feel") || tabs3.equals("look-and-feel"))) {
	if (!tabs4.equals("regular-browsers") && !tabs4.equals("mobile-devices") && !tabs4.equals("themes-rules")) {
		tabs4 = "regular-browsers";
	}
}

long parentLayoutId = BeanParamUtil.getLong(selLayout, request, "parentLayoutId", LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);

Organization organization = null;
User selUser = null;
UserGroup userGroup = null;

if (liveGroup.isOrganization()) {
	organization = OrganizationLocalServiceUtil.getOrganization(liveGroup.getOrganizationId());
}
else if (liveGroup.isUser()) {
	selUser = UserLocalServiceUtil.getUserById(liveGroup.getClassPK());
}
else if (liveGroup.isUserGroup()) {
	userGroup = UserGroupLocalServiceUtil.getUserGroup(liveGroup.getClassPK());
}

String tabs1Names = "public-pages,private-pages";

boolean privateLayout = tabs1.equals("private-pages");

if (liveGroup.isUser()) {
	boolean hasPowerUserRole = RoleLocalServiceUtil.hasUserRole(selUser.getUserId(), company.getCompanyId(), RoleConstants.POWER_USER, true);

	boolean privateLayoutsModifiable = PropsValues.LAYOUT_USER_PRIVATE_LAYOUTS_MODIFIABLE && (!PropsValues.LAYOUT_USER_PRIVATE_LAYOUTS_POWER_USER_REQUIRED || hasPowerUserRole);
	boolean publicLayoutsModifiable = PropsValues.LAYOUT_USER_PUBLIC_LAYOUTS_MODIFIABLE && (!PropsValues.LAYOUT_USER_PUBLIC_LAYOUTS_POWER_USER_REQUIRED || hasPowerUserRole);

	if (privateLayoutsModifiable && publicLayoutsModifiable) {
		tabs1Names = "public-pages,private-pages";
	}
	else if (privateLayoutsModifiable) {
		tabs1Names = "private-pages";
	}
	else if (publicLayoutsModifiable) {
		tabs1Names = "public-pages";
	}

	if (!publicLayoutsModifiable && privateLayoutsModifiable && !privateLayout) {
		tabs1 = "private-pages";

		privateLayout = true;
	}
}

if (selGroup.isLayoutSetPrototype()) {
	privateLayout = true;
}

if (privateLayout) {
	if (group != null) {
		pagesCount = group.getPrivateLayoutsPageCount();
	}
}
else {
	if (group != null) {
		pagesCount = group.getPublicLayoutsPageCount();
	}
}

LayoutLister layoutLister = new LayoutLister();

String rootNodeName = liveGroup.getDescriptiveName();

if (liveGroup.isOrganization()) {
	rootNodeName = organization.getName();
}
else if (liveGroup.isUser()) {
	rootNodeName = selUser.getFullName();
}
else if (liveGroup.isUserGroup()) {
	rootNodeName = userGroup.getName();
}
else if (selGroup.isLayoutSetPrototype()) {
	LayoutSetPrototype layoutSetPrototype = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototype(selGroup.getClassPK());

	rootNodeName = layoutSetPrototype.getName(user.getLanguageId());
}

LayoutView layoutView = layoutLister.getLayoutView(groupId, privateLayout, rootNodeName, locale);

List layoutList = layoutView.getList();

request.setAttribute(WebKeys.LAYOUT_LISTER_LIST, layoutList);

TasksProposal proposal = null;

if (selLayout != null) {
	if (liveGroup.isWorkflowEnabled()) {
		try {
			proposal = TasksProposalLocalServiceUtil.getProposal(Layout.class.getName(), String.valueOf(selPlid));
		}
		catch (NoSuchProposalException nspe) {
		}
	}
}

boolean workflowEnabled = liveGroup.isWorkflowEnabled();
int workflowStages = ParamUtil.getInteger(request, "workflowStages", liveGroup.getWorkflowStages());
String[] workflowRoleNames = StringUtil.split(ParamUtil.getString(request, "workflowRoleNames", liveGroup.getWorkflowRoleNames()));

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("struts_action", "/communities/edit_pages");
portletURL.setParameter("tabs1", tabs1);
portletURL.setParameter("tabs2", tabs2);
portletURL.setParameter("tabs3", tabs3);
//portletURL.setParameter("tabs4", tabs4);
portletURL.setParameter("redirect", redirect);

if (portletName.equals(PortletKeys.LAYOUT_MANAGEMENT) || portletName.equals(PortletKeys.MY_ACCOUNT)) {
	portletURL.setParameter("backURL", backURL);
}

portletURL.setParameter("groupId", String.valueOf(liveGroupId));

PortletURL viewPagesURL = new PortletURLImpl(request, PortletKeys.MY_PLACES, plid, PortletRequest.ACTION_PHASE);

viewPagesURL.setWindowState(WindowState.NORMAL);
viewPagesURL.setPortletMode(PortletMode.VIEW);

viewPagesURL.setParameter("struts_action", "/my_places/view");
viewPagesURL.setParameter("groupId", String.valueOf(groupId));
viewPagesURL.setParameter("privateLayout", String.valueOf(privateLayout));

if (!portletName.equals(PortletKeys.GROUP_PAGES) && !portletName.equals(PortletKeys.MY_PAGES)) {
	if (organization != null) {
		EnterpriseAdminUtil.addPortletBreadcrumbEntries(organization, request, renderResponse);
	}
	else {
		PortalUtil.addPortletBreadcrumbEntry(request, group.getDescriptiveName(), null);
	}

	if (portletName.equals(PortletKeys.LAYOUT_MANAGEMENT) && tabs1.equals("settings")) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "settings"), currentURL);
	}
	else {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "manage-pages"), currentURL);
	}
}

request.setAttribute("edit_pages.jsp-tab4", tabs4);

request.setAttribute("edit_pages.jsp-liveGroup", liveGroup);
request.setAttribute("edit_pages.jsp-stagingGroup", stagingGroup);
request.setAttribute("edit_pages.jsp-group", group);
request.setAttribute("edit_pages.jsp-groupId", new Long(groupId));
request.setAttribute("edit_pages.jsp-liveGroupId", new Long(liveGroupId));
request.setAttribute("edit_pages.jsp-selPlid", new Long(selPlid));
request.setAttribute("edit_pages.jsp-privateLayout", new Boolean(privateLayout));
request.setAttribute("edit_pages.jsp-groupTypeSettings", groupTypeSettings);
request.setAttribute("edit_pages.jsp-liveGroupTypeSettings", liveGroupTypeSettings);
request.setAttribute("edit_pages.jsp-selLayout", selLayout);

request.setAttribute("edit_pages.jsp-rootNodeName", rootNodeName);

request.setAttribute("edit_pages.jsp-layoutList", layoutList);

request.setAttribute("edit_pages.jsp-workflowEnabled", new Boolean(workflowEnabled));
request.setAttribute("edit_pages.jsp-workflowStages", new Integer(workflowStages));
request.setAttribute("edit_pages.jsp-workflowRoleNames", workflowRoleNames);

request.setAttribute("edit_pages.jsp-portletURL", portletURL);
%>

<portlet:actionURL var="editPagesURL">
	<portlet:param name="struts_action" value="/communities/edit_pages" />
</portlet:actionURL>

<aui:form action="<%= editPagesURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "savePage();" %>'>
	<aui:input name="tabs1" type="hidden" value="<%= tabs1 %>" />
	<aui:input name="tabs2" type="hidden" value="<%= tabs2 %>" />
	<aui:input name="tabs3" type="hidden" value="<%= tabs3 %>" />
	<aui:input name="tabs4" type="hidden" value="<%= tabs4 %>" />
	<aui:input name="<%= Constants.CMD %>" type="hidden" />
	<aui:input name="pagesRedirect" type="hidden" value='<%= portletURL.toString() + "&" + renderResponse.getNamespace() + "tabs4=" + tabs4 + "&" + renderResponse.getNamespace() + "selPlid=" + selPlid  %>' />
	<aui:input name="groupId" type="hidden" value="<%= groupId %>" />
	<aui:input name="liveGroupId" type="hidden" value="<%= liveGroupId %>" />
	<aui:input name="stagingGroupId" type="hidden" value="<%= stagingGroupId %>" />
	<aui:input name="privateLayout" type="hidden" value="<%= privateLayout %>" />
	<aui:input name="layoutId" type="hidden" value="<%= layoutId %>" />
	<aui:input name="selPlid" type="hidden" value="<%= selPlid %>" />
	<aui:input name="wapTheme" type="hidden" value='<%= tabs4.equals("mobile-devices") ? "true" : "false" %>' />
	<aui:input name="<%= PortletDataHandlerKeys.SELECTED_LAYOUTS %>" type="hidden" />

	<c:if test="<%= portletName.equals(PortletKeys.COMMUNITIES) || portletName.equals(PortletKeys.ENTERPRISE_ADMIN) || portletName.equals(PortletKeys.ENTERPRISE_ADMIN_COMMUNITIES) || portletName.equals(PortletKeys.ENTERPRISE_ADMIN_ORGANIZATIONS) || portletName.equals(PortletKeys.ENTERPRISE_ADMIN_USER_GROUPS) || portletName.equals(PortletKeys.ENTERPRISE_ADMIN_USERS) || portletName.equals(PortletKeys.GROUP_PAGES) || portletName.equals(PortletKeys.MY_PAGES) %>">
		<c:if test="<%= portletName.equals(PortletKeys.COMMUNITIES) || portletName.equals(PortletKeys.ENTERPRISE_ADMIN) || portletName.equals(PortletKeys.ENTERPRISE_ADMIN_COMMUNITIES) || portletName.equals(PortletKeys.ENTERPRISE_ADMIN_ORGANIZATIONS) || portletName.equals(PortletKeys.ENTERPRISE_ADMIN_USER_GROUPS) || portletName.equals(PortletKeys.ENTERPRISE_ADMIN_USERS) %>">
			<liferay-ui:header
				backURL="<%= backURL %>"
				title="<%= liveGroup.getDescriptiveName() %>"
			/>
		</c:if>

		<%
		String tabs1URL = portletURL.toString();

		if (liveGroup.isUser()) {
			PortletURL userTabs1URL = renderResponse.createRenderURL();

			userTabs1URL.setParameter("struts_action", "/my_pages/edit_pages");
			userTabs1URL.setParameter("tabs1", tabs1);
			userTabs1URL.setParameter("backURL", backURL);
			userTabs1URL.setParameter("groupId", String.valueOf(liveGroupId));

			tabs1URL = userTabs1URL.toString();
		}
		else if (!liveGroup.isUserGroup() && ((GroupPermissionUtil.contains(permissionChecker, liveGroupId, ActionKeys.MANAGE_STAGING)) || (GroupPermissionUtil.contains(permissionChecker, liveGroupId, ActionKeys.UPDATE)))) {
			tabs1Names += ",settings";
		}
		%>

		<liferay-ui:tabs
			names="<%= tabs1Names %>"
			param="tabs1"
			value="<%= tabs1 %>"
			url="<%= tabs1URL %>"
		/>

		<%
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, TextFormatter.format(tabs1, TextFormatter.O)), currentURL);
		%>
	</c:if>

	<c:if test="<%= liveGroup.isUserGroup() %>">
		<div class="portlet-msg-info">
			<liferay-ui:message key="users-who-belongs-to-this-user-group-will-have-these-pages-copied-to-their-user-pages-when-the-user-is-first-associated-with-the-user-group" />
		</div>
	</c:if>

	<c:choose>
		<c:when test='<%= tabs1.equals("settings") %>'>
			<liferay-util:include page="/html/portlet/communities/edit_pages_settings.jsp" />
		</c:when>
		<c:otherwise>

			<%
			String tabs2Names = null;

			if (group.isLayoutPrototype()) {
				tabs2Names = "template";
			}
			else {
				tabs2Names = "pages";

				if (permissionChecker.isOmniadmin() || (PropsValues.LOOK_AND_FEEL_MODIFIABLE && GroupPermissionUtil.contains(permissionChecker, liveGroupId, ActionKeys.MANAGE_LAYOUTS))) {
					tabs2Names += ",look-and-feel";
				}
			}

			if (GroupPermissionUtil.contains(permissionChecker, liveGroupId, ActionKeys.MANAGE_LAYOUTS)) {
				tabs2Names += ",export-import";
			}

			if (workflowEnabled) {
				tabs2Names += ",proposals";
			}

			if (!StringUtil.contains(tabs2Names, tabs2)) {
				tabs2 = "pages";
			}

			if (!GroupPermissionUtil.contains(permissionChecker, liveGroupId, ActionKeys.MANAGE_LAYOUTS)) {
				tabs2Names = StringUtil.replace(tabs2Names, "pages,", StringPool.BLANK);
				tabs2 = "proposals";
			}
			%>

			<c:choose>
				<c:when test="<%= portletName.equals(PortletKeys.ENTERPRISE_ADMIN) && liveGroup.isUser() %>">
					<liferay-ui:tabs
						names="<%= tabs2Names %>"
						param="tabs2"
						url="<%= portletURL.toString() %>"
						backURL="<%= redirect %>"
					/>
				</c:when>
				<c:otherwise>
					<liferay-ui:tabs
						names="<%= tabs2Names %>"
						param="tabs2"
						url="<%= portletURL.toString() %>"
					/>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test='<%= tabs2.equals("pages") %>'>
					<%@ include file="/html/portlet/communities/edit_pages_public_and_private.jspf" %>
				</c:when>
				<c:when test='<%= tabs2.equals("look-and-feel") %>'>
					<liferay-util:include page="/html/portlet/communities/edit_pages_look_and_feel.jsp" />
				</c:when>
				<c:when test='<%= tabs2.equals("export-import") %>'>
					<liferay-util:include page="/html/portlet/communities/edit_pages_export_import.jsp" />
				</c:when>
				<c:when test='<%= tabs2.equals("proposals") %>'>
					<liferay-util:include page="/html/portlet/communities/edit_pages_proposals.jsp" />
				</c:when>
			</c:choose>

			<%
			if (!tabs2.equals("pages")) {
				PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, TextFormatter.format(tabs2, TextFormatter.O)), currentURL);
			}
			%>

		</c:otherwise>
	</c:choose>
</aui:form>

<aui:script>
	function <portlet:namespace />deletePage() {
		<c:choose>
			<c:when test="<%= (selPlid == themeDisplay.getPlid()) || (selPlid == refererPlid) %>">
				alert('<%= UnicodeLanguageUtil.get(pageContext, "you-cannot-delete-this-page-because-you-are-currently-accessing-this-page") %>');
			</c:when>
			<c:otherwise>
				if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-page") %>')) {
					document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
					document.<portlet:namespace />fm.<portlet:namespace />pagesRedirect.value = "<%= portletURL.toString() %>&<portlet:namespace />selPlid=<%= LayoutConstants.DEFAULT_PLID %>";
					submitForm(document.<portlet:namespace />fm);
				}
			</c:otherwise>
		</c:choose>
	}

	function <portlet:namespace />exportPages() {
		submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>"><portlet:param name="struts_action" value="/communities/export_pages" /><portlet:param name="groupId" value="<%= String.valueOf(liveGroupId) %>" /><portlet:param name="privateLayout" value="<%= String.valueOf(privateLayout) %>" /></portlet:actionURL>&etag=0", false);
	}

	function <portlet:namespace />importPages() {
		document.<portlet:namespace />fm.encoding = "multipart/form-data";
		submitForm(document.<portlet:namespace />fm, "<portlet:actionURL><portlet:param name="struts_action" value="/communities/import_pages" /><portlet:param name="backURL" value="<%= backURL %>" /><portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" /><portlet:param name="privateLayout" value="<%= String.valueOf(privateLayout) %>" /></portlet:actionURL>");
	}

	function <portlet:namespace />savePage() {
		document.<portlet:namespace />fm.encoding = "multipart/form-data";

		<c:choose>
			<c:when test='<%= tabs2.equals("monitoring") %>'>
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "monitoring";
			</c:when>
			<c:when test='<%= tabs2.equals("virtual-host") %>'>
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "virtual_host";
			</c:when>
			<c:when test='<%= tabs2.equals("merge-pages") %>'>
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "merge_pages";
			</c:when>
			<c:otherwise>
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = '<%= tabs3.equals("children") ? Constants.ADD : Constants.UPDATE %>';
			</c:otherwise>
		</c:choose>

		<c:if test='<%= tabs3.equals("page") %>'>
			<portlet:namespace />updateLanguage();
			<portlet:namespace />updateMetaLanguage();
		</c:if>

		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />updateLogo() {
		document.<portlet:namespace />fm.encoding = "multipart/form-data";
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "logo";
		submitForm(document.<portlet:namespace />fm);
	}

	Liferay.provide(
		window,
		'<portlet:namespace />removePage',
		function(box) {
			var A = AUI();

			var selectEl = A.one(box);

			var layoutId = <%= ((refererLayout == null) ? layout.getLayoutId() : refererLayout.getLayoutId()) %>;
			var currentValue = null;

			if (selectEl) {
				currentValue = selectEl.val();
			}

			if (layoutId == currentValue) {
				alert('<%= UnicodeLanguageUtil.get(pageContext, "you-cannot-delete-this-page-because-you-are-currently-accessing-this-page") %>');
			}
			else {
				Liferay.Util.removeItem(box);
			}
		},
		['aui-base']
	);

	Liferay.provide(
		window,
		'<portlet:namespace />updateDisplayOrder',
		function() {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "display_order";
			document.<portlet:namespace />fm.<portlet:namespace />layoutIds.value = Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />layoutIdsBox);
			submitForm(document.<portlet:namespace />fm);
		},
		['liferay-util-list-fields']
	);

	Liferay.provide(
		window,
		'<portlet:namespace />updateLookAndFeel',
		function(themeId, colorSchemeId, sectionParam, sectionName) {
			var A = AUI();

			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "look_and_feel";

			var themeRadio = A.one(document.<portlet:namespace />fm.<portlet:namespace />themeId);

			if (themeRadio) {
				themeRadio.val(themeId);
			}

			var colorSchemeRadio = A.one(document.<portlet:namespace />fm.<portlet:namespace />colorSchemeId);

			if (colorSchemeRadio) {
				colorSchemeRadio.val(colorSchemeId);
			}

			if ((sectionParam != null) && (sectionName != null)) {
				document.<portlet:namespace />fm.<portlet:namespace />pagesRedirect.value += "&" + sectionParam + "=" + sectionName;
			}

			submitForm(document.<portlet:namespace />fm);
		},
		['aui-base']
	);

	Liferay.provide(
		window,
		'<portlet:namespace />updateStaging',
		function() {
			var A = AUI();

			var selectEl = A.one('#<portlet:namespace />stagingType');

			var currentValue = null;

			if (selectEl) {
				currentValue = selectEl.val();
			}

			var ok = false;

			if (0 == currentValue) {
				ok = confirm('<%= UnicodeLanguageUtil.format(pageContext, "are-you-sure-you-want-to-deactivate-staging-for-x", liveGroup.getDescriptiveName()) %>');
			}
			else if (1 == currentValue) {
				ok = confirm('<%= UnicodeLanguageUtil.format(pageContext, "are-you-sure-you-want-to-activate-local-staging-for-x", liveGroup.getDescriptiveName()) %>');
			}
			else if (2 == currentValue) {
				ok = confirm('<%= UnicodeLanguageUtil.format(pageContext, "are-you-sure-you-want-to-activate-remote-staging-for-x", liveGroup.getDescriptiveName()) %>');
			}

			if (ok) {
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "staging";
				submitForm(document.<portlet:namespace />fm);
			}
		},
		['aui-base']
	);
</aui:script>