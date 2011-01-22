

<%@page import="com.commsen.liferay.multidevice.DevicesUtil" %>
<%@page import="com.commsen.liferay.multidevice.VersionableName"%>

<div>
	<fieldset title="Criteria">
		<legend>If device matches the following criteria</legend>
		<table>
			<tr>
				<td><label>Brand is</label></td>
				<td>
					<select id="<portlet:namespace />brand" name="<portlet:namespace />brand" >
						<option value="">ANY</option>
						<%
						for (VersionableName brand : DevicesUtil.getBrands()) {
						%>
						<option><%= HtmlUtil.escape(brand.getName()) %></option>
						<%
						}
						%>
					</select>
				</td>
				<td><label>model</label></td>
				<td>
					<select id="<portlet:namespace />model" name="<portlet:namespace />model">
						<option value="">ANY</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label>Operating system is</label></td>
				<td>
					<select id="<portlet:namespace />os" name="<portlet:namespace />os" >
						<option value="">ANY</option>
						<%
						for (VersionableName os : DevicesUtil.getOperatingSystems()) {
						%>
						<option><%= HtmlUtil.escape(os.getName()) %></option>
						<%
						}
						%>
					</select>
				</td>
				<td><label>version</label></td>
				<td>
					<select id="<portlet:namespace />osVersion" name="<portlet:namespace />osVersion">
						<option value="">ANY</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label>Browser is</label></td>
				<td>
					<select id="<portlet:namespace />browser" name="<portlet:namespace />browser" >
						<option value="">ANY</option>
						<%
						for (VersionableName browser : DevicesUtil.getBrowsers()) {
						%>
						<option><%= HtmlUtil.escape(browser.getName()) %></option>
						<%
						}
						%>
					</select>
				</td>
				<td><label>version</label></td>
				<td>
					<select id="<portlet:namespace />browserVersion" name="<portlet:namespace />browserVersion">
						<option value="">ANY</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label>Pointing method is</label></td>
				<td>
					<select id="<portlet:namespace />pointingMethod" name="<portlet:namespace />pointingMethod" >
						<option value="">ANY</option>
						<%
						for (String pointingMethod : DevicesUtil.getPointingMethods()) {
						%>
						<option><%= HtmlUtil.escape(pointingMethod) %></option>
						<%
						}
						%>
					</select>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><label>Device is tablet</label></td>
				<td>
					<select id="<portlet:namespace />isTablet" name="<portlet:namespace />isTablet" >
						<option value="">doesn't matter</option>
						<option value="">yes</option>
						<option value="">no</option>
					</select>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><label>Device has qwerty keyboard</label></td>
				<td>
					<select id="<portlet:namespace />hasQwertyKeyboard" name="<portlet:namespace />hasQwertyKeyboard" >
						<option value="">doesn't matter</option>
						<option value="">yes</option>
						<option value="">no</option>
					</select>
				</td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend>Then apply theme</legend>
		<input id="<portlet:namespace />dynamicThemeId" name="<portlet:namespace />dynamicThemeId" type="hidden"/>
		<input id="<portlet:namespace />dynamicColorSchemeId" name="<portlet:namespace />dynamicColorSchemeId" type="hidden"/>
		<a href="#" id="<portlet:namespace />selectedTheme">
			<img id="<portlet:namespace />selectedThemeImg" class="theme-thumbnail" src="/html/themes/classic/images/spacer.png" />
			<span id="<portlet:namespace />selectedThemeName">no theme selected</span>
		</a>
	</fieldset>
	<fieldset>
		<a href="">Save this rule with priority</a>
		<input id="<portlet:namespace />dynamicThemePriority" name="<portlet:namespace />dynamicThemePriority" size="4" value="100"/>
	</fieldset>

</div>

