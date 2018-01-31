package com.aadith.repository;

import java.util.List;

import com.aadith.model.Activity;

public interface ActivityRepository {

	List<Activity> findAllActivity();

	Activity findActivity(String activityId);

	Activity update(Activity activity);

	void create(Activity activity);

	void delete(String activityId);

	

}