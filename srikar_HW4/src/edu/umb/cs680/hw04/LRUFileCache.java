package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedHashMap;

public class LRUFileCache extends FileCache{
	private int size;
	public Path removeKey;
	
	public LRUFileCache(int size) {
		this.size = size;
		cache = new LinkedHashMap<>(size, 0.75f, true);
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

	@Override
	protected void cacheFile(Path path) {
		try {
			String file_content = Files.readString(path);
			cache.put(path, file_content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void replace(Path path) {
		try {
			String file_content = Files.readString(path);
			Path LRUKey = cache.keySet().iterator().next();
			this.removeKey= LRUKey;
			cache.remove(LRUKey);
			cache.put(path, file_content);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
