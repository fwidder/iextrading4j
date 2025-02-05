package de.fwidder.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeepChannelDeserializerTest {

    private DeepChannelDeserializer deserializer;

    @BeforeEach
    public void setUp() {
        deserializer = new DeepChannelDeserializer();
    }

    @AfterEach
    public void tearDown() {
        deserializer = null;
    }

    @Test
    void shouldReturnUnknownTypeIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final DeepChannel result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(DeepChannel.UNKNOWN);
    }

    @Test
    void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("ophaltstatus");

        final DeepChannel result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(DeepChannel.OP_HALT_STATUS);
    }

}
