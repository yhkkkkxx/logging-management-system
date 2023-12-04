package capchelin.loggingManagementSystem.documents;

import static org.junit.Assert.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//@SpringBootTest
public class SearchDataTest {

    @Test
    public void dataBidingTest() throws JsonProcessingException {
        String testData = "{\n" +
                "    \"applicationID\": \"18\",\n" +
                "    \"applicationName\": \"GyeRyong\",\n" +
                "    \"deviceName\": \"WID_test\",\n" +
                "    \"devEUI\": \"70b3d5003331006d\",\n" +
                "    \"rxInfo\": [\n" +
                "        {\n" +
                "            \"gatewayID\": \"60c5a8fffe76134b\",\n" +
                "            \"uplinkID\": \"2a5b9d79-f694-4027-b58c-1fc1f1fc4a9e\",\n" +
                "            \"name\": \"wid-gate\",\n" +
                "            \"rssi\": -125,\n" +
                "            \"loRaSNR\": -12.8,\n" +
                "            \"location\": {\n" +
                "                \"latitude\": 0,\n" +
                "                \"longitude\": 0,\n" +
                "                \"altitude\": 0\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"gatewayID\": \"60c5a8fffe76134b\",\n" +
                "            \"uplinkID\": \"09c869e3-8fc2-4569-b485-6427e1cebc39\",\n" +
                "            \"name\": \"wid-gate\",\n" +
                "            \"rssi\": -25,\n" +
                "            \"loRaSNR\": 8.3,\n" +
                "            \"location\": {\n" +
                "                \"latitude\": 0,\n" +
                "                \"longitude\": 0,\n" +
                "                \"altitude\": 0\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"gatewayID\": \"60c5a8fffe76134b\",\n" +
                "            \"uplinkID\": \"e00880ab-d5d1-4219-b30a-43d3b6ccec8b\",\n" +
                "            \"name\": \"wid-gate\",\n" +
                "            \"rssi\": -120,\n" +
                "            \"loRaSNR\": -10.3,\n" +
                "            \"location\": {\n" +
                "                \"latitude\": 0,\n" +
                "                \"longitude\": 0,\n" +
                "                \"altitude\": 0\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"txInfo\": {\n" +
                "        \"frequency\": 923100000,\n" +
                "        \"dr\": 1\n" +
                "    },\n" +
                "    \"adr\": false,\n" +
                "    \"fCnt\": 31,\n" +
                "    \"fPort\": 77,\n" +
                "    \"data\": \"IA==\"\n" +
                "}";



        ObjectMapper objectMapper = new ObjectMapper();
        SearchData searchData = objectMapper.readValue(testData, SearchData.class);
        assertNotNull(searchData.getApplicationID());
        assertEquals("18", searchData.getApplicationID());
        assertEquals("GyeRyong", searchData.getApplicationName());
        assertEquals("WID_test", searchData.getDeviceName());
        assertEquals("70b3d5003331006", searchData.getDevEUI());
        assertFalse(searchData.isAdr());
        assertEquals(31, searchData.getFCnt());
        assertEquals(77, searchData.getFPort());
        assertEquals("IA==", searchData.getData());

         }

}

