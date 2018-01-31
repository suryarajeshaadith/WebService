package com.aadith.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
private String Name;
private String Id;
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}

}
