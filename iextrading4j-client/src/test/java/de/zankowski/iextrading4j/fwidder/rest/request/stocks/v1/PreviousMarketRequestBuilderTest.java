package de.fwidder.iextrading4j.client.rest.request.stocks.v1;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.stocks.v1.BarData;
import de.fwidder.iextrading4j.client.rest.manager.MethodType;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class PreviousMarketRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final RestRequest<Map<String, BarData>> request = new PreviousMarketRequestBuilder()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/previous");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Map<String, BarData>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", "market"));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
