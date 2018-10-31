package com.google.geocoder;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ErrorMessage {

	@JsonProperty("error_message")
	private String errorMessage;

	@JsonProperty("results")
	private List<Object> results;

	@JsonProperty("status")
	private String status;

	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage(){
		return errorMessage;
	}

	public void setResults(List<Object> results){
		this.results = results;
	}

	public List<Object> getResults(){
		return results;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ErrorMessage{" +
			"error_message = '" + errorMessage + '\'' + 
			",results = '" + results + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}