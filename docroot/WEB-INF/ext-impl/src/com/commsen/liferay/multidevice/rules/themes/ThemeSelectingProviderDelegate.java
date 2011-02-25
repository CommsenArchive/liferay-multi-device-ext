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
package com.commsen.liferay.multidevice.rules.themes;

import java.util.List;

import com.commsen.liferay.multidevice.Device;
import com.commsen.liferay.multidevice.MultideviceConstants;
import com.commsen.liferay.multidevice.command.ThemeForDeviceCommand;
import com.commsen.liferay.multidevice.command.ThemeRulesListCommand;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.MessageBusException;
import com.liferay.portal.kernel.messaging.MessageBusUtil;

/**
 * 
 * @author Milen Dyankov
 * 
 */
public class ThemeSelectingProviderDelegate implements ThemeSelectingProvider {

	private static Log _log = LogFactoryUtil.getLog(ThemeSelectingProviderDelegate.class);


	/**
	 * @see
	 * com.commsen.liferay.multidevice.rules.themes.ThemeSelectingProvider#getThemeAndColorScheme
	 * (com.commsen.liferay.multidevice.Device)
	 */
	@Override
	public ThemeAndColorScheme getThemeAndColorScheme(Device device, long companyId, long groupId, long pageId) {
		try {
			ThemeForDeviceCommand themeForDeviceCommand = new ThemeForDeviceCommand(device, companyId, groupId, pageId);
			Object result = MessageBusUtil.sendSynchronousMessage(
			        MultideviceConstants.DESTINATION_THEME_SELECTING_PROVIDER, themeForDeviceCommand,
			        MultideviceConstants.DESTINATION_THEME_SELECTING_PROVIDER_RESPONSE);
			if (!(result instanceof ThemeAndColorScheme)) {
				_log.error("Unexpected response! Expected " + ThemeAndColorScheme.class.getName() + " but got "
				        + result.getClass().getName());
				return null;
			}
			return (ThemeAndColorScheme) result;
		} catch (MessageBusException e) {
			_log.error("Failed to get theme and color scheme for device " + device, e);
		}
		return null;
	}


	/* (non-Javadoc)
     * @see com.commsen.liferay.multidevice.rules.themes.ThemeSelectingProvider#getThemeRulesInfo(long, long, long)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<ThemeRuleInfo> getThemeRulesInfo(long companyId, long groupId, long pageId) {
		try {
			ThemeRulesListCommand themeRulesListCommand = new ThemeRulesListCommand(companyId, groupId, pageId);
			Object result = MessageBusUtil.sendSynchronousMessage(
			        MultideviceConstants.DESTINATION_THEME_SELECTING_PROVIDER, themeRulesListCommand,
			        MultideviceConstants.DESTINATION_THEME_SELECTING_PROVIDER_RESPONSE);
			if (!(result instanceof List)) {
				_log.error("Unexpected response! Expected " + List.class.getName() + " but got "
				        + result.getClass().getName());
				return null;
			}
			return (List) result;
		} catch (MessageBusException e) {
			_log.error("Failed to get list of theme rules!", e);
		}
		return null;
    }

}
