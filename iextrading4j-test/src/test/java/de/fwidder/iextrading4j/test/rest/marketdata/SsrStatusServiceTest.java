package de.fwidder.iextrading4j.test.rest.marketdata;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.marketdata.SsrStatus;
import de.fwidder.iextrading4j.client.rest.request.marketdata.SsrStatusRequestBuilder;
import de.fwidder.iextrading4j.test.rest.BaseRestServiceTest;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class SsrStatusServiceTest extends BaseRestServiceTest {

    @Test
    void ssrStatusServiceTest() {
        stubFor(get(urlEqualTo("/deep/ssr-status?symbols=AAPL"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/marketdata/SsrStatusResponse.json")));

        final Map<String, SsrStatus> ssrStatusMap = iexTradingClient.executeRequest(new SsrStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());

        final SsrStatus ssrStatus = ssrStatusMap.get("AAPL");
        assertThat(ssrStatus.getDetail()).isEqualTo(" ");
        assertThat(ssrStatus.isSSR()).isFalse();
        assertThat(ssrStatus.getTimestamp()).isEqualTo(1510939321327L);
    }

}
