package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;
import edu.umb.cs680.hw07.Link;

public class FileTest {
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
	private static Link m;
	private static Link n;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new Directory(null, "root", 0, LocalDateTime.now());
		apps = new Directory(root, "apps", 0, LocalDateTime.now());
		bin = new Directory(root, "bin", 0, LocalDateTime.now());
		home = new Directory(root, "home", 0, LocalDateTime.now());
		pictures = new Directory(home, "pictures", 0, LocalDateTime.now());
		nex = new File(apps, "x", 20, LocalDateTime.now());
		y = new File(bin, "y", 20, LocalDateTime.now());
		sun = new File(pictures, "a", 30, LocalDateTime.now());
		moon = new File(pictures, "b", 40, LocalDateTime.now());
		c = new File(home, "c", 50, LocalDateTime.now());
		m = new Link(home, "m", 0, LocalDateTime.now(), bin);
		n = new Link(pictures, "n", 0, LocalDateTime.now(), y);
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(nex);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		home.appendChild(m);
		pictures.appendChild(sun);
		pictures.appendChild(moon);
		pictures.appendChild(n);
	}
	
	private String[] fileToStringArr(File f) {
		String[] fileInfo = { String.valueOf(f.isFile()), f.getName(), String.valueOf(f.getSize()),
				String.valueOf(f.getCreationTime()), f.getParent().getName() };
		return fileInfo;
	}

	@Test
	public void verifyFileX() {
		String[] expected = { "true", "x", "20", String.valueOf(nex.getCreationTime()), "apps" };
		File actual = nex;
		assertArrayEquals(expected, fileToStringArr(actual));
	}
	
	
	
	@Test
	public void isFileB() {
		assertTrue(moon.isFile());
	}
	
	@Test
	public void isLinkB() {
		assertFalse(moon.isLink());
	}
	@Test
	public void verifyFileA() {
		String[] expected = { "true", "a", "30", String.valueOf(sun.getCreationTime()), "pictures" };
		File actual = sun;
		assertArrayEquals(expected, fileToStringArr(actual));
	}

	@Test
	public void isDirectoyB() {
		assertFalse(moon.isDirectory());
	}

}