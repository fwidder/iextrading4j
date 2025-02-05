package de.fwidder.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.marketdata.TradingStatusType;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TradingStatusTypeDeserializerTest {

    private TradingStatusTypeDeserializer tradingStatusTypeDeserializer;

    @BeforeEach
    public void setUp() {
        tradingStatusTypeDeserializer = new TradingStatusTypeDeserializer();
    }

    @AfterEach
    public void tearDown() {
        tradingStatusTypeDeserializer = null;
    }

    @Test
    void shouldReturnUnknownTypeIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final TradingStatusType result = tradingStatusTypeDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(TradingStatusType.UNKNOWN);
    }

    @Test
    void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("T");

        final TradingStatusType result = tradingStatusTypeDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(TradingStatusType.TRADING_ON_IEX);
    }
}
