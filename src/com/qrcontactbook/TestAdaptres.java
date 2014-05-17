package com.qrcontactbook;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.qrcontactbook.adapter.ContactAdapter;
import com.qrcontactbook.db.Contact;


public class TestAdaptres extends TestCase{
	private List<Contact> contacts;
	
	@Before
	public void setlist() {
		contacts = null;
		contacts = new ArrayList<Contact>();
		contacts.add(new Contact("contact1"));
		contacts.add(new Contact("contact2"));
		contacts.add(new Contact("contact3"));
		contacts.add(new Contact("contact4"));
		contacts.add(new Contact("contact5"));
	}
	
	@Test
	public void testAdapterList() {
		ContactAdapter adapter = new ContactAdapter(null);
		contacts.clear();
		contacts.add(null);
		adapter.setData(contacts);
		
		assertNull(adapter.getItem(0));
		
	}
	
	@Test
	public void testAdapterListTwo() {
		ContactAdapter adapter = new ContactAdapter(null);
		adapter.setData(contacts);
		
		assertNotNull(adapter.getItem(0));
	}
	
	@Test
	public void testAdapterListThree() {
		ContactAdapter adapter = new ContactAdapter(null);
		adapter.setData(contacts);
		
		assertEquals(5, adapter.getCount());
	}
	
	@Test
	public void testAdapterListData() {
		ContactAdapter adapter = new ContactAdapter(null);
		adapter.setData(contacts);
		
		assertEquals("contact1", adapter.getItem(0).getName());
		assertEquals("contact5", adapter.getItem(4).getName());
		
	}
	
	@Test
	public void testAdapterListDataTwo() {
		ContactAdapter adapter = new ContactAdapter(null);
		adapter.setData(contacts);
		
		assertEquals(0, adapter.getItem(0).getId());
		assertEquals(0, adapter.getItem(4).getId());
		
	}


}
