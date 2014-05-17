package com.qrcontactbook.androidtest;

import static org.junit.Assert.*;

import org.junit.Test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.qrcontactbook.HomeActivity;

public class TestPhoneDataInputOutput extends
 		ActivityInstrumentationTestCase2<HomeActivity>{

private Activity activity;
	
	public TestPhoneDataInputOutput() {
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
