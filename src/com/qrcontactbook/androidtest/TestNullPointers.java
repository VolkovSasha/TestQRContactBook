package com.qrcontactbook.androidtest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.qrcontactbook.HomeActivity;
import com.qrcontactbook.db.Contact;

public class TestNullPointers extends
ActivityInstrumentationTestCase2<HomeActivity>{
	
	private Activity activity;
	
	public TestNullPointers() {
	       super("com.qrcontactbook.adapter", HomeActivity.class);
	   }
	
	protected void setUp() throws Exception {
	       super.setUp();
	       activity = getActivity();
	   }
	
	protected void tearDown() throws Exception{
		super.tearDown();

	}

}
