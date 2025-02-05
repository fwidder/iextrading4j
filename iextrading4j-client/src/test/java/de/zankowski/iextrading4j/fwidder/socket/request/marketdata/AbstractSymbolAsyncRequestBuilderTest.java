package de.fwidder.iextrading4j.client.socket.request.marketdata;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.marketdata.LastTrade;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;

import static org.assertj.core.api.Assertions.assertThat;

class AbstractSymbolAsyncRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateAsyncRequestWithMultipleSymbols() {
        final String ibmSymbol = "ibm";
        final String aaplSymbol = "aapl";

        final SocketRequest<LastTrade> request = new LastAsyncRequestBuilder()
                .withSymbols(ibmSymbol, aaplSymbol)
                .build();

        final String param = String.valueOf(request.getParam());
        assertThat(param).containsSequence(ibmSymbol).containsSequence(aaplSymbol);
    }

}
