package de.fwidder.iextrading4j.client.rest.request.stocks.v1;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.stocks.v1.RecommendationTrends;
import de.fwidder.iextrading4j.client.rest.manager.MethodType;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class RecommendationTrendsRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final RestRequest<List<RecommendationTrends>> request = new RecommendationTrendsRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/recommendation-trends");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<RecommendationTrends>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

}