package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw04.LRUFileCache;

class LRUFileCacheTest {
	private static LRUFileCache cache;
	private static Path p1;
	private static Path p2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cache = new LRUFileCache(2);
		p1 = Paths.get("filefortesting/test1.txt");
		p2 = Paths.get("filefortesting/test2.txt");
		cache.fetch(p1);
	}

	@Test
	public void fetchwithp1() throws IOException {
		assertEquals(Files.readString(p1), cache.fetch(p1));
	}
	
	@Test
	public void fetchwithp2() throws IOException {
		assertEquals(Files.readString(p2), cache.fetch(p2));
	}
	
	@Test
	public void checkcached() throws IOException {
		assertEquals(true, cache.isCached(p1));
	}
	@Test
	public void checkIsFull() throws IOException{
		cache.fetch(p2);
		assertEquals(true, cache.isCacheFull());
	}
	@Test
	public void checkReplace() throws IOException{
		cache.replace(p1);
		assertEquals(p1,cache.removeKey);
	}
	
	

}