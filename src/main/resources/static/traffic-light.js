var lightsRunning = false;
var stompClient = null;
var trafficLightEventMessage = null;

/**
 * On document ready subscribe to the traffic light endpoint.
 *
 */
$(document).ready(function() {
	var socket = new SockJS('/stomp');
	stompClient = Stomp.over(socket);

	stompClient.connect({}, function(frame) {
		stompClient.subscribe("/traffic-light/switch", function(data) {
			trafficLightEventMessage = JSON.parse(data.body);
			showMessage(trafficLightEventMessage);
			switchLights(trafficLightEventMessage);
		});
	});
});

/**
 * Add the update message to the table.
 *
 * @param {*} update
 */
function showMessage(update) {
	$('#updates').append('<tr>' +
		'<td>' + update.event + '</td>' +
		'<td>' + update.state + '</td>' +
		'<td>' + update.eventTime + '</td>' +
		'</tr>');
}

/**
 * If the update is a light switch we toggle on and off the correct lights.
 *
 * @param {*} update
 */
function switchLights(update) {
	if (update.event === 'SWITCH') {
		switch (update.state) {
		case 'RED':
			toggleLightsOnOff('yellowLight', 'redLight');
			break;
		case 'YELLOW':
			toggleLightsOnOff('greenLight', 'yellowLight');
			break;
		case 'GREEN':
			toggleLightsOnOff('redLight', 'greenLight');
			break;
		}
	}
}

/**
 * Changes the style of the div's that represent the lights so they appear brighter. Pass the id of the 
 * light to turn off and the id of light to turn on.
 *
 * @param {*} turnOff
 * @param {*} turnOn
 */
function toggleLightsOnOff(turnOff, turnOn) {
	var lightToTurnOff = document.getElementById(turnOff);
	lightToTurnOff.classList.remove('lit');
	var lightToTurnOn = document.getElementById(turnOn);
	lightToTurnOn.classList.add('lit');
}

/**
 * A method that is called when the user clicks the button to toggle on/off the traffic light.
 *
 */
function toggleTrafficLights() {
	toggleButtonStyle();

	if (!lightsRunning) {
		stompClient.send("/app/toggle-traffic-light/" + 'START', {}, {});
	} else {
		stompClient.send("/app/toggle-traffic-light/" + 'STOP', {}, {});
	}
	;

	lightsRunning = !lightsRunning;

}

/**
 * Changes the style and inner text of the button when it it's clicked on/off.
 *
 */
function toggleButtonStyle() {
	var button = document.getElementById('button');
	button.classList.toggle('clicked');
	if (!lightsRunning) {
		button.innerText = 'Pause Light Sequence';
	} else {
		button.innerText = 'Restart Light Sequence';
	}
}