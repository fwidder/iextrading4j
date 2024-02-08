package de.fwidder.iextrading4j.client.rest.request.alternative;

import de.fwidder.iextrading4j.api.stocks.Quote;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import de.fwidder.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import jakarta.ws.rs.core.GenericType;

public class CryptoRequestBuilder extends AbstractStocksRequestBuilder<Quote, CryptoRequestBuilder>
        implements IEXCloudV1RestRequest<Quote> {

    @Override
    public RestRequest<Quote> build() {
        return RestRequestBuilder.<Quote>builder()
                .withPath("/crypto/{symbol}/quote")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(new GenericType<Quote>() {})
                .build();
    }

}