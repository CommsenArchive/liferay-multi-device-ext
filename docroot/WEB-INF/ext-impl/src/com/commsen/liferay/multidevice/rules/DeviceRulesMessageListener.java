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

import javax.portlet.PortletRequest;

import com.commsen.liferay.multidevice.command.ActionForDeviceCommand;
import com.commsen.liferay.multidevice.command.RulesListCommand;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;

/**
 * 
 * @author Milen Dyankov
 *
 */
public class DeviceRulesMessageListener implements MessageListener {

	private DeviceRulesProvider deviceRulesProvider;
	
	@Override
	public void receive(Message message) {
		Object payload = message.getPayload();
		
		if (payload instanceof ActionForDeviceCommand) {
			ActionForDeviceCommand command = (ActionForDeviceCommand)payload;
			Message response = MessageBusUtil.createResponseMessage(message);
			Object action = deviceRulesProvider.getAction(command.getDevice(), command.getCompanyId(), command.getGroupId(), command.getLayoutId());
			response.setPayload(action);
			MessageBusUtil.sendMessage(message.getResponseDestinationName(), response);
			return;
		}

		if (payload instanceof RulesListCommand) {
			RulesListCommand command = (RulesListCommand)payload;
			Message response = MessageBusUtil.createResponseMessage(message);
			Object rulesList = deviceRulesProvider.getRules(command.getCompanyId(), command.getGroupId(), command.getLayoutId());
			response.setPayload(rulesList);
			MessageBusUtil.sendMessage(message.getResponseDestinationName(), response);
			return;
		}
	
		if (payload instanceof PortletRequest) {
			PortletRequest request = (PortletRequest)payload;
			Message response = MessageBusUtil.createResponseMessage(message);
			Object errorCodes = deviceRulesProvider.handleRulesRequest(request);
			response.setPayload(errorCodes);
			MessageBusUtil.sendMessage(message.getResponseDestinationName(), response);
			return;
		}
	}

	public void setDeviceRulesProvider(DeviceRulesProvider deviceRulesProvider) {
    	this.deviceRulesProvider = deviceRulesProvider;
    }


}
