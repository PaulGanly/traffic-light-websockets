package com.example.traffic.lights.demo.interfaces;

public interface TrafficLightContextInterface {

	/**
	 * Switch the light state (colour)
	 */
	public void change();

	public LightStateInterface getLightState();

	public void setLightState(LightStateInterface lightState);

}