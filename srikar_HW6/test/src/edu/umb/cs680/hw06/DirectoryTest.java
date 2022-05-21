package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw06.Directory;
import edu.umb.cs680.hw06.File;

public class DirectoryTest {
	private static Directory root;
	private static Directory apps;
	private static Directory bin;
	private static Directory home;
	private static Directory pictures;
	private static File nex;
	private static File y;
	private static File sun;
	private static File moon;
	private static File c;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new Directory(null, "root", 0, LocalDateTime.now());
		apps = new Directory(root, "apps", 0, LocalDateTime.now());
		bin = new Directory(root, "bin", 0, LocalDateTime.now());
		home = new Directory(root, "home", 0, LocalDateTime.now());
		pictures = new Directory(home, "pictures", 0, LocalDateTime.now());
		nex = new File(apps, "x", 10, LocalDateTime.now());
		y = new File(bin, "y", 20, LocalDateTime.now());
		sun = new File(pictures, "a", 30, LocalDateTime.now());
		moon = new File(pictures, "b", 40, LocalDateTime.now());
		c = new File(home, "c", 50, LocalDateTime.now());
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(nex);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		pictures.appendChild(sun);
		pictures.appendChild(moon);
	}

	private String[] dirToStringArray(Directory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getTotalSize()),
				String.valueOf(d.getCreationTime()), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	
	
	@Test
	public void verifyDirectoryHome() {
		String[] expected = { "true", "home", "120", String.valueOf(home.getCreationTime()), "2" };
		Directory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
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
	public void countChildrenRoot() {
		assertEquals(3, root.countChildren());;
	}
	
	@Test
	public void countChildrenHome() {
		assertSame(2, home.countChildren());
	}
	@Test
	public void verifyDirectoryRoot() {
		String[] expected = { "true", "root", "150", String.valueOf(root.getCreationTime()), "3" };
		Directory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
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
	public void getFilesHome() {
		assertSame(c, home.getFiles().get(0));
	}
	
	@Test
	public void getFilesPictures() {
		File[] expected = new File[2];
		expected[0] = sun;
		expected[1] = moon;
		File[] actual = new File[2];
		LinkedList<File> files = pictures.getFiles();
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getTotalSizeRoot() {
		assertEquals(150, root.getTotalSize());
	}
	
	@Test
	public void getTotalSizeHome() {
		assertEquals(120, home.getTotalSize());
	}

}
