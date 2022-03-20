package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedHashMap;

public class FIFOFileCache extends FileCache{
	private int size;
	public Path removeKey;
	
	public FIFOFileCache(int size) {
		this.size = size;
		cache = new LinkedHashMap<>();
	}

	protected boolean isCached(Path path) {
		if(cache.containsKey(path)) {
			return true;
		}else {
			return false;
		}
	}

	protected boolean isCacheFull() {
		if(cache.size() == size) {
			return true;
		}else {
			return false;
		}
	}

	protected void cacheFile(Path path) {
		try {
			String file_content = Files.readString(path);
			cache.put(path, file_content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void replace(Path path) {
		try {
			String file_content = Files.readString(path);
			Path FIFOKey = cache.keySet().iterator().next();
			this.removeKey= FIFOKey;
			cache.remove(FIFOKey);
			cache.put(path, file_content);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}