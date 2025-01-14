package de.fwidder.iextrading4j.test.rest.stock;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.stocks.Ohlc;
import de.fwidder.iextrading4j.client.rest.request.stocks.OhlcMarketRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.OhlcRequestBuilder;
import de.fwidder.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class OhlcServiceTest extends BaseRestServiceTest {

    @Test
    void ohlcServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/ohlc"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/OhlcResponse.json")));

        final Ohlc ohlc = iexTradingClient.executeRequest(new OhlcRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(ohlc.getSymbol()).isEqualTo("AAPL");
        assertThat(ohlc.getOpen().getPrice()).isEqualByComparingTo(BigDecimal.valueOf(154));
        assertThat(ohlc.getOpen().getTime()).isEqualTo(1506605400394L);
        assertThat(ohlc.getClose().getPrice()).isEqualByComparingTo(BigDecimal.valueOf(153.28));
        assertThat(ohlc.getClose().getTime()).isEqualTo(1506605400394L);
        assertThat(ohlc.getHigh()).isEqualByComparingTo(BigDecimal.valueOf(154.80));
        assertThat(ohlc.getLow()).isEqualByComparingTo(BigDecimal.valueOf(153.25));
        assertThat(ohlc.getVolume()).isEqualTo(BigDecimal.valueOf(26324873));
    }

    @Test
    void ohlcMarketServiceTest() {
        stubFor(get(urlEqualTo("/stock/market/ohlc"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/OhlcMarketResponse.json")));

        final Map<String, Ohlc> ohlcMap = iexTradingClient.executeRequest(new OhlcMarketRequestBuilder()
                .build());

        final Ohlc ohlc = ohlcMap.get("AAPL");
        assertThat(ohlc.getOpen().getPrice()).isEqualByComparingTo(BigDecimal.valueOf(154));
        assertThat(ohlc.getOpen().getTime()).isEqualTo(1506605400394L);
        assertThat(ohlc.getClose().getPrice()).isEqualByComparingTo(BigDecimal.valueOf(153.28));
        assertThat(ohlc.getClose().getTime()).isEqualTo(1506605400394L);
    }
}
