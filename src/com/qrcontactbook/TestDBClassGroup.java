package com.qrcontactbook;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qrcontactbook.db.Group;

public class TestDBClassGroup {

	@Test
	public void testGroupId() {
		Group group1 = new Group();
		Group group2 = new Group();
		
		assertNotNull(group1.getId());
		assertNotNull(group2.getId());
	}

	@Test
	public void testGroupIdSet() {
		Group group1 =new Group();
		Group group2 = new Group();
		
		group1.setId(5);
		group2.setId(3);
		
		assertNotSame(group1.getId(), group2.getId());
		assertEquals(5, group1.getId());
		assertEquals(3, group2.getId());
	}

	@Test
	public void testGroupName() {
		Group group1 = new Group();
		Group group2 = new Group();
		
		assertNotNull(group1.getName());
		assertNotNull(group2.getName());
		assertEquals(group1.getName(), group2.getName());
	}
	
	@Test
	public void testGroupNameConstructor() {
		Group group1 = new Group("name1");
		Group group2 = new Group("name2");
		
		assertEquals("name1", group1.getName());
		assertEquals("name2", group2.getName());
	}
	
	@Test
	public void testGroupNameFunction() {
		Group group1 = new Group();
		group1.setName("name1");
		Group group2 = new Group();
		group2.setName("name2");
		
		assertEquals("name1", group1.getName());
		assertEquals("name2", group2.getName());
	}

}
