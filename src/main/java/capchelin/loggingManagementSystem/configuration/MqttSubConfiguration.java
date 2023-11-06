package capchelin.loggingManagementSystem.configuration;

import capchelin.loggingManagementSystem.documents.SearchData;
import capchelin.loggingManagementSystem.service.DataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.io.IOException;
import java.util.UUID;

//@Builder
//@AllArgsConstructor
@Configuration
public class MqttSubConfiguration {

    @Value("${mqtt.url}")
    private String BROKER_URL;

    @Value("${mqtt.user}")
    private String mqttUsername;

    @Value("${mqtt.password}")
    private String mqttPassword;


    @Value("${mqtt.qos}")
    private int QOS;

    @Value("${mqtt.topic}")
    private String TOPIC_FILTER;

    @Autowired
    private DataService dataService;

  

    final private String MQTT_CLIENT_ID = UUID.randomUUID().toString();

    @Bean
    public MqttConnectOptions connectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setUserName(mqttUsername);
        options.setPassword(mqttPassword.toCharArray());
        return options;
    }
    @Bean
    public DefaultMqttPahoClientFactory defaultMqttPahoClientFactory() {
        DefaultMqttPahoClientFactory clientFactory = new DefaultMqttPahoClientFactory();
        clientFactory.setConnectionOptions(connectOptions());
        return clientFactory;
    }

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }


    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MqttPahoMessageDrivenChannelAdapter inboundChannel() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(BROKER_URL,MQTT_CLIENT_ID, TOPIC_FILTER);
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(QOS);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler inboundMessageHandler() {
        return message -> {
//            String topic = (String) message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC);

            try {
                String jsonPayload = (String) message.getPayload();
                ObjectMapper objectMapper = new ObjectMapper();
                SearchData searchData = objectMapper.readValue(jsonPayload, SearchData.class);
                dataService.create(searchData);
                System.out.println("SearchData successfully processed and saved to Elasticsearch.");
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }


        };
    }


}
