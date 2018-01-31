package com.aadith.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Activity {
private String description;
private int duration;
private String Id;
private User user;


public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}


}
