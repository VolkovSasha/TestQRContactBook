package com.qrcontactbook.androidtest;

import java.util.ArrayList;
import java.util.List;

import com.qrcontactbook.HomeActivity;
import com.qrcontactbook.adapter.ContactAdapter;
import com.qrcontactbook.db.Contact;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

public class TestContactAdapter extends
		ActivityInstrumentationTestCase2<HomeActivity> {
	
	private Activity activity;
	private List<Contact> contacts;
	
	public TestContactAdapter() {
	       super("com.qrcontactbook.adapter", HomeActivity.class);
	   }
	
	protected void setUp() throws Exception {
	       super.setUp();
	       activity = getActivity();
	   		contacts = new ArrayList<Contact>();
	   		contacts.add(new Contact("contact1"));
	   		contacts.add(new Contact("contact2"));
	   		contacts.add(new Contact("contact3"));
	   		contacts.add(new Contact("contact4"));
	   		contacts.add(new Contact("contact5"));
	   }
	
	protected void tearDown() throws Exception{
		super.tearDown();
		contacts = null;
   		contacts = new ArrayList<Contact>();
   		contacts.add(new Contact("contact1"));
   		contacts.add(new Contact("contact2"));
   		contacts.add(new Contact("contact3"));
   		contacts.add(new Contact("contact4"));
   		contacts.add(new Contact("contact5"));
		
	}
	
	public void testAdapterList() {
		ContactAdapter adapter = new ContactAdapter(activity);
		contacts.clear();
		contacts.add(null);
		adapter.setData(contacts);
		
		assertNull(adapter.getItem(0));
	}
	public void testAdapterListTwo() {
		ContactAdapter adapter = new ContactAdapter(activity);
		adapter.setData(contacts);
		
		assertNotNull(adapter.getItem(0));
	}
	
	public void testAdapterListThree() {
		ContactAdapter adapter = new ContactAdapter(activity);
		adapter.setData(contacts);
		
		assertEquals(5, adapter.getCount());
	}
	
	public void testAdapterListData() {
		ContactAdapter adapter = new ContactAdapter(activity);
		adapter.setData(contacts);
		
		assertEquals("contact1", adapter.getItem(0).getName());
		assertEquals("contact5", adapter.getItem(4).getName());
		
	}
	
	public void testAdapterListDataTwo() {
		ContactAdapter adapter = new ContactAdapter(activity);
		adapter.setData(contacts);
		
		assertEquals(0, adapter.getItem(0).getId());
		assertEquals(0, adapter.getItem(4).getId());
	}

	public void testAdapterListView() {
		ContactAdapter adapter = new ContactAdapter(activity);
		adapter.setData(contacts);
		
		assertNotNull(adapter.getView(2, null, null));
	}

}
