package com.qrcontactbook;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.qrcontactbook.db.Contact;
import com.qrcontactbook.db.ContactData;
import com.qrcontactbook.db.Group;
import com.qrcontactbook.db.TestDbHelper;
import com.qrcontactbook.manager.ContactDataManager;
import com.qrcontactbook.manager.ContactManager;

public class TestContactDataManager {
	
	static ContactDataManager cm = null;
	static ConnectionSource connectionSource = null;

	@BeforeClass
    public static void setUpDatabaseLayer() throws SQLException {
        connectionSource = new TestDbHelper().getConnectionSource();
        TableUtils.createTableIfNotExists(connectionSource, ContactData.class);
        TableUtils.createTableIfNotExists(connectionSource, Group.class);
        cm = new ContactDataManager();
		Dao<ContactData, Integer> dao;
		Dao<Group, Integer> gdao;
		try {
			dao = DaoManager.createDao(connectionSource, ContactData.class);
			cm.setContactDataDao(dao);
			gdao = DaoManager.createDao(connectionSource, Group.class);
			cm.setGroupDao(gdao);
			cm.getGroupDao().create(new Group("Vip"));
			cm.getGroupDao().create(new Group("Friends"));
			cm.getGroupDao().create(new Group("Family"));
			cm.getGroupDao().create(new Group("Work"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    }
	
	@Before
	public void clearData(){
		try {
			TableUtils.clearTable(connectionSource, ContactData.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testCreate() {
		final String type = "E-mail";
		final String value = "mail@mail.ru";
		final int contact_id = 1;
		ContactData cont = new ContactData();
		cont.setContactId(contact_id);
		cont.setType(type);
		cont.setValue(value);
		try{
			cm.create(cont);
			List<ContactData> list = cm.getBaseContactData(contact_id);
			assertEquals(type, list.get(0).getType());
			assertEquals(value, list.get(0).getValue());
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		final String type = "E-mail";
		final String value = "mail@mail.ru";
		final int contact_id = 1;
		ContactData cont = new ContactData();
		cont.setContactId(contact_id);
		cont.setType(type);
		cont.setValue(value);
		try{
			cm.create(cont);
			cm.delete(cont);
			List<ContactData> list = cm.getBaseContactData(contact_id);
			assertEquals(0, list.size());
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		final String type = "E-mail";
		final String updvalue = "mail@mail.ru";
		final int contact_id = 1;
		ContactData cont = new ContactData();
		cont.setContactId(contact_id);
		cont.setType(type);
		cont.setValue("trololo@mail.com");
		try{
			cm.create(cont);
			cont.setValue(updvalue);
			cm.update(cont);
			List<ContactData> list = cm.getBaseContactData(contact_id);
			assertEquals(updvalue, list.get(0).getValue());
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBaseGroupList() {
		try{
			
			Map<String, Long> glist = cm.getBaseGroupList();
			assertEquals(5, glist.size());
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBaseContactData() {
		final int contact_id = 1;
		try{
			cm.create(new ContactData(contact_id, "E-mail", "dmail@mail.com"));
			cm.create(new ContactData(contact_id, "number:mobile", "85435466"));
			cm.create(new ContactData(contact_id, "number:work", "8543554466"));
			cm.create(new ContactData(contact_id, "number:home", "8543546456446"));
			List<ContactData> list = cm.getBaseContactData(contact_id);
			assertEquals(4, list.size());
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBaseContactNumbers() {
		final int contact_id = 1;
		try{
			cm.create(new ContactData(contact_id, "E-mail", "dmail@mail.com"));
			cm.create(new ContactData(contact_id, "number:mobile", "85435466"));
			cm.create(new ContactData(contact_id, "number:work", "8543554466"));
			cm.create(new ContactData(contact_id, "number:home", "8543546456446"));
			List<ContactData> list = cm.getBaseContactNumbers(contact_id);
			assertEquals(3, list.size());
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBaseContactFirstMail() {
		final int contact_id = 1;
		final String mail = "dmail@mail.com";
		try{
			cm.create(new ContactData(contact_id, "E-mail", mail));
			cm.create(new ContactData(contact_id, "E-mail", "smail@mail.com"));
			cm.create(new ContactData(contact_id, "E-mail", "rmail@mail.com"));
			String list = cm.getBaseContactFirstMail(contact_id);
			assertEquals(mail, list);
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBaseContactMails() {
		final int contact_id = 1;
		try{
			cm.create(new ContactData(contact_id, "E-mail", "dmail@mail.com"));
			cm.create(new ContactData(contact_id, "E-mail", "erdmail@mail.com"));
			cm.create(new ContactData(contact_id, "number:mobile", "85435466"));
			cm.create(new ContactData(contact_id, "number:work", "8543554466"));
			cm.create(new ContactData(contact_id, "number:home", "8543546456446"));
			List<ContactData> list = cm.getBaseContactMails(contact_id);
			assertEquals(2, list.size());
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBaseContactGroup() {
		final int contact_id = 1;
		try{
			cm.create(new ContactData(contact_id, "E-mail", "dmail@mail.com"));
			cm.create(new ContactData(contact_id, "group", "1"));
			cm.create(new ContactData(contact_id, "number:mobile", "85435466"));
			String group1 = cm.getBaseContactGroup(contact_id);
			String group2 = cm.getBaseContactGroup(2);
			
			assertEquals("Vip", group1);
			assertEquals("No group", group2);
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBaseGroupId() {
		final int contact_id = 1;
		try{
			cm.create(new ContactData(contact_id, "E-mail", "dmail@mail.com"));
			cm.create(new ContactData(contact_id, "group", "1"));
			cm.create(new ContactData(contact_id, "number:mobile", "85435466"));
			long group1 = cm.getBaseGroupId(contact_id);
			long group2 = cm.getBaseGroupId(2);
			
			assertEquals(1, group1);
			assertEquals(-1, group2);
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBaseGroupName() {
		try{
			
			String group1 = cm.getBaseGroupName(1);
			String group2 = cm.getBaseGroupName(3);
			String group3 = cm.getBaseGroupName(-1);
			assertEquals("Vip", group1);
			assertEquals("Family", group2);
			assertEquals("No group", group3);
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
