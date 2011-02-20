/**
 *	This file is part of multi-device portal extension for Liferay.
 *	
 * Multi-device portal extension for Liferay is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * Multi-device portal extension for Liferay is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with multi-device portal extension for Liferay.  If not, see <http://www.gnu.org/licenses/lgpl.html>.
 */
package com.commsen.liferay.multidevice.rules.themes;

import com.commsen.liferay.multidevice.MultideviceConstants;
import com.liferay.portal.kernel.messaging.BaseDestinationEventListener;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;

/**
 * This destination event listener reacts on register an unregister events. When new
 * {@link ThemeSelectingMessageListener} is registered it removes the one base one. When external
 * {@link ThemeSelectingMessageListener} is removed it registers back the base one.
 * 
 * @author Milen Dyankov
 * 
 */
public class ThemeSeletingDestinationEventListener extends BaseDestinationEventListener {

	private ThemeSelectingMessageListener themeSelectingMessageListener;


	@Override
	public void messageListenerRegistered(String destinationName, MessageListener messageListener) {
		if (!isProceed(destinationName, messageListener)) {
			return;
		}
		MessageBusUtil.unregisterMessageListener(MultideviceConstants.DESTINATION_THEME_SELECTING_PROVIDER,
		        themeSelectingMessageListener);
	}


	@Override
	public void messageListenerUnregistered(String destinationName, MessageListener messageListener) {
		if (!isProceed(destinationName, messageListener)) {
			return;
		}
		MessageBusUtil.registerMessageListener(MultideviceConstants.DESTINATION_THEME_SELECTING_PROVIDER,
		        themeSelectingMessageListener);
	}



	protected boolean isProceed(String destinationName, MessageListener messageListener) {

		if ((!destinationName.equals(MultideviceConstants.DESTINATION_THEME_SELECTING_PROVIDER))
		        || (messageListener == themeSelectingMessageListener)
		        || !(messageListener instanceof ThemeSelectingMessageListener)) {

			return false;
		} else {
			return true;
		}
	}


	public void setThemeSelectingMessageListener(ThemeSelectingMessageListener themeSelectingMessageListener) {
    	this.themeSelectingMessageListener = themeSelectingMessageListener;
    }

}
