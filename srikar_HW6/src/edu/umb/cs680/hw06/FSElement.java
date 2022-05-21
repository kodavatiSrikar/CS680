package edu.umb.cs680.hw06;

import java.time.LocalDateTime;


public abstract class FSElement {
	protected Directory Parent;
	protected String name;
	protected int sizeof;
	protected LocalDateTime creationTime;
	
	public FSElement(Directory Parent, String name, int sizeof, LocalDateTime creationTime) {
		this.Parent = Parent;
		this.name = name;
		this.sizeof = sizeof;
		this.creationTime = creationTime;
	}
	
	public void setParent(Directory parent) {
		this.Parent = Parent;
	}
	public Directory getParent() {
		return Parent;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return sizeof;
	}

	public void setSize(int size) {
		this.sizeof = size;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	
	public abstract boolean isDirectory();
	
	
}
