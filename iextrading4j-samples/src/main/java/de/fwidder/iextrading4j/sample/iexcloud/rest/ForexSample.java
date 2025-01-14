package de.fwidder.iextrading4j.sample.iexcloud.rest;

import de.fwidder.iextrading4j.api.forex.CurrencyConversion;
import de.fwidder.iextrading4j.api.forex.CurrencyRate;
import de.fwidder.iextrading4j.api.forex.ExchangeRate;
import de.fwidder.iextrading4j.api.forex.HistoricalCurrencyRate;
import de.fwidder.iextrading4j.api.refdata.v1.Pair;
import de.fwidder.iextrading4j.client.IEXCloudClient;
import de.fwidder.iextrading4j.client.IEXCloudTokenBuilder;
import de.fwidder.iextrading4j.client.IEXTradingApiVersion;
import de.fwidder.iextrading4j.client.IEXTradingClient;
import de.fwidder.iextrading4j.client.rest.request.forex.CurrencyConversionRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.forex.ExchangeRateRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.forex.HistoricalRatesRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.forex.LatestCurrencyRatesRequestBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ForexSample {

    final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) {
        final ForexSample forexSample = new ForexSample();

        // This data is not available to free tier accounts
        forexSample.exchangeRateRequestSample();
        forexSample.currencyConversionSample();
        forexSample.latestCurrencyRatesSample();
        forexSample.historicalCurrencyRatesSample();
    }

    private void exchangeRateRequestSample() {
        final ExchangeRate exchangeRate = cloudClient.executeRequest(new ExchangeRateRequestBuilder()
                .withPair(new Pair("EUR", "CHF"))
                .build());
        System.out.println(exchangeRate);
    }

    private void currencyConversionSample() {
        final List<CurrencyConversion> result = cloudClient.executeRequest(new CurrencyConversionRequestBuilder()
                .withSymbol("USDGBP")
                .withAmount(BigDecimal.TEN)
                .build());
        System.out.println(result);
    }

    private void latestCurrencyRatesSample() {
        final List<CurrencyRate> result = cloudClient.executeRequest(new LatestCurrencyRatesRequestBuilder()
                .withSymbol("USDGBP")
                .build());
        System.out.println(result);
    }

    private void historicalCurrencyRatesSample() {
        final List<List<HistoricalCurrencyRate>> result = cloudClient.executeRequest(new HistoricalRatesRequestBuilder()
                .withSymbol("USDGBP")
                .withFrom(LocalDate.of(2019, 6, 6))
                .withTo(LocalDate.of(2019, 10, 12))
                .build());
        System.out.println(result);
    }

}
