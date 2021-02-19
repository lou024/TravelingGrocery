package edu.csc480.helloworld.mork;

import javax.validation.constraints.NotEmpty;

public class ShinyThing {

	@NotEmpty(message = "Shiny things must have a name")
	private String name;

	@NotEmpty(message = "What is this shiny thing?")
	private String description;

	private String idNode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCrewID(){
		return idNode;
	}

	public void setIdNode(String idNode) {
		this.idNode = idNode;
	}

}
