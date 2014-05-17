package com.qrcontactbook;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qrcontactbook.db.ContactData;

public class TestDBClassContactData {

	@Test
	public void testContactDataId() {
		ContactData cd1 = new ContactData();
		ContactData cd2 = new ContactData();
		
		assertNotNull(cd1.getId());
		assertNotNull(cd2.getId());
	}

	@Test
	public void testContactDataIdSet() {
		ContactData cd1 =new ContactData();
		ContactData cd2 = new ContactData();
		
		cd1.setId(5);
		cd2.setId(3);
		
		assertNotSame(cd1.getId(), cd2.getId());
		assertEquals(5, cd1.getId());
		assertEquals(3, cd2.getId());
	}
	
	@Test
	public void testContactDataContactId() {
		ContactData cd1 = new ContactData();
		ContactData cd2 = new ContactData();
		
		assertNotNull(cd1.getContactId());
		assertNotNull(cd2.getContactId());
	}

	@Test
	public void testContactDataContactIdSet() {
		ContactData cd1 =new ContactData();
		ContactData cd2 = new ContactData();
		
		cd1.setContactId(5);
		cd2.setContactId(3);
		
		assertNotSame(cd1.getContactId(), cd2.getContactId());
		assertEquals(5, cd1.getContactId());
		assertEquals(3, cd2.getContactId());
	}

	@Test
	public void testContactDataType() {
		ContactData cd1 = new ContactData();
		ContactData cd2 = new ContactData();
		
		assertNotNull(cd1.getType());
		assertNotNull(cd2.getType());
		assertEquals(cd1.getType(), cd2.getType());
	}
	
	@Test
	public void testContactDataTypeFunction() {
		ContactData cd1 = new ContactData();
		cd1.setType("type1");
		ContactData cd2 = new ContactData();
		cd2.setType("type2");
		
		assertEquals("type1", cd1.getType());
		assertEquals("type2", cd2.getType());
	}

	@Test
	public void testContactDataValue() {
		ContactData cd1 = new ContactData();
		ContactData cd2 = new ContactData();
		
		assertNotNull(cd1.getValue());
		assertNotNull(cd2.getValue());
		assertEquals(cd1.getValue(), cd2.getValue());
	}
	
	@Test
	public void testContactDataValueFunction() {
		ContactData cd1 = new ContactData();
		cd1.setValue("value1");
		ContactData cd2 = new ContactData();
		cd2.setValue("value2");
		
		assertEquals("value1", cd1.getValue());
		assertEquals("value2", cd2.getValue());
	}
	
	@Test
	public void testContactDataValueType() {
		ContactData cd1 = new ContactData();
		ContactData cd2 = new ContactData();
		
		assertNotNull(cd1.getVisibleType());
		assertNotNull(cd2.getVisibleType());
		assertEquals(cd1.getVisibleType(), cd2.getVisibleType());
	}
	
	@Test
	public void testContactDataValueTypeFunction() {
		ContactData cd1 = new ContactData();
		cd1.setVisibleType("valueType1");
		ContactData cd2 = new ContactData();
		cd2.setVisibleType("valueType2");
		
		assertEquals("valueType1", cd1.getVisibleType());
		assertEquals("valueType2", cd2.getVisibleType());
	}
	
	@Test
	public void testContactDataValueTypeFormatOne() {
		ContactData cd1 = new ContactData();
		cd1.setType("number:123");
		ContactData cd2 = new ContactData();
		cd2.setType("number:321");
		
		assertNotEquals("number:123", cd1.getVisibleType());
		assertNotEquals("number:321", cd2.getVisibleType());
	}
	
	@Test
	public void testContactDataValueTypeFormatTwo() {
		ContactData cd1 = new ContactData();
		cd1.setType("number:123");
		ContactData cd2 = new ContactData();
		cd2.setType("number:321");
		
		assertEquals("123", cd1.getVisibleType());
		assertEquals("321", cd2.getVisibleType());
	}
}
