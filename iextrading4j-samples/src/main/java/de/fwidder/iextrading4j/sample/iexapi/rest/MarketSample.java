package de.fwidder.iextrading4j.sample.iexapi.rest;

import de.fwidder.iextrading4j.api.market.MarketVolume;
import de.fwidder.iextrading4j.client.IEXApiClient;
import de.fwidder.iextrading4j.client.IEXTradingClient;
import de.fwidder.iextrading4j.client.rest.request.market.MarketRequestBuilder;

import java.util.List;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class MarketSample {

    private final IEXApiClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        final MarketSample sampleSuite = new MarketSample();

        sampleSuite.marketVolumeRequestSample();
    }

    private void marketVolumeRequestSample() {
        final List<MarketVolume> marketVolumeList = iexTradingClient.executeRequest(new MarketRequestBuilder()
                .build());
        System.out.println(marketVolumeList);
    }

}
