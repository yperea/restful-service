package com.apimedic;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Symptom {

	@JsonProperty("ID")
	private int iD;

	@JsonProperty("Name")
	private String name;

	public void setID(int iD){
		this.iD = iD;
	}

	public int getID(){
		return iD;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Symptom{" +
			"iD = '" + iD + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}