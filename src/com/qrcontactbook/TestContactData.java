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
import com.qrcontactbook.db.ContactData;
import com.qrcontactbook.db.Group;
import com.qrcontactbook.db.TestDbHelper;
import com.qrcontactbook.manager.ContactDataManager;

public class TestContactData {

	static ContactDataManager cm = null;
	static ConnectionSource connectionSource = null;

	@BeforeClass
    public static void setUpDatabaseLayer() throws SQLException {
        connectionSource = new TestDbHelper().getConnectionSource();
        TableUtils.createTableIfNotExists(connectionSource, ContactData.class);
        cm = new ContactDataManager();
		Dao<ContactData, Integer> dao;
		try {
			dao = DaoManager.createDao(connectionSource, ContactData.class);
			cm.setContactDataDao(dao);
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
	public void testGetVisibleType() {
		final int contact_id = 1;
		try{
			cm.create(new ContactData(contact_id, "E-mail", "dmail@mail.com"));
			cm.create(new ContactData(contact_id, "number:mobile", "85435466"));
			cm.create(new ContactData(contact_id, "number:work", "8543554466"));
			cm.create(new ContactData(contact_id, "number:home", "8543546456446"));
			List<ContactData> list = cm.getBaseContactData(contact_id);
			
			ContactData data1 = list.get(0);
			ContactData data2 = list.get(1);
			ContactData data3 = list.get(2);
			ContactData data4 = list.get(3);
			
			assertEquals("mobile", data1.getVisibleType());
			assertEquals("work", data2.getVisibleType());
			assertEquals("home", data3.getVisibleType());
			assertEquals("E-mail", data4.getVisibleType());
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
