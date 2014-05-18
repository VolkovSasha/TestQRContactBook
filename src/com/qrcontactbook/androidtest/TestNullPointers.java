package com.qrcontactbook.androidtest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.LayoutInflater;

import com.qrcontactbook.HomeActivity;
import com.qrcontactbook.adapter.ContactAdapter;
import com.qrcontactbook.adapter.ContactDataAdapter;
import com.qrcontactbook.db.Contact;
import com.qrcontactbook.db.ContactData;

public class TestNullPointers extends
ActivityInstrumentationTestCase2<HomeActivity>{
	private List<Contact> contacts;
	private List<ContactData> contactData;
	private Activity activity;
	
	public TestNullPointers() {
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
	   		
	   		contactData = new ArrayList<ContactData>();
	   		contactData.add(new ContactData(1, "type1","value1"));
	   		contactData.add(new ContactData(1, "type2","value2"));
	   		contactData.add(new ContactData(1, "type3","value3"));
	   		contactData.add(new ContactData(1, "type4","value4"));
	   		contactData.add(new ContactData(1, "type5","value5"));
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
	   		
	   		contactData = new ArrayList<ContactData>();
	   		contactData.add(new ContactData(1, "type1","value1"));
	   		contactData.add(new ContactData(1, "type2","value2"));
	   		contactData.add(new ContactData(1, "type3","value3"));
	   		contactData.add(new ContactData(1, "type4","value4"));
	   		contactData.add(new ContactData(1, "type5","value5"));
	}
	
	public void testDataAdapterList() {
		ContactDataAdapter adapter = new ContactDataAdapter(activity);
		contactData.clear();
		contactData.add(null);
		adapter.setData(contactData);

		assertNull(adapter.getItem(0));
	}

	public void testDataAdapterListTwo() {
		ContactDataAdapter adapter = new ContactDataAdapter(activity);
		adapter.setData(contactData);

		assertNotNull(adapter.getItem(0));
	}
	
	public void testDataAdapterListView() {
		ContactDataAdapter adapter = new ContactDataAdapter(activity);
		adapter.setData(contactData);
		
		assertNotNull(adapter.getView(2, null, null));
	}
	
	public void testAdapterListView() {
		ContactAdapter adapter = new ContactAdapter(activity);
		adapter.setData(contacts);
		
		assertNotNull(adapter.getView(2, null, null));
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

}
