package de.fwidder.iextrading4j.client.rest.request.stocks.v1;

import de.fwidder.iextrading4j.api.stocks.v1.KeyStats;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import de.fwidder.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

public class KeyStatsRequestBuilder extends AbstractStocksRequestBuilder<KeyStats, KeyStatsRequestBuilder>
        implements IEXCloudV1RestRequest<KeyStats> {

    @Override
    public RestRequest<KeyStats> build() {
        return RestRequestBuilder.<KeyStats>builder()
                .withPath("/stock/{symbol}/stats")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(KeyStats.class)
                .build();
    }

}
