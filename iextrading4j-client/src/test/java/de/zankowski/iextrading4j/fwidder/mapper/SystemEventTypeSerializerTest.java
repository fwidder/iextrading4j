package de.fwidder.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.marketdata.SystemEventType;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SystemEventTypeSerializerTest {

    private SystemEventTypeSerializer systemEventTypeSerializer;

    @BeforeEach
    public void setUp() {
        systemEventTypeSerializer = new SystemEventTypeSerializer();
    }

    @AfterEach
    public void tearDown() {
        systemEventTypeSerializer = null;
    }

    @Test
    void shouldWriteNullIfValueIsNull() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final SystemEventType input = null;

        systemEventTypeSerializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeNull();
    }

    @Test
    void shouldWriteNullIfValueIsUnknown() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final SystemEventType input = SystemEventType.UNKNOWN;

        systemEventTypeSerializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeNull();
    }

    @Test
    void shouldWriteStringFromValue() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final SystemEventType input = SystemEventType.SYSTEM_HOURS_END;

        systemEventTypeSerializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeString("E");
    }

}
