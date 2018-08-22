package com.example.traffic.lights.demo.interfaces;

import com.example.traffic.lights.demo.enums.LightStates;

public interface LightStateInterface {
	
	public LightStates getStateName();
	
	public void changeLight(TrafficLightContextInterface context);
}
