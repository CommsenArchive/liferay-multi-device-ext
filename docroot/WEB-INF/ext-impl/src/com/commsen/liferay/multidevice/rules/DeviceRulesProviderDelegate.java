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
package com.commsen.liferay.multidevice.rules;

import java.util.List;

import javax.portlet.PortletRequest;

import com.commsen.liferay.multidevice.Device;
import com.commsen.liferay.multidevice.MultideviceConstants;
import com.commsen.liferay.multidevice.command.ActionForDeviceCommand;
import com.commsen.liferay.multidevice.command.RulesListCommand;
import com.commsen.liferay.multidevice.rules.actions.DeviceAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.MessageBusException;
import com.liferay.portal.kernel.messaging.MessageBusUtil;

/**
 * 
 * @author Milen Dyankov
 * 
 */
public class DeviceRulesProviderDelegate implements DeviceRulesProvider {

	private static Log _log = LogFactoryUtil.getLog(DeviceRulesProviderDelegate.class);


	/**
	 * @see
	 * com.commsen.liferay.multidevice.rules.DeviceRulesProvider#getThemeAndColorScheme
	 * (com.commsen.liferay.multidevice.Device)
	 */
	@Override
	public DeviceAction getAction(Device device, long companyId, long groupId, long pageId) {
		try {
			ActionForDeviceCommand actionForDeviceCommand = new ActionForDeviceCommand(device, companyId, groupId, pageId);
			Object result = MessageBusUtil.sendSynchronousMessage(
			        MultideviceConstants.DESTINATION_DEVICE_RULES_PROVIDER, actionForDeviceCommand,
			        MultideviceConstants.DESTINATION_DEVICE_RULES_PROVIDER_RESPONSE);
			if (!(result instanceof DeviceAction)) {
				_log.error("Unexpected response! Expected " + DeviceAction.class.getName() + " but got "
				        + result.getClass().getName());
				return null;
			}
			return (DeviceAction) result;
		} catch (MessageBusException e) {
			_log.error("Failed to get action for device " + device, e);
		}
		return null;
	}


	/* (non-Javadoc)
     * @see com.commsen.liferay.multidevice.rules.themes.ThemeSelectingProvider#getThemeRulesInfo(long, long, long)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<RuleInfo> getRules(long companyId, long groupId, long pageId) {
		try {
			RulesListCommand themeRulesListCommand = new RulesListCommand(companyId, groupId, pageId);
			Object result = MessageBusUtil.sendSynchronousMessage(
			        MultideviceConstants.DESTINATION_DEVICE_RULES_PROVIDER, themeRulesListCommand,
			        MultideviceConstants.DESTINATION_DEVICE_RULES_PROVIDER_RESPONSE);
			if (!(result instanceof List)) {
				_log.error("Unexpected response! Expected " + List.class.getName() + " but got "
				        + result.getClass().getName());
				return null;
			}
			return (List) result;
		} catch (MessageBusException e) {
			_log.error("Failed to get list of device rules!", e);
		}
		return null;
    }


	/* (non-Javadoc)
     * @see com.commsen.liferay.multidevice.rules.DeviceRulesProvider#handleRulesRequest(javax.servlet.http.HttpServletRequest)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List<String> handleRulesRequest(PortletRequest request) {
		try {
			Object result = MessageBusUtil.sendSynchronousMessage(
			        MultideviceConstants.DESTINATION_DEVICE_RULES_PROVIDER, request,
			        MultideviceConstants.DESTINATION_DEVICE_RULES_PROVIDER_RESPONSE);
			if (!(result instanceof List)) {
				_log.error("Unexpected response! Expected " + List.class.getName() + " but got "
				        + result.getClass().getName());
				return null;
			}
			return (List) result;
		} catch (MessageBusException e) {
			_log.error("Failed to handle device rules request!", e);
		}
		return null;
    }

}
