package com.example.traffic.lights.demo.models;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.traffic.lights.demo.enums.LightStates;
import com.example.traffic.lights.demo.interfaces.TrafficLightContextInterface;

public class RedLightTest {
	
	@Test
	public void stateEnumIsCorrect() {
		RedLight redLight = new RedLight();
		assertTrue(LightStates.RED.equals(redLight.getStateName()));
	}
	
	@Test
	public void changesToCorrectColour() {
		TrafficLightContextInterface context = new TrafficLightContext(new RedLight());
		assertTrue(LightStates.RED.equals(context.getLightState().getStateName()));
		context.change();
		assertTrue(LightStates.GREEN.equals(context.getLightState().getStateName()));
	}

}
