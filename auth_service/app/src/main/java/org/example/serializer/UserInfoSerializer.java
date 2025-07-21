package org.example.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.example.eventProducer.UserInfoEvent;

import java.util.Map;

public class UserInfoSerializer implements Serializer<UserInfoEvent> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // Configuration can be done here if needed, currently no specific configuration is required.
    }

    @Override
    public byte[] serialize(String arg0, UserInfoEvent arg1) {

        byte[] returnValue = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            returnValue = objectMapper.writeValueAsString(arg1).getBytes();
        }catch (Exception ex) {
            System.out.println("Exception occurred while serializing UserInfoEvent: " + ex.getMessage());
            ex.printStackTrace();
        }
        return returnValue;
    }

    @Override
    public void close() {
        // Cleanup can be done here if needed, currently no specific cleanup is required.
    }
}
