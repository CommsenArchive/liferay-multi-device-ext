package com.commsen.liferay.multidevice;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import com.commsen.liferay.multidevice.VersionableName;



public class VersionableNameImpl implements VersionableName {
	
	private String name;
	private Set<String> versions;
	
	
	public VersionableNameImpl(String name, Set<String> versions) {
		if (name == null) throw new IllegalArgumentException("Can not create VersionableName without name!");
		this.name = name;
		this.versions = versions;
	}

	public VersionableNameImpl(String name) {
		this(name, null);
	}


	/* (non-Javadoc)
	 * @see com.commsen.liferay.multidevice.VersionableProduct#getName()
	 */
	@Override
	public String getName() {
		return name;
	}


	/* (non-Javadoc)
	 * @see com.commsen.liferay.multidevice.VersionableProduct#getVersions()
	 */
	@Override
	public Set<String> getVersions() {
		if (versions == null) return Collections.emptySet();
		return Collections.unmodifiableSet(versions);
	}

	public void addVersion(String version) {
		if (version == null) return;
		if (versions == null) versions = new TreeSet<String>();
		if (!versions.contains(version)) versions.add(version);
	}
	
	@Override
	public boolean equals(Object copy) {
		if (copy == null || !(copy instanceof VersionableName)) return false;
		return this.getName().equals(((VersionableName)copy).getName());
	}
	
	@Override
	public int hashCode() {
		 int hash = 1;
		 hash = hash * 31 + name.hashCode();
		 return hash;
	}
	
	@Override
	public String toString() {
		return "VersionableName (Name: " + name + ", Versions: " + versions + ")";
	}

	@Override
	public int compareTo(VersionableName o) {
		return this.name.toUpperCase().compareTo(o.getName().toUpperCase());
	}
}
