package edu.umb.cs680.hw14;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw14.ApfsDirectory;
import edu.umb.cs680.hw14.ApfsFile;
import edu.umb.cs680.hw14.ApfsLink;

public class ApfsLinkTest {
	private static ApfsDirectory root;
	private static ApfsDirectory apps;
	private static ApfsDirectory bin;
	private static ApfsDirectory home;
	private static ApfsDirectory pictures;
	private static ApfsFile nex;
	private static ApfsFile y;
	private static ApfsFile sun;
	private static ApfsFile moon;
	private static ApfsFile c;
	private static ApfsLink m;
	private static ApfsLink n;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new ApfsDirectory(null, "root", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		apps = new ApfsDirectory(root, "apps", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		bin = new ApfsDirectory(root, "bin", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		home = new ApfsDirectory(root, "home", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		pictures = new ApfsDirectory(home, "pictures", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		nex = new ApfsFile(apps, "x", 10, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		y = new ApfsFile(bin, "y", 20, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		sun = new ApfsFile(pictures, "a", 30, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		moon = new ApfsFile(pictures, "b", 40, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		c = new ApfsFile(home, "c", 50, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		m = new ApfsLink(home, "m", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime", bin);
		n = new ApfsLink(pictures, "n", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime", y);
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
	
	private String[] linkToStringArray(ApfsLink l) {
		String[] linkInfo = { String.valueOf(l.isLink()), l.getOwnerName(), String.valueOf(l.getSize()),
						l.getLastModifiedTime(), l.getParent().getName(), l.getTarget().getName() };
		return linkInfo;
	}

	@Test
	public void verifyLinkEqualityM() {
		String[] expected = { "true", "defaultOwnerName", "0", "defaultLastModifiedTime", "home", "bin" };
		ApfsLink actual = m;
		assertArrayEquals(expected, linkToStringArray(actual));
	}
	
	@Test
	public void verifyLinkEqualityN() {
		String[] expected = { "true", "defaultOwnerName", "0", "defaultLastModifiedTime", "pictures", "y" };
		ApfsLink actual = n;
		assertArrayEquals(expected, linkToStringArray(actual));
	}

	@Test
	public void isDirectoyTestingWithM() {
		assertFalse(m.isDirectory());
	}
	
	
	
	@Test
	public void getTargetTestingWithM() {
		assertSame(bin, m.getTarget());
	}
	
	@Test
	public void setTargetTestingWithM() {
		m.setTarget(apps);
		assertSame(apps, m.getTarget());
	}
	@Test
	public void isFileTestingWithM() {
		assertFalse(m.isFile());
	}
	
	@Test
	public void isLinkTestingWithM() {
		assertTrue(m.isLink());
	}

}
