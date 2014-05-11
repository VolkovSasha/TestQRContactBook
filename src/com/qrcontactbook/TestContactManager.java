package com.qrcontactbook;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.qrcontactbook.db.Contact;
import com.qrcontactbook.db.TestDbHelper;
import com.qrcontactbook.manager.ContactManager;

public class TestContactManager {
	
	static ContactManager cm = null;
	static ConnectionSource connectionSource = null;

	@BeforeClass
    public static void setUpDatabaseLayer() throws SQLException {
        connectionSource = new TestDbHelper().getConnectionSource();
        TableUtils.createTableIfNotExists(connectionSource, Contact.class);
        cm = new ContactManager();
		Dao<Contact, Integer> dao;
		try {
			dao = DaoManager.createDao(connectionSource, Contact.class);
			cm.setContactDao(dao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    }
	
	@Before
	public void clearData(){
		try {
			TableUtils.clearTable(connectionSource, Contact.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testCreate() {
		final String name = "Trololo";
		Contact cont = new Contact();
		cont.setName(name);
		try{
			cm.create(cont);
			List<Contact> list = cm.getAll();
			assertEquals(name, list.get(0).getName());
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		final String updName = "Trololo2";
		Contact cont = new Contact();
		cont.setName("Trololo");
		try{
			cm.create(cont);
			cont.setName(updName);
			cm.update(cont);
			List<Contact> list = cm.getAll();
			assertEquals(updName, list.get(0).getName());
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		Contact cont = new Contact();
		cont.setName("Trololo");
		try{
			cm.create(cont);
			cm.delete(cont);
			List<Contact> list = cm.getAll();
			assertEquals(0, list.size());
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAll() {
	
		try{
			cm.create(new Contact("Trololo1"));
			cm.create(new Contact("Trololo2"));
			cm.create(new Contact("Trololo3"));
			cm.create(new Contact("Trololo4"));
			cm.create(new Contact("Trololo5"));
			List<Contact> list = cm.getAll();
			assertEquals(5, list.size());
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testGetLast() {
	
		try{
			cm.create(new Contact("Trololo1"));
			cm.create(new Contact("Trololo2"));
			cm.create(new Contact("Trololo3"));
			cm.create(new Contact("Trololo4"));
			cm.create(new Contact("Trololo5"));
			Contact  contact = cm.getLast();
			assertEquals("Trololo5", contact.getName());
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
