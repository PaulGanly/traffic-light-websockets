package com.example.traffic.lights.demo.models;

import com.example.traffic.lights.demo.enums.LightStates;
import com.example.traffic.lights.demo.interfaces.LightStateInterface;
import com.example.traffic.lights.demo.interfaces.TrafficLightContextInterface;

public class YellowLight implements LightStateInterface {

	@Override
	public void changeLight(TrafficLightContextInterface context) {
		context.setLightState(new RedLight());
	}

	@Override
	public LightStates getStateName() {
		return LightStates.YELLOW;
	}

}
