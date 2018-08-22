package com.example.traffic.lights.demo.models;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.traffic.lights.demo.enums.LightStates;

public class TrafficLightContextTest {
	
	@Test
	public void changeStateWorks() {
		TrafficLightContext context = new TrafficLightContext(new RedLight());
		assertTrue(LightStates.RED.equals(context.getLightState().getStateName()));
		context.change();
		assertTrue(LightStates.GREEN.equals(context.getLightState().getStateName()));
		context.change();
		assertTrue(LightStates.YELLOW.equals(context.getLightState().getStateName()));
	}

}
