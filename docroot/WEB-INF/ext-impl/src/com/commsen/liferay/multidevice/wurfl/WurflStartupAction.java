package com.commsen.liferay.multidevice.wurfl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import net.sourceforge.wurfl.core.CustomWURFLHolder;
import net.sourceforge.wurfl.core.WURFLHolder;
import net.sourceforge.wurfl.core.resource.WURFLResource;
import net.sourceforge.wurfl.core.resource.WURFLResources;
import net.sourceforge.wurfl.core.resource.XMLResource;

import com.commsen.liferay.multidevice.DevicesUtil;
import com.liferay.portal.events.ServicePreAction;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PropsUtil;

public class WurflStartupAction extends Action {
 
	private static Log _log = LogFactoryUtil.getLog(ServicePreAction.class);
	
	private static final String WURFL_MAIN = "wurfl.main";
	private static final String WURFL_PATCHES = "wurfl.patches";
	
	
	
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
			throws ActionException {
		
		String main_file = PropsUtil.get(WURFL_MAIN);
		if (StringUtils.isBlank(main_file)) {
			_log.warn("Wurfl NOT initialised! Plase set '" + WURFL_MAIN + "' property!");
			return;
		}

		WURFLResource root = new XMLResource(main_file);
		_log.debug("Looking for Wurfl database in " + main_file);

		String[] patchFiles = PropsUtil.getArray(WURFL_PATCHES);
		WURFLResources patches = new WURFLResources();

		if (patchFiles != null) {
			for (String patchFile : patchFiles) {
				_log.debug("Looking for Wurfl patch in " + patchFile);
				WURFLResource patch = new XMLResource(patchFile);
				patches.add(patch);
			}	
		}

		WURFLHolder wurflHolder = new CustomWURFLHolder(root, patches);
		_log.debug("Wurfl initialised!");
		
		DevicesUtil.registerDeviceRecognitionProvider(new WurflDeviceRecognitionProvider(wurflHolder));
		DevicesUtil.refresh();
		_log.debug("DeviceUtils refreshed!");
		
	}

}
