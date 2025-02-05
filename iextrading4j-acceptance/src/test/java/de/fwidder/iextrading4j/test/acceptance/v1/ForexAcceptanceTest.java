package de.fwidder.iextrading4j.test.acceptance.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.forex.CurrencyConversion;
import de.fwidder.iextrading4j.api.forex.CurrencyRate;
import de.fwidder.iextrading4j.api.forex.ExchangeRate;
import de.fwidder.iextrading4j.api.forex.HistoricalCurrencyRate;
import de.fwidder.iextrading4j.api.refdata.v1.Pair;
import de.fwidder.iextrading4j.client.rest.request.forex.CurrencyConversionRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.forex.ExchangeRateRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.forex.HistoricalRatesRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.forex.LatestCurrencyRatesRequestBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled("Sandbox environment is disabled for this subscription tier.")
class ForexAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @BeforeEach
    @Override
    public void setUp() throws InterruptedException {
        super.setUp();
        // Additional delay, otherwise requests are failing with 429 Too Many Requests.
        Thread.sleep(5000);
    }

    @Test
    void forexAcceptanceTest() {
        final ExchangeRate result = cloudClient.executeRequest(new ExchangeRateRequestBuilder()
                .withPair(new Pair("EUR", "CHF"))
                .build());

        assertThat(result).isNotNull();
    }

    @Test
    void currencyConversionTest() {
        final List<CurrencyConversion> result = cloudClient.executeRequest(new CurrencyConversionRequestBuilder()
                .withSymbol("USDGBP")
                .withAmount(BigDecimal.TEN)
                .build());

        assertThat(result).isNotNull();
    }

    @Test
    void latestCurrencyRatesTest() {
        final List<CurrencyRate> result = cloudClient.executeRequest(new LatestCurrencyRatesRequestBuilder()
                .withSymbol("USDGBP")
                .build());

        assertThat(result).isNotNull();
    }

    @Test
    void historicalCurrencyRatesTest() {
        final List<List<HistoricalCurrencyRate>> result = cloudClient.executeRequest(new HistoricalRatesRequestBuilder()
                .withSymbol("USDGBP")
                .withFrom(LocalDate.of(2019, 6, 6))
                .withTo(LocalDate.of(2019, 10, 12))
                .build());

        assertThat(result).isNotNull();
    }

}
