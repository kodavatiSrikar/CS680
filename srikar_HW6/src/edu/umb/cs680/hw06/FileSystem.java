package edu.umb.cs680.hw06;

import java.util.LinkedList;


public class FileSystem {

	private static FileSystem instance = null;
	private LinkedList<Directory> rootDirectories;
	
	private FileSystem() {
		this.rootDirectories = new LinkedList<>();
	}
	
	public static FileSystem getFileSystem() {
		if (instance == null) {
			instance = new FileSystem();
		}
		return instance;
	}
	public void appendRootDirectory(Directory rootdir) {
		rootDirectories.add(rootdir);
		
	}
	
	public LinkedList<Directory> getRootDirectories(){
		return rootDirectories;
	}
	
	
}
