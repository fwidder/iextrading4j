package de.fwidder.iextrading4j.client.rest.request.refdata.v1;

import de.fwidder.iextrading4j.api.refdata.v1.UsExchange;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class UsExchangeRequestBuilder extends AbstractRequestFilterBuilder<List<UsExchange>, UsExchangeRequestBuilder>
        implements IEXCloudV1RestRequest<List<UsExchange>> {

    @Override
    public RestRequest<List<UsExchange>> build() {
        return RestRequestBuilder.<List<UsExchange>>builder()
                .withPath("/ref-data/market/us/exchanges").get()
                .withResponse(new GenericType<List<UsExchange>>() {
                })
                .addQueryParam(getFilterParams())
                .build();
    }

}
