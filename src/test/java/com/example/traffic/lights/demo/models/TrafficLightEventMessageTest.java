package com.example.traffic.lights.demo.models;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TrafficLightEventMessageTest {

	@Test
	public void shouldHaveANoArgsConstructor() {
		assertThat(TrafficLightEventMessage.class, hasValidBeanConstructor());
	}

	@Test
	public void gettersAndSettersShouldWorkForEachProperty() {
		assertThat(TrafficLightEventMessage.class, hasValidGettersAndSetters());
	}

	@Test
	public void allPropertiesShouldBeRepresentedInToStringOutput() {
		assertThat(TrafficLightEventMessage.class, hasValidBeanToString());
	}
}
