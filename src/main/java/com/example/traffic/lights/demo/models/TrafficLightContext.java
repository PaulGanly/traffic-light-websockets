package com.example.traffic.lights.demo.models;

import com.example.traffic.lights.demo.interfaces.LightStateInterface;
import com.example.traffic.lights.demo.interfaces.TrafficLightContextInterface;

public class TrafficLightContext implements TrafficLightContextInterface {
	private LightStateInterface lightState;

	/**
	 * Construct a new traffic light context
	 * @param lightState
	 */
	public TrafficLightContext(LightStateInterface lightState) {
		this.lightState = lightState;
	}

	@Override
	public void change() {
		lightState.changeLight(this);
	}

	@Override
	public LightStateInterface getLightState() {
		return lightState;
	}

	@Override
	public void setLightState(LightStateInterface lightState) {
		this.lightState = lightState;
	}

}
