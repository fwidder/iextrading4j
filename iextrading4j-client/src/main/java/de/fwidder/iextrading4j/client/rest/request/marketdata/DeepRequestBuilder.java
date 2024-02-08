package de.fwidder.iextrading4j.client.rest.request.marketdata;

import de.fwidder.iextrading4j.api.marketdata.DEEP;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXApiRestRequest;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class DeepRequestBuilder extends AbstractMarketDataRequestBuilder<DEEP, DeepRequestBuilder>
        implements IEXApiRestRequest<DEEP>, IEXCloudV1RestRequest<DEEP> {

    @Override
    public RestRequest<DEEP> build() {
        return RestRequestBuilder.<DEEP>builder()
                .withPath("/deep").get()
                .withResponse(DEEP.class)
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }

}
