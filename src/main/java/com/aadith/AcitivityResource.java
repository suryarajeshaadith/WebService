package com.aadith;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.aadith.model.Activity;
import com.aadith.model.User;
import com.aadith.repository.ActivityRepository;
import com.aadith.repository.ActivityRepositoryStub;

@Path("activity")
public class AcitivityResource {

	private ActivityRepository activityRepository = new ActivityRepositoryStub();

	@DELETE
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })

	public Response DeleteActivity(@PathParam("activityId") String activityId) {

		System.out.println(activityId);
		activityRepository.delete(activityId);
		return Response.ok().build();
	}

	@PUT
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })

	public Response UpdateActivit(Activity activity) {

		System.out.println(activity.getDescription());
		System.out.println(activity.getDuration());
		System.out.println(activity.getId());

		activity = activityRepository.update(activity);

		return Response.ok().entity(activity).build();
	}

	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })

	public Activity createActivit(Activity activity) {

		System.out.println(activity.getDescription());
		System.out.println(activity.getDuration());
		activityRepository.create(activity);
		return activity;

	}

	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })

	public Activity createActivityParam(MultivaluedMap<String, String> formParams) {
		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));

		Activity activity = new Activity();

		activity.setDescription(formParams.getFirst("description"));
		activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
		return activity;

	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Activity> getActivities() {

		return activityRepository.findAllActivity();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{activityId}")
	public Response getActivity(@PathParam("activityId") String activityId) {

		if (activityId == null || activityId.length() < 3) {

			return Response.status(Status.BAD_REQUEST).build();

		}

		Activity activity = activityRepository.findActivity(activityId);
		if (activity == null) {

			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok().entity(activity).build();

	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{activityId}/user")
	public User getUser(@PathParam("activityId") String activityId) {
		Activity activity = activityRepository.findActivity(activityId);
		User user = new User();
		user = activity.getUser();

		return user;
	}
}
