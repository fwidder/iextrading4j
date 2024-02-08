package de.fwidder.iextrading4j.client.rest.request.alternative;

import de.fwidder.iextrading4j.api.alternative.CeoCompensation;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import de.fwidder.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

public class CeoCompensationRequestBuilder extends AbstractStocksRequestBuilder<CeoCompensation,
        CeoCompensationRequestBuilder> implements IEXCloudV1RestRequest<CeoCompensation> {

    @Override
    public RestRequest<CeoCompensation> build() {
        return RestRequestBuilder.<CeoCompensation>builder()
                .withPath("/stock/{symbol}/ceo-compensation")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(CeoCompensation.class)
                .build();
    }

}
