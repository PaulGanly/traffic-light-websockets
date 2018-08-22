package com.example.traffic.lights.demo.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.traffic.lights.demo.enums.LightEvents;
import com.example.traffic.lights.demo.models.TrafficLightEventMessage;
import com.example.traffic.lights.demo.services.TrafficLightSchedulerService;

@Controller
public class ToggleTrafficLightsController {

	private final static Logger logger = LoggerFactory.getLogger(ToggleTrafficLightsController.class);

	@Autowired
	private TrafficLightSchedulerService trafficLights;

	/**
	 * The endpoint for starting and stopping the traffic lights. When we receive a 'START' event we start the
	 * task scheduler, otherwise we stop it.
	 * 
	 * @param lightEvent
	 * @return
	 * @throws Exception
	 */
	@MessageMapping("/toggle-traffic-light/{lightEvent}")
	@SendTo("/traffic-light/switch")
	public TrafficLightEventMessage send(@DestinationVariable("lightEvent") String lightEvent) throws Exception {
		logger.debug("Recieved request to " + lightEvent + " the traffic lights");
		if (LightEvents.START.name().equals(lightEvent)) {
			logger.debug("Starting the traffic lights at : " + new Date().toString());
			trafficLights.startTrafficLights();
			return new TrafficLightEventMessage(LightEvents.START, null, new Date().toString());
		} else {
			logger.debug("Stopping the traffic lights at : " + new Date().toString());
			trafficLights.stopTrafficLights();
			return new TrafficLightEventMessage(LightEvents.STOP, null, new Date().toString());
		}
	}
}
