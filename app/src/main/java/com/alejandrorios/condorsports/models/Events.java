package com.alejandrorios.condorsports.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Events {

	@SerializedName("events")
	@Expose
	private List<EventsData> events;

	public List<EventsData> getEvents() {
		return events;
	}

	public void setEvents(List<EventsData> events) {
		this.events = events;
	}
}
