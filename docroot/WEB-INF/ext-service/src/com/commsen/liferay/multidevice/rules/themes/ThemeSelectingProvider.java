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

import java.util.List;

import com.commsen.liferay.multidevice.Device;

/**
 * 
 * @author Milen Dyankov
 * 
 */
public interface ThemeSelectingProvider {

	/**
	 * Returns theme and color scheme based on rules configured for given device
	 * 
	 * @param device user's device
	 * @param companyId current portal instance id
	 * @param groupId current community/organization id
	 * @param layoutId current page id
	 * 
	 * @return portal theme and color scheme to apply
	 */
	public ThemeAndColorScheme getThemeAndColorScheme(Device device, long companyId, long groupId, long layoutId);


	/**
	 * Returns a list of rules all matching current company, group and layout.
	 * 
	 * @param companyId current portal instance id
	 * @param groupId current community/organization id
	 * @param layoutId current page id
	 * 
	 * @return list of rules all matching current company, group and layout.
	 */
	public List<ThemeRuleInfo> getThemeRulesInfo(long companyId, long groupId, long layoutId);

}
