package cn.fireworkstudio.admin.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Json object mapper
 */
@Component
public class JacksonObjectMapper extends ObjectMapper {

    public JacksonObjectMapper() {
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {

            @Override
            public void serializeWithType(Object value, JsonGenerator gen, SerializerProvider serializers,
                                          TypeSerializer typeSer) throws IOException {
                if (value instanceof Collection)
                    gen.writeObject(new ArrayList());
                else if (value instanceof Map)
                    gen.writeObject(new HashMap());
                else
                    gen.writeObject(null);
            }

            @Override
            public void serialize(Object value, JsonGenerator jgen, SerializerProvider sp) throws IOException {
                if (value instanceof Collection)
                    jgen.writeObject(new ArrayList());
                else if (value instanceof Map)
                    jgen.writeObject(new HashMap());
                else
                    jgen.writeObject(null);
            }
        });
    }
}
