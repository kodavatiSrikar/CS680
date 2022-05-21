package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class Link extends FSElement {
	private FSElement target;

	public Link(Directory Parent, String name, int sizeof, LocalDateTime creationTime, FSElement target) {
		super(Parent, name, sizeof, creationTime);
		this.target = target;
	}

	public boolean isDirectory() {
		return false;
	}

	public boolean isFile() {
		return false;
	}

	public boolean isLink() {
		return true;
	}
	
	public void setTarget(FSElement target) {
		this.target = target;
	}

	public FSElement getTarget() {
		return target;
	}
}