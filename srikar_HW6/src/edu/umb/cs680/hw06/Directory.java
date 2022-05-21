package edu.umb.cs680.hw06;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{
	private LinkedList<FSElement> children;
	
	public Directory(Directory Parent, String name, int sizeof, LocalDateTime creationTime) {
		super(Parent, name, sizeof, creationTime);
		this.children = new LinkedList<>();
	}
	
	public boolean isDirectory() {
		return true;
	}
	
	public LinkedList<FSElement> getChildren(){
		return this.children;
	}
	
	public void appendChild(FSElement child) {
		this.children.add(child);
		child.setParent(this);
	}
	
	public int countChildren() {
		return this.children.size();
	}
	
	public LinkedList<Directory> getSubDirectories() {
		LinkedList<Directory> subDirectories = new LinkedList<>();
		for (FSElement fselement : children) {
			if (fselement.isDirectory()) {
				Directory subDirect = (Directory)fselement;
				subDirectories.add(subDirect);
			}
		}
		return subDirectories;
	}
	
	public int getTotalSize() {
		int totalSize = 0;
		for (FSElement fselement : children) {
			if (fselement.isDirectory()) {
				Directory subDirectory = (Directory)fselement;
				totalSize += subDirectory.getTotalSize();
			}else {
				totalSize += fselement.getSize();
			}
		}
		return totalSize;
	}
	
	public LinkedList<File> getFiles(){
		LinkedList<File> files = new LinkedList<>();
		for (FSElement fselement : children) {
			if (!fselement.isDirectory()) {
				File file = (File)fselement;
				files.add(file);
			}
		}
		return files;
	}
	
	

}