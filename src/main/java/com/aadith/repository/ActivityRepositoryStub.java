package com.aadith.repository;

import java.util.ArrayList;
import java.util.List;

import com.aadith.model.Activity;
import com.aadith.model.User;

public class ActivityRepositoryStub implements ActivityRepository {
	
	/* (non-Javadoc)
	 * @see com.aadith.repository.ActivityRepository#findAllActivity()
	 */
	@Override
	public List<Activity> findAllActivity(){
		
		List<Activity> activity= new ArrayList<Activity>();
		 
		Activity activity1= new Activity();
		
		activity1.setDescription("Swimming");
		activity1.setDuration(33);
		
		Activity activity2= new Activity();
		
		activity2.setDescription("running");
		activity2.setDuration(33);

		Activity activity3= new Activity();
		
		activity3.setDescription("biking");
		activity3.setDuration(33);
		
		activity.add(activity1);
		
		activity.add(activity2);
		activity.add(activity3);
		
		return activity;
		
	}

	@Override
	public Activity findActivity(String activityId) {
        
		if (activityId.equals("777")){
			
			return null;
		}
		
		Activity activity2= new Activity();
    	User user=new User();
    	
    	user.setId("33");
    	user.setName("aadith");
        activity2.setId("123");
		activity2.setDescription("running");
		activity2.setDuration(33);
		activity2.setUser(user);
		
	

		return activity2;
	}
	@Override
	public Activity update(Activity activity) {
		//search the database to see if we have an activity
				//select * from Activity where id = ?
				//if rs size == 0
				//insert into Activity table
				//else
				//update the activity
		return activity;
	}

	@Override
	public void create(Activity activity) {
		
		// insert statement to the database 
		
	}

	@Override
	public void delete(String activityId) {
		// add the delete query 
		
	}

}
