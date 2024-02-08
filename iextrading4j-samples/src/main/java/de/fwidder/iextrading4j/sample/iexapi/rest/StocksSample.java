package de.fwidder.iextrading4j.sample.iexapi.rest;

import de.fwidder.iextrading4j.api.stocks.Book;
import de.fwidder.iextrading4j.api.stocks.EffectiveSpread;
import de.fwidder.iextrading4j.api.stocks.ShortInterest;
import de.fwidder.iextrading4j.api.stocks.ThresholdSecurities;
import de.fwidder.iextrading4j.api.stocks.TimeSeries;
import de.fwidder.iextrading4j.api.stocks.VenueVolume;
import de.fwidder.iextrading4j.client.IEXApiClient;
import de.fwidder.iextrading4j.client.IEXTradingClient;
import de.fwidder.iextrading4j.client.rest.request.stocks.BookRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.EffectiveSpreadRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.ShortInterestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.ThresholdSecuritiesRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.TimeSeriesRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.VenueVolumeRequestBuilder;

import java.util.List;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class StocksSample {

    private final IEXApiClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        final StocksSample sampleSuite = new StocksSample();

        sampleSuite.bookRequestSample();
        sampleSuite.effectiveSpreadRequestSample();
        sampleSuite.venueVolumeRequestSample();
        sampleSuite.shortInterestRequestSample();
        sampleSuite.timeSeriesRequestSample();
        sampleSuite.thresholdSecuritiesRequestSample();
    }

    private void bookRequestSample() {
        final Book book = iexTradingClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(book);
    }

    private void effectiveSpreadRequestSample() {
        final List<EffectiveSpread> effectiveSpreads = iexTradingClient.executeRequest(new EffectiveSpreadRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(effectiveSpreads);
    }

    private void venueVolumeRequestSample() {
        final List<VenueVolume> venueVolumeList = iexTradingClient.executeRequest(new VenueVolumeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(venueVolumeList);
    }

    private void shortInterestRequestSample() {
        final List<ShortInterest> shortInterestList = iexTradingClient.executeRequest(new ShortInterestRequestBuilder()
                .withSample()
                .withMarket()
                .build());
        System.out.println(shortInterestList);
    }

    private void timeSeriesRequestSample() {
        final List<TimeSeries> timeSeriesList = iexTradingClient.executeRequest(new TimeSeriesRequestBuilder()
                .withSymbol("aapl")
                .build());
        System.out.println(timeSeriesList);
    }

    private void thresholdSecuritiesRequestSample() {
        final List<ThresholdSecurities> thresholdSecuritiesList = iexTradingClient.executeRequest(new ThresholdSecuritiesRequestBuilder()
                .withSample()
                .withMarket()
                .build());
        System.out.println(thresholdSecuritiesList);
    }

}
