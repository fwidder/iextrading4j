package de.fwidder.iextrading4j.client.rest.request.stocks;

import de.fwidder.iextrading4j.api.stocks.Ohlc;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXApiRestRequest;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class OhlcRequestBuilder extends AbstractStocksRequestBuilder<Ohlc, OhlcRequestBuilder>
        implements IEXApiRestRequest<Ohlc>, IEXCloudV1RestRequest<Ohlc> {

    @Override
    public RestRequest<Ohlc> build() {
        return RestRequestBuilder.<Ohlc>builder()
                .withPath("/stock/{symbol}/ohlc")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Ohlc.class)
                .build();
    }
}
