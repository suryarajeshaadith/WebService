package com.aadith.client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.aadith.model.Activity;

public class ActivityClientTest {

	@Test
	public void testCreate() {

		ActivityClient client = new ActivityClient();

		Activity activity = new Activity();

		activity.setDescription("running");
		activity.setDuration(60);
		activity = client.create(activity);

		assertNotNull(activity);

	}
	
	@Test
	public void testDelete() {

		ActivityClient client = new ActivityClient();
		
		client.delete("123");
		
	}
	
	
	@Test
	public void testPut() {

		ActivityClient client = new ActivityClient();

		Activity activity = new Activity();
        
		activity.setId("33");
		activity.setDescription("running");
		activity.setDuration(60);
		activity = client.update(activity);

		assertNotNull(activity);

	}

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();

		Activity activity = client.get("123");

		System.out.println(activity);

		assertNotNull(activity);
	}

	@Test
	public void testGetList() {

		ActivityClient client = new ActivityClient();

		List<Activity> activities = client.get();
		System.out.println(activities);
		assertNotNull(activities);

	}

	@Test(expected = RuntimeException.class)
	public void testGetWithBadRequest() {

		ActivityClient client = new ActivityClient();

		client.get("12");
	}

	@Test(expected = RuntimeException.class)
	public void testGetNotFound() {

		ActivityClient client = new ActivityClient();

		client.get("777");
	}
}
