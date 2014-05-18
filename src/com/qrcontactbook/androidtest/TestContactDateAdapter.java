package com.qrcontactbook.androidtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.qrcontactbook.HomeActivity;
import com.qrcontactbook.adapter.ContactAdapter;
import com.qrcontactbook.adapter.ContactDataAdapter;
import com.qrcontactbook.db.ContactData;

public class TestContactDateAdapter extends
		ActivityInstrumentationTestCase2<HomeActivity> {

	private Activity activity;
	private List<ContactData> contacts;
	private int contact_id = 1;

	public TestContactDateAdapter() {
		super("com.qrcontactbook.adapter", HomeActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
		contacts = new ArrayList<ContactData>();
		contacts.add(new ContactData(1, "type1","value1"));
		contacts.add(new ContactData(1, "type2","value2"));
		contacts.add(new ContactData(1, "type3","value3"));
		contacts.add(new ContactData(1, "type4","value4"));
		contacts.add(new ContactData(1, "type5","value5"));
		
	}
	

	protected void tearDown() throws Exception {
		super.tearDown();
		contacts = null;
		contacts = new ArrayList<ContactData>();
		contacts.add(new ContactData(1, "type1","value1"));
		contacts.add(new ContactData(1, "type2","value2"));
		contacts.add(new ContactData(1, "type3","value3"));
		contacts.add(new ContactData(1, "type4","value4"));
		contacts.add(new ContactData(1, "type5","value5"));

	}

	public void testAdapterList() {
		ContactDataAdapter adapter = new ContactDataAdapter(activity);
		contacts.clear();
		contacts.add(null);
		adapter.setData(contacts);

		assertNull(adapter.getItem(0));
	}

	public void testAdapterListTwo() {
		ContactDataAdapter adapter = new ContactDataAdapter(activity);
		adapter.setData(contacts);

		assertNotNull(adapter.getItem(0));
	}

	public void testAdapterListThree() {
		ContactDataAdapter adapter = new ContactDataAdapter(activity);
		adapter.setData(contacts);

		assertEquals(5, adapter.getCount());
	}

	public void testAdapterListDataType() {
		ContactDataAdapter adapter = new ContactDataAdapter(activity);
		adapter.setData(contacts);

		assertEquals("type1", adapter.getItem(0).getType());
		assertEquals("type5", adapter.getItem(4).getType());
	}
	
	public void testAdapterListDataValue() {
		ContactDataAdapter adapter = new ContactDataAdapter(activity);
		adapter.setData(contacts);

		assertEquals("value1", adapter.getItem(0).getValue());
		assertEquals("value5", adapter.getItem(4).getValue());
	}
	
	public void testAdapterListDataVType() {
		ContactDataAdapter adapter = new ContactDataAdapter(activity);
		adapter.setData(contacts);

		assertEquals("type1", adapter.getItem(0).getVisibleType());
		assertEquals("type5", adapter.getItem(4).getVisibleType());
	}

	public void testAdapterListDataTwo() {
		ContactDataAdapter adapter = new ContactDataAdapter(activity);
		adapter.setData(contacts);

		assertEquals(0, adapter.getItem(0).getId());
		assertEquals(0, adapter.getItem(4).getId());
	}
	
	public void testAdapterListDataId() {
		ContactDataAdapter adapter = new ContactDataAdapter(activity);
		adapter.setData(contacts);

		assertEquals(adapter.getItem(0).getId(), adapter.getItem(4).getId());
		assertEquals(adapter.getItem(2).getContactId(), adapter.getItem(3).getContactId());
	}
	
	public void testAdapterListView() {
		ContactDataAdapter adapter = new ContactDataAdapter(activity);
		adapter.setData(contacts);
		
		assertNotNull(adapter.getView(2, null, null));
	}

}
