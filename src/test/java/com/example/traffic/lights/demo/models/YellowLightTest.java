package com.example.traffic.lights.demo.models;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.traffic.lights.demo.enums.LightStates;
import com.example.traffic.lights.demo.interfaces.TrafficLightContextInterface;

public class YellowLightTest {

	@Test
	public void stateEnumIsCorrect() {
		YellowLight yellowLight = new YellowLight();
		assertTrue(LightStates.YELLOW.equals(yellowLight.getStateName()));
	}
	
	@Test
	public void changesToCorrectColour() {
		TrafficLightContextInterface context = new TrafficLightContext(new YellowLight());
		assertTrue(LightStates.YELLOW.equals(context.getLightState().getStateName()));
		context.change();
		assertTrue(LightStates.RED.equals(context.getLightState().getStateName()));
	}

}
