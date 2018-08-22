package com.example.traffic.lights.demo.models;

import com.example.traffic.lights.demo.enums.LightStates;
import com.example.traffic.lights.demo.interfaces.LightStateInterface;
import com.example.traffic.lights.demo.interfaces.TrafficLightContextInterface;

public class GreenLight implements LightStateInterface {

	@Override
	public void changeLight(TrafficLightContextInterface context) {
		context.setLightState(new YellowLight());
	}

	@Override
	public LightStates getStateName() {
		return LightStates.GREEN;
	}

}
