package com.commsen.liferay.multidevice;

public class CapabilityValue {

	private String name;
	
	private String value;

	
	public CapabilityValue(String name, String value) {
		super();
		if (name == null) throw new IllegalArgumentException ("Capabilty name is null. Can not create CapabilityValue object without capability name!"); 
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
