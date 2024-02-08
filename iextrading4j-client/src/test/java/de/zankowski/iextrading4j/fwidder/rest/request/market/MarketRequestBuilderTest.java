package de.fwidder.iextrading4j.client.rest.request.market;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.market.MarketVolume;
import de.fwidder.iextrading4j.client.rest.manager.MethodType;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MarketRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final RestRequest<List<MarketVolume>> request = new MarketRequestBuilder().build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/market");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<MarketVolume>>() {});
        assertThat(request.getQueryParams()).isEmpty();
    }

}
