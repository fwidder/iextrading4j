package de.fwidder.iextrading4j.test.rest.marketdata;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.marketdata.OfficialPrice;
import de.fwidder.iextrading4j.api.marketdata.PriceType;
import de.fwidder.iextrading4j.client.rest.request.marketdata.OfficialPriceRequestBuilder;
import de.fwidder.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class OfficialPriceServiceTest  extends BaseRestServiceTest {

    @Test
    void officialPriceServiceTest() {
        stubFor(get(urlEqualTo("/deep/official-price?symbols=SNAP"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/marketdata/OfficialPriceResponse.json")));

        final Map<String, OfficialPrice> opHaltStatusMap = iexTradingClient.executeRequest(new OfficialPriceRequestBuilder()
                .withSymbol("SNAP")
                .build());

        final OfficialPrice officialPrice = opHaltStatusMap.get("SNAP");
        assertThat(officialPrice.getPriceType()).isEqualTo(PriceType.Open);
        assertThat(officialPrice.getPrice()).isEqualTo(BigDecimal.valueOf(1.05));
        assertThat(officialPrice.getTimestamp()).isEqualTo(1494595800005L);
    }
}
