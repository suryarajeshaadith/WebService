package com.aadith.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.aadith.model.Activity;

public class ActivityClient {

	private Client client;

	public ActivityClient() {

		client = ClientBuilder.newClient();
	}

	public Activity get(String id) {
		WebTarget target = client.target("http://localhost:8080/FitnessService/webapi/");

		Response response = target.path("activity/" + id).request().get(Response.class);
		if (response.getStatus() != 200) {

			throw new RuntimeException(response.getStatus() + ": there was an error on the server");
		}

		return response.readEntity(Activity.class);
	}

	public List<Activity> get() {

		WebTarget target = client.target("http://localhost:8080/FitnessService/webapi/");
		List<Activity> response = target.path("activity").request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Activity>>() {
				});
		return response;

	}

	public Activity create(Activity activity) {
		WebTarget target = client.target("http://localhost:8080/FitnessService/webapi/");

		Response response = target.path("activity/activity").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		if (response.getStatus() != 200) {

			throw new RuntimeException(response.getStatus() + ": there was an error on the server");
		}
		return response.readEntity(Activity.class);
	}

	public Activity update(Activity activity) {

		WebTarget target = client.target("http://localhost:8080/FitnessService/webapi/");

		Response response = target.path("activity/" + activity.getId()).request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(activity, MediaType.APPLICATION_JSON));
		if (response.getStatus() != 200) {

			throw new RuntimeException(response.getStatus() + ": there was an error on the server");
		}
		return response.readEntity(Activity.class);
	}

	public void delete(String activityId) {
		WebTarget target = client.target("http://localhost:8080/FitnessService/webapi/");

		Response response = target.path("activity/" + activityId).request(MediaType.APPLICATION_JSON).delete();
		if (response.getStatus() != 200) {

			throw new RuntimeException(response.getStatus() + ": there was an error on the server");
		}
	}

}
