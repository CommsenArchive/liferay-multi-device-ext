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
package com.commsen.liferay.multidevice;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Milen Dyankov
 *
 */
public class VersionableNameImpl implements VersionableName {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    
	private String name;
	private Set<String> versions;


	public VersionableNameImpl(String name, Set<String> versions) {
		if (name == null) throw new IllegalArgumentException("Can not create VersionableName without name!");
		this.name = name;
		this.versions = versions;
	}


	public VersionableNameImpl(String name, String version) {
		this(name, new HashSet<String>());
		this.versions.add(version);
	}


	public VersionableNameImpl(String name) {
		this(name, (Set<String>) null);
	}


	/*
	 * (non-Javadoc)
	 * @see com.commsen.liferay.multidevice.VersionableProduct#getName()
	 */
	@Override
	public String getName() {
		return name;
	}


	/*
	 * (non-Javadoc)
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
		return this.getName().equals(((VersionableName) copy).getName());
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
