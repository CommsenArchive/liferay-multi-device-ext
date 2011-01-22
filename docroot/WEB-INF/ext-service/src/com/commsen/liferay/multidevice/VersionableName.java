package com.commsen.liferay.multidevice;

import java.io.Serializable;
import java.util.Set;

public interface VersionableName extends Comparable<VersionableName>, Serializable {

	public abstract String getName();

	public abstract Set<String> getVersions();

}