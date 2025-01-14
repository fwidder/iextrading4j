package de.fwidder.iextrading4j.test.rest.stock;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.client.rest.request.stocks.PriceRequestBuilder;
import de.fwidder.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class PriceServiceTest extends BaseRestServiceTest {

    @Test
    void priceServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/price"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/PriceResponse.json")));

        final BigDecimal price = iexTradingClient.executeRequest(new PriceRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(price).isEqualTo(BigDecimal.valueOf(170.4));
    }

}
