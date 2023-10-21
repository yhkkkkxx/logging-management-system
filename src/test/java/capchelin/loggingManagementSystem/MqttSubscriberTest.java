package capchelin.loggingManagementSystem;

import capchelin.loggingManagementSystem.config.Sub.MqttSubscriber;
import org.eclipse.paho.client.mqttv3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MqttSubscriberTest {

    @Autowired
    private MqttSubscriber mqttSubscriber;
    @Autowired
    private MessageChannel mqttInputChannel;

    @Autowired
    MqttPahoClientFactory mqttPahoClientFactory;

//    @Autowired
//    private IMqttClient mqttClient;

    @Value("${mqtt.url}")
    private String BROKER_URL;

    @Value("${mqtt.user:}")
    private String mqttUsername;

    @Value("${mqtt.password:}")
    private String mqttPassword;

    @Value("${mqtt.qos}")
    private int QOS;

    @Value("${mqtt.topic}")
    private String TOPIC_FILTER;

    private String receivedMessage;
    @BeforeEach
    public void setup() throws MqttException {
        // Set up a test MQTT client and connect it to the broker
        MqttClient mqttClient = new MqttClient(BROKER_URL, "TestClient");
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setUserName(mqttUsername);
        options.setPassword(mqttPassword.toCharArray());
        mqttClient.connect(options);


        mqttClient.subscribe(TOPIC_FILTER, QOS);

    }

    @Test
    public void testMqttSubscriber() {
        // Create a test message
        String testPayload = " capchelin";
        MessageChannel mqttInputChannel = mqttSubscriber.mqttInputChannel();
        Message<String> testMessage = MessageBuilder.withPayload(testPayload).build();


        mqttInputChannel.send(testMessage);


    }

    @ServiceActivator(inputChannel = "mqttInputChannel")
    public void handleMqttMessage(Message<String> message) {
        receivedMessage = message.getPayload();
    }
}

