package de.fwidder.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.stocks.DividendQualification;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DividendQualificationDeserializerTest {

    private DividendQualificationDeserializer dividendQualificationDeserializer;

    @BeforeEach
    public void setUp() {
        dividendQualificationDeserializer = new DividendQualificationDeserializer();
    }

    @AfterEach
    public void tearDown() {
        dividendQualificationDeserializer = null;
    }

    @Test
    void shouldReturnUnknownTypeIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final DividendQualification result = dividendQualificationDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(DividendQualification.UNKNOWN);
    }

    @Test
    void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("N");

        final DividendQualification result = dividendQualificationDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(DividendQualification.UNQUALIFIED_INCOME);
    }
}
