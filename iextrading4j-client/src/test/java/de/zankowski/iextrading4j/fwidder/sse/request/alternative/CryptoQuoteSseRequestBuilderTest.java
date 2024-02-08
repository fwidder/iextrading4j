package de.fwidder.iextrading4j.client.sse.request.alternative;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.stocks.Quote;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class CryptoQuoteSseRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final SseRequest<List<Quote>> request = new CryptoQuoteSseRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/cryptoQuotes");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Quote>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("nosnapshot", "false"), entry("symbols", symbol));
    }

}
