package com.example.traffic.lights.demo.controllers;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.traffic.lights.demo.enums.LightEvents;
import com.example.traffic.lights.demo.models.TrafficLightEventMessage;
import com.example.traffic.lights.demo.services.TrafficLightSchedulerService;

@RunWith(MockitoJUnitRunner.class)
public class ToggleTrafficLightsControllerTest {

	@InjectMocks
    private ToggleTrafficLightsController controller;

    @Mock
    private TrafficLightSchedulerService trafficLights;

	@Test
	public void sendStart() throws Exception {
		TrafficLightEventMessage returnedMessage = controller.send("START");
		verify(trafficLights).startTrafficLights();
		assertTrue(LightEvents.START.equals(returnedMessage.getEvent()));
	}

	@Test
	public void sendStop() throws Exception {
		TrafficLightEventMessage returnedMessage = controller.send("STOP");
		verify(trafficLights).stopTrafficLights();
		assertTrue(LightEvents.STOP.equals(returnedMessage.getEvent()));
	}

	@Test
	public void sendNull() throws Exception {
		TrafficLightEventMessage returnedMessage = controller.send(null);
		verify(trafficLights).stopTrafficLights();
		assertTrue(LightEvents.STOP.equals(returnedMessage.getEvent()));
	}

}