<aui:script use="liferay-auto-fields">

	AUI().ready('node', 'aui-dialog', 'aui-overlay-manager', 'dd-constrain', function(A) {
		
		A.one('#<portlet:namespace />brand').on('change', function (e) {
			changeModel (e.target.get('value'));
		});

		A.one('#<portlet:namespace />os').on('change', function (e) {
			changeOSVersions (e.target.get('value'));
		});

		A.one('#<portlet:namespace />browser').on('change', function (e) {
			changeBrowserVersions (e.target.get('value'));
		});


		function changeModel (brand) {
			versionNode = A.one('#<portlet:namespace />model');
			versionNode.all('option').remove();
			versionNode.append('<option value="">ANY</option>');
			<%
			for (VersionableName brand : DevicesUtil.getBrands()) {
			%>
			if ('<%=brand.getName() %>' == brand) {
				<%
				for (String model : brand.getVersions()) {
				%>
					versionNode.append('<option><%= HtmlUtil.escape(model) %></option>');
				<%
				}
				%>
			}
			<%
			}
			%>
		}

		
		function changeOSVersions (osName) {
			versionNode = A.one('#<portlet:namespace />osVersion');
			versionNode.all('option').remove();
			versionNode.append('<option value="">ANY</option>');
			<%
			for (VersionableName os : DevicesUtil.getOperatingSystems()) {
			%>
			if ('<%=os.getName() %>' == osName) {
				<%
				for (String version : os.getVersions()) {
				%>
					versionNode.append('<option><%= HtmlUtil.escape(version) %></option>');
				<%
				}
				%>
			}
			<%
			}
			%>
		}

		function changeBrowserVersions (browserName) {
			versionNode = A.one('#<portlet:namespace />browserVersion');
			versionNode.all('option').remove();
			versionNode.append('<option value="">ANY</option>');
			<%
			for (VersionableName browser : DevicesUtil.getBrowsers()) {
			%>
			if ('<%=browser.getName() %>' == browserName) {
				<%
				for (String version : browser.getVersions()) {
				%>
					versionNode.append('<option><%= HtmlUtil.escape(version) %></option>');
				<%
				}
				%>
			}
			<%
			}
			%>
		}

		var themes = '<ul class="lfr-component lfr-theme-list" id="<portlet:namespace />themes">';
		<%
		Iterator<Theme> itr = themes.iterator();
		while (itr.hasNext()) {
			Theme curTheme = itr.next();
			List<ColorScheme> colorSchemes = curTheme.getColorSchemes();

		%>
			themes += '	<li><a class="<portlet:namespace />dynamic-theme-entry" href="javascript:<portlet:namespace />selectLookAndFeel(\'<%= curTheme.getThemeId() %>\', \'\', \'<%= curTheme.getContextPath() %><%= curTheme.getImagesPath() %>/thumbnail.png\', \'<%= curTheme.getName() %>\');">';
			themes += '			<span class="theme-title"><%= curTheme.getName() %></span>';
			themes += '			<img alt="<%= curTheme.getName() %>" class="theme-thumbnail" src="<%= curTheme.getContextPath() %><%= curTheme.getImagesPath() %>/thumbnail.png" title="<%= curTheme.getName() %>" />';
		<%
			if (!colorSchemes.isEmpty()) {
		%>
			themes += '<ul class="lfr-component lfr-theme-list">';
		<%
				Iterator<ColorScheme> colorSchemeIterator = colorSchemes.iterator();
				while (colorSchemeIterator.hasNext()) {
					ColorScheme curColorScheme = colorSchemeIterator.next();
		%>
			themes += '	<li><a class="<portlet:namespace />dynamic-theme-entry" href="javascript:<portlet:namespace />selectLookAndFeel(\'<%= curTheme.getThemeId() %>\', \'<%= curColorScheme.getColorSchemeId() %>\', \'<%= curTheme.getContextPath() %><%= curColorScheme.getColorSchemeThumbnailPath() %>/thumbnail.png\', \'<%= curTheme.getName() %> (<%= curColorScheme.getName() %>)\');">';
			themes += '			<span class="theme-title"><%= curColorScheme.getName() %></span>';
			themes += '			<img alt="<%= curColorScheme.getName() %>" class="theme-thumbnail" src="<%= curTheme.getContextPath() %><%= curColorScheme.getColorSchemeThumbnailPath() %>/thumbnail.png" title="<%= curColorScheme.getName() %>" />';
			themes += '	</a></li>';
			
		<%
				}
		%>
			themes += '</ul>';
		<%
			}
		%>
			themes += '	</a></li>';
		<%
		}
		%>
		themes += '</ul>';



		A.one('#<portlet:namespace />selectedTheme').on('click', function (e) {
			var t = new A.Dialog({
				title: 'Select theme',
				centered: true,
				modal: true,
				width: 500,
				height: 400,
				bodyContent: themes
			}).render();
		});

	});

	Liferay.provide(
		window,
		'<portlet:namespace />selectLookAndFeel',
		function(themeId, colorSchemeId, imageUrl, name) {
			var A = AUI();
			A.one('#<portlet:namespace />dynamicThemeId').setAttribute('value', themeId);
			A.one('#<portlet:namespace />dynamicColorSchemeId').setAttribute('value', colorSchemeId);
			A.one('#<portlet:namespace />selectedThemeImg').setAttribute('src', imageUrl);
			A.one('#<portlet:namespace />selectedThemeName').setContent(name);
		},
		['aui-base']
	);


	<%--
	AUI().ready(, function(A) {

	});
	
	for (VersionableName os : DevicesUtil.getOperatingSystems()) {
	%>
		var a = <%=os.getName() %>;
		var b = <%=os.getVersions() %>;
	<%
	}
	--%>

</aui:script>

