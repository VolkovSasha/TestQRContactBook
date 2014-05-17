package com.qrcontactbook;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qrcontactbook.db.Contact;

public class TestDBClassContact {

	@Test
	public void testContactId() {
		Contact contact1 = new Contact();
		Contact contact2 = new Contact();
		
		assertNotNull(contact1.getId());
		assertNotNull(contact2.getId());
	}

	@Test
	public void testContactIdSet() {
		Contact contact1 =new Contact();
		Contact contact2 = new Contact();
		
		contact1.setId(5);
		contact2.setId(3);
		
		assertNotSame(contact1.getId(), contact2.getId());
		assertEquals(5, contact1.getId());
		assertEquals(3, contact2.getId());
	}

	@Test
	public void testContactName() {
		Contact contact1 = new Contact();
		Contact contact2 = new Contact();
		
		assertNotNull(contact1.getName());
		assertNotNull(contact2.getName());
		assertEquals(contact1.getName(), contact2.getName());
	}
	
	@Test
	public void testContactNameConstructor() {
		Contact contact1 = new Contact("name1");
		Contact contact2 = new Contact("name2");
		
		assertEquals("name1", contact1.getName());
		assertEquals("name2", contact2.getName());
	}
	
	@Test
	public void testContactNameFunction() {
		Contact contact1 = new Contact();
		contact1.setName("name1");
		Contact contact2 = new Contact();
		contact2.setName("name2");
		
		assertEquals("name1", contact1.getName());
		assertEquals("name2", contact2.getName());
	}
}
