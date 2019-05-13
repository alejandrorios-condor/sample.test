package com.alejandrorios.condorsports.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Team {

	@SerializedName("teams")
	@Expose
	private List<TeamData> teams;

	public List<TeamData> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamData> teams) {
		this.teams = teams;
	}
}
