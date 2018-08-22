package com.example.traffic.lights.demo.models;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.traffic.lights.demo.enums.LightStates;
import com.example.traffic.lights.demo.interfaces.TrafficLightContextInterface;

public class GreenLightTest {

	@Test
	public void stateEnumIsCorrect() {
		GreenLight greenLight = new GreenLight();
		assertTrue(LightStates.GREEN.equals(greenLight.getStateName()));
	}

	@Test
	public void changesToCorrectColour() {
		TrafficLightContextInterface context = new TrafficLightContext(new GreenLight());
		assertTrue(LightStates.GREEN.equals(context.getLightState().getStateName()));
		context.change();
		assertTrue(LightStates.YELLOW.equals(context.getLightState().getStateName()));
	}
}
