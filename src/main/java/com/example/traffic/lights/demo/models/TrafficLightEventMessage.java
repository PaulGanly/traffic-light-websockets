package com.example.traffic.lights.demo.models;

import com.example.traffic.lights.demo.enums.LightEvents;
import com.example.traffic.lights.demo.enums.LightStates;

public class TrafficLightEventMessage {

	private LightEvents event;
	private LightStates state;
	private String eventTime;

	public TrafficLightEventMessage() {
		super();
	}

	public TrafficLightEventMessage(LightEvents event, LightStates state, String eventTime) {
		super();
		this.event = event;
		this.state = state;
		this.eventTime = eventTime;
	}

	public LightEvents getEvent() {
		return event;
	}

	public void setEvent(LightEvents event) {
		this.event = event;
	}

	public LightStates getState() {
		return state;
	}

	public void setState(LightStates state) {
		this.state = state;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	@Override
	public String toString() {
		return "TrafficLightEventMessage [event=" + event + ", state=" + state + ", eventTime=" + eventTime + "]";
	}
}
