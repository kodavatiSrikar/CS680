package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;
import edu.umb.cs680.hw07.Link;

public class DirectoryTest {
	private static Directory root;
	private static Directory apps;
	private static Directory bin;
	private static Directory home;
	private static Directory pictures;
	private static File index;
	private static File y;
	private static File sun;
	private static File moon;
	private static File c;
	private static Link nex;
	private static Link n;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new Directory(null, "root", 0, LocalDateTime.now());
		apps = new Directory(root, "apps", 0, LocalDateTime.now());
		bin = new Directory(root, "bin", 0, LocalDateTime.now());
		home = new Directory(root, "home", 0, LocalDateTime.now());
		pictures = new Directory(home, "pictures", 0, LocalDateTime.now());
		index = new File(apps, "index", 10, LocalDateTime.now());
		y = new File(bin, "y", 20, LocalDateTime.now());
		sun = new File(pictures, "sun", 30, LocalDateTime.now());
		moon = new File(pictures, "moon", 40, LocalDateTime.now());
		c = new File(home, "c", 50, LocalDateTime.now());
		nex = new Link(home, "m", 10, LocalDateTime.now(), bin);
		n = new Link(pictures, "n", 0, LocalDateTime.now(), y);
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(index);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		home.appendChild(nex);
		pictures.appendChild(sun);
		pictures.appendChild(moon);
		pictures.appendChild(n);
	}

	private String[] dirToStringArr(Directory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getTotalSize()),
				String.valueOf(d.getCreationTime()), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	
	
	@Test
	public void verifyDirectoryHome() {
		String[] expected = { "true", "home", "130", String.valueOf(home.getCreationTime()), "3" };
		Directory actual = home;
		assertArrayEquals(expected, dirToStringArr(actual));
	}
	
	@Test
	public void isDirectoyRoot() {
		assertTrue(root.isDirectory());
	}
	
	
	
	@Test
	public void appendChildrenRoot() {
		assertSame(root, apps.getParent());
	}
	
	@Test
	public void appendChildrenHome() {
		assertSame(home, c.getParent());
	}
	@Test
	public void verifyDirectoryRoot() {
		String[] expected = { "true", "root", "160", String.valueOf(root.getCreationTime()), "3" };
		Directory actual = root;
		assertArrayEquals(expected, dirToStringArr(actual));
	}
	@Test
	public void isFileRoot() {
		assertFalse(root.isFile());
	}
	
	@Test
	public void isLinkRoot() {
		assertFalse(root.isLink());
	}
	
	@Test
	public void countChildrenRoot() {
		assertEquals(3, root.countChildren());;
	}
	
	@Test
	public void countChildrenHome() {
		assertSame(3, home.countChildren());
	}
	
	@Test
	public void getSubDirectoriesRoot() {
		Directory[] expected = new Directory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		Directory[] actual = new Directory[3];
		LinkedList<Directory> subDirectories = root.getSubDirectories();
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getSubDirectoriesHome() {
		assertSame(pictures, home.getSubDirectories().get(0));
	}
	
	
	
	@Test
	public void getLinksHome() {
		assertSame(nex, home.getLinks().get(0));
	}
	
	@Test
	public void getLinksPictures() {
		assertSame(n, pictures.getLinks().get(0));
	}
	
	@Test
	public void getTotalSizeRoot() {
		assertEquals(160, root.getTotalSize());
	}
	
	@Test
	public void getTotalSizeHome() {
		
		assertEquals(130, home.getTotalSize());
	}

}
