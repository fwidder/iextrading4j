package de.fwidder.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.refdata.SymbolType;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SymbolTypeDeserializerTest {

    private SymbolTypeDeserializer deserializer;

    @BeforeEach
    public void setUp() {
        deserializer = new SymbolTypeDeserializer();
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

        final SymbolType result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(SymbolType.UNKNOWN);
    }

    @Test
    void shouldCreateNotAvailableBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("N/A");

        final SymbolType result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(SymbolType.NOT_AVAILABLE);
    }

    @Test
    void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("cs");

        final SymbolType result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(SymbolType.COMMON_STOCK);
    }

}
