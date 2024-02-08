package de.fwidder.iextrading4j.client.rest.request.stocks;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.stocks.TodayIpos;
import de.fwidder.iextrading4j.client.rest.manager.MethodType;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;

class TodayIposRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final RestRequest<TodayIpos> request = new TodayIposRequestBuilder()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/market/today-ipos");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<TodayIpos>() {});
        assertThat(request.getQueryParams()).isEmpty();
    }

}
