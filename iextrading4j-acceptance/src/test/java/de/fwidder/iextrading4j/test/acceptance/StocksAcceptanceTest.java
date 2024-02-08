package de.fwidder.iextrading4j.test.acceptance;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.stocks.Book;
import de.fwidder.iextrading4j.api.stocks.EffectiveSpread;
import de.fwidder.iextrading4j.api.stocks.Ohlc;
import de.fwidder.iextrading4j.api.stocks.ShortInterest;
import de.fwidder.iextrading4j.api.stocks.ThresholdSecurities;
import de.fwidder.iextrading4j.api.stocks.TimeSeries;
import de.fwidder.iextrading4j.api.stocks.VenueVolume;
import de.fwidder.iextrading4j.client.rest.request.stocks.BookRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.EffectiveSpreadRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.OhlcMarketRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.OhlcRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.ShortInterestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.ThresholdSecuritiesRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.TimeSeriesRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.stocks.VenueVolumeRequestBuilder;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
@Disabled("403 Forbidden")
class StocksAcceptanceTest extends AcceptanceTestBase {

    @Test
    void bookRequestAcceptanceTest() {
        final Book book = iexTradingClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(book).isNotNull();
    }

    @Test
    void effectiveSpreadAcceptanceTest() {
        final List<EffectiveSpread> effectiveSpreads = iexTradingClient.executeRequest(new EffectiveSpreadRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(effectiveSpreads).isNotNull();
    }

    @Test
    void venueVolumeAcceptanceTest() {
        final List<VenueVolume> venueVolumeList = iexTradingClient.executeRequest(new VenueVolumeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(venueVolumeList).isNotNull();
    }

    @Test
    void ohlcAcceptanceTest() {
        final Ohlc ohlc = iexTradingClient.executeRequest(new OhlcRequestBuilder()
                .withSymbol("aapl")
                .build());
        assertThat(ohlc).isNotNull();
    }

    @Test
    void shortInterestAcceptanceTest() {
        final List<ShortInterest> shortInterestList = iexTradingClient.executeRequest(new ShortInterestRequestBuilder()
                .withSample()
                .withMarket()
                .build());
        assertThat(shortInterestList).isNotNull();
    }

    @Test
    void timeSeriesAcceptanceTest() {
        final List<TimeSeries> timeSeriesList = iexTradingClient.executeRequest(new TimeSeriesRequestBuilder()
                .withSymbol("aapl")
                .build());
        assertThat(timeSeriesList).isNotNull();
    }

    @Test
    void thresholdSecuritiesAcceptanceTest() {
        final List<ThresholdSecurities> thresholdSecuritiesList = iexTradingClient.executeRequest(new ThresholdSecuritiesRequestBuilder()
                .withSample()
                .withMarket()
                .build());
        assertThat(thresholdSecuritiesList).isNotNull();
    }

    @Test
    void ohlcMarketAcceptanceTest() {
        final Map<String, Ohlc> ohlcMap = iexTradingClient.executeRequest(new OhlcMarketRequestBuilder()
                .build());
        assertThat(ohlcMap).isNotNull();
    }

}
