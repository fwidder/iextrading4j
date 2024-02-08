package de.fwidder.iextrading4j.client.sse.request.marketdata;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.marketdata.Trade;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;

import jakarta.ws.rs.core.GenericType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class TradeBreaksSseRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final SseRequest<List<DeepAsyncResponse<Trade>>> request = new TradeBreaksSseRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/deep");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<DeepAsyncResponse<Trade>>>() {
        });
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("nosnapshot", "false"), entry("symbols", symbol),
                entry("channels", "trade-breaks"));
    }

}
