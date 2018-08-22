package com.example.traffic.lights.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import com.example.traffic.lights.demo.enums.LightEvents;
import com.example.traffic.lights.demo.interfaces.TrafficLightContextInterface;
import com.example.traffic.lights.demo.models.RedLight;
import com.example.traffic.lights.demo.models.TrafficLightContext;
import com.example.traffic.lights.demo.models.TrafficLightEventMessage;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

@Service
public class TrafficLightSchedulerService {
	
	private final static Logger logger = LoggerFactory.getLogger(TrafficLightSchedulerService.class);

	public static final long TRAFFIC_LIGHT_RATE = 2000;

	@Autowired
	private SimpMessagingTemplate template;

	@Autowired
	TaskScheduler taskScheduler;

	public TrafficLightContextInterface trafficLightContext;

	private ScheduledFuture<?> scheduledFuture;

	/**
	 * Method called to start the scheduled task i.e. the traffic light switching. The task run until it is stopped
	 * sendTrafficLightSwitch will be called each time the TRAFFIC_LIGHT_RATE time in milliseconds passes.
	 *
	 */
	public void startTrafficLights() {
		this.trafficLightContext = new TrafficLightContext(new RedLight());
		scheduledFuture = taskScheduler.scheduleAtFixedRate(sendTrafficLightSwitch(), TRAFFIC_LIGHT_RATE);
	}

	/**
	 * Method called to stop the scheduled task i.e. the traffic light switching
	 */
	public void stopTrafficLights() {
		scheduledFuture.cancel(false);
	}

	/**
	 * A runnable method that changes the light state (colour) and then pushes a new TrafficLightEventMessage out to the subscribers 
	 * @return
	 */
	private Runnable sendTrafficLightSwitch() {
		return () -> {
			this.trafficLightContext.change();
			logger.debug("Switching the traffic lights to : " + this.trafficLightContext.getLightState().getStateName()
					+ " at " + new Date().toString());
			this.template.convertAndSend("/traffic-light/switch", new TrafficLightEventMessage(LightEvents.SWITCH,
					this.trafficLightContext.getLightState().getStateName(), new Date().toString()));
		};
	}

}
