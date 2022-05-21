package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import edu.umb.cs680.hw09.apfs.ApfsFileSearchVisitor;

public class ApfsFileSearchVisitorTest {
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

	@Test
	public void searchFileATest() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("a");
		root.accept(visitor);
		assertSame(sun, visitor.getFoundFiles().get(0));
	}
	
	@Test
	public void seachFilesABCTest() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("a");
		root.accept(visitor);
		visitor.setFileName("b");
		root.accept(visitor);
		visitor.setFileName("c");
		root.accept(visitor);
		LinkedList<ApfsFile> actual = visitor.getFoundFiles();
		LinkedList<ApfsFile> expected = new LinkedList<>();
		expected.add(sun);
		expected.add(moon);
		expected.add(c);
		assertArrayEquals(expected.toArray(), actual.toArray());
	}

}
