package de.fwidder.iextrading4j.client.rest.request.stocks.v1;

import de.fwidder.iextrading4j.api.stocks.v1.PriceTarget;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import de.fwidder.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

public class PriceTargetRequestBuilder extends AbstractStocksRequestBuilder<PriceTarget, PriceTargetRequestBuilder>
        implements IEXCloudV1RestRequest<PriceTarget> {

    @Override
    public RestRequest<PriceTarget> build() {
        return RestRequestBuilder.<PriceTarget>builder()
                .withPath("/stock/{symbol}/price-target")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(PriceTarget.class)
                .build();
    }

}
