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

import com.commsen.liferay.multidevice.Device;
import com.commsen.liferay.multidevice.command.ThemeForDeviceCommand;
import com.commsen.liferay.multidevice.command.ThemeRulesListCommand;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;

/**
 * 
 * @author Milen Dyankov
 *
 */
public class ThemeSelectingMessageListener implements MessageListener {

	private ThemeSelectingProvider themeSelectingProvider;
	
	@Override
	public void receive(Message message) {
		Object payload = message.getPayload();
		
		System.out.println("\n\n got message: " + payload.getClass().getName());

		if (payload instanceof ThemeForDeviceCommand) {
			ThemeForDeviceCommand command = (ThemeForDeviceCommand)payload;
			Message response = MessageBusUtil.createResponseMessage(message);
			Object themeAndColorScheme = themeSelectingProvider.getThemeAndColorScheme(command.getDevice(), command.getCompanyId(), command.getGroupId(), command.getLayoutId());
			response.setPayload(themeAndColorScheme);
			MessageBusUtil.sendMessage(message.getResponseDestinationName(), response);
			return;
		}

		if (payload instanceof ThemeRulesListCommand) {
			ThemeRulesListCommand command = (ThemeRulesListCommand)payload;
			Message response = MessageBusUtil.createResponseMessage(message);
			Object themeRulesList = themeSelectingProvider.getThemeRulesInfo(command.getCompanyId(), command.getGroupId(), command.getLayoutId());
			response.setPayload(themeRulesList);
			MessageBusUtil.sendMessage(message.getResponseDestinationName(), response);
			return;
		}
	
	}

	public void setThemeSelectingProvider(ThemeSelectingProvider themeSelectingProvider) {
    	this.themeSelectingProvider = themeSelectingProvider;
    }


}
