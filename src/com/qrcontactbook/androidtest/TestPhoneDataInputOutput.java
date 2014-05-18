package com.qrcontactbook.androidtest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.qrcontactbook.ContactApp;
import com.qrcontactbook.HomeActivity;
import com.qrcontactbook.db.Contact;
import com.qrcontactbook.db.ContactData;

public class TestPhoneDataInputOutput extends
		ActivityInstrumentationTestCase2<HomeActivity> {

	private Activity activity;
	private ContactApp app;

	public TestPhoneDataInputOutput() {
		super("com.qrcontactbook.adapter", HomeActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
		app = (ContactApp) activity.getApplication();
	}

	protected void tearDown() throws Exception {
		super.tearDown();

	}

	public void testNewContact() {
		final String name = "NewContact";
		List<Contact> list = app.getContactManager().getPhoneContactList(
				activity);
		int listSize1 = list.size();

		try {
			app.getContactManager().createPhoneContact(name, "0551237654",
					activity);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		list = app.getContactManager().getPhoneContactList(activity);
		int listSize2 = list.size();

		app.getContactManager().deletePhoneContact(name, activity);

		assertEquals(listSize1, (listSize2 - 1));
	}

	public void testDeleteContact() {
		final String name = "NewContact";
		List<Contact> list = app.getContactManager().getPhoneContactList(
				activity);
		int listSize1 = list.size();

		try {
			app.getContactManager().createPhoneContact(name, "0551237654",
					activity);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		list = app.getContactManager().getPhoneContactList(activity);
		int listSize2 = list.size();

		app.getContactManager().deletePhoneContact(name, activity);

		list = app.getContactManager().getPhoneContactList(activity);
		int listSize3 = list.size();

		assertEquals(listSize1, (listSize2 - 1));
		assertEquals(listSize1, listSize3);
	}

	public void testNewContactNumber() {
		final String name = "NewContact";
		final String number = "0957541234";

		try {
			app.getContactManager().createPhoneContact(name, number, activity);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		List<Contact> list = app.getContactManager().getPhoneContactList(
				activity);
		List<ContactData> data = null;
		for (Contact con : list)
			if (name.equals(con.getName()))
				data = app.getContactDataManager().getPhoneContactNumbers(
						con.getId(), activity);

		String num = "";
		if (data != null)
			num = data.get(0).getValue();

		app.getContactManager().deletePhoneContact(name, activity);

		assertEquals(number, num);
	}

	public void testExisitsContactMail() {
		final String name = "test";
		final String mail = "azaza@mail.ru";

		List<Contact> list = app.getContactManager().getPhoneContactList(
				activity);
		List<ContactData> data = null;
		for (Contact con : list)
			if (name.equals(con.getName()))
				data = app.getContactDataManager().getPhoneContactMails(
						con.getId(), activity);

		String mailActual = "";
		if (data != null)
			mailActual = data.get(0).getValue();

		assertEquals(mail, mailActual);
	}

	public void testExisitsContactData() {
		final String name = "test";
		final String number = "0954528745";
		final String mail = "azaza@mail.ru";

		List<Contact> list = app.getContactManager().getPhoneContactList(
				activity);
		List<ContactData> data = null;
		for (Contact con : list)
			if (name.equals(con.getName()))
				data = app.getContactDataManager().getPhoneContactData(
						con.getId(), activity);

		assertEquals(number, data.get(0).getValue());
		assertEquals(mail, data.get(1).getValue());
	}
	
	public void testExisitsContactGroup() {
		final String name = "test";

		List<Contact> list = app.getContactManager().getPhoneContactList(
				activity);
		String group = "";
		for (Contact con : list)
			if (name.equals(con.getName()))
				group = app.getContactDataManager().getPhoneContactGroup(
						con.getId(), activity);

		assertEquals("No group", group);
	}
	
	public void testExisitsContactFirstMail() {
		final String name = "test";
		final String mail = "azaza@mail.ru";

		List<Contact> list = app.getContactManager().getPhoneContactList(
				activity);
		String mailAc = "";
		for (Contact con : list)
			if (name.equals(con.getName()))
				mailAc = app.getContactDataManager().getPhoneContactFirstMail(
						con.getId(), activity);

		assertEquals(mail, mailAc);
	}
}
