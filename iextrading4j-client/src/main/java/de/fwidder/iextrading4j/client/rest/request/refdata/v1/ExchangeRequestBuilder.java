package de.fwidder.iextrading4j.client.rest.request.refdata.v1;

import de.fwidder.iextrading4j.api.refdata.v1.Exchange;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class ExchangeRequestBuilder extends AbstractRequestFilterBuilder<List<Exchange>, ExchangeRequestBuilder>
        implements IEXCloudV1RestRequest<List<Exchange>> {

    @Override
    public RestRequest<List<Exchange>> build() {
        return RestRequestBuilder.<List<Exchange>>builder()
                .withPath("/ref-data/exchanges").get()
                .withResponse(new GenericType<List<Exchange>>() {})
                .addQueryParam(getFilterParams())
                .build();
    }

}
