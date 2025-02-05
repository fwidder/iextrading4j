package de.fwidder.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HackyLocalDateDeserializerTest {

    private HackyLocalDateDeserializer deserializer;

    @BeforeEach
    public void setUp() {
        deserializer = new HackyLocalDateDeserializer();
    }

    @AfterEach
    public void tearDown() {
        deserializer = null;
    }


    @ValueSource(strings = {"0", "0000-00-00"})
    @NullSource
    @ParameterizedTest
    void shouldReturnNullForUnknownValues(final String value) throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(value);

        final LocalDate result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isNull();
    }

    @Test
    void shouldCreateLocalDateBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);
        final String date = "2015-05-05";

        when(parserMock.getText()).thenReturn(date);
        when(parserMock.getValueAsString()).thenReturn(date);
        when(parserMock.hasToken(JsonToken.VALUE_STRING)).thenReturn(true);

        final LocalDate result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(LocalDate.of(2015, 5, 5));
    }

}
