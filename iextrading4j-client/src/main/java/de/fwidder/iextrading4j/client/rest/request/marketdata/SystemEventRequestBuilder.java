package de.fwidder.iextrading4j.client.rest.request.marketdata;

import de.fwidder.iextrading4j.api.marketdata.SystemEvent;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXApiRestRequest;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class SystemEventRequestBuilder extends AbstractMarketDataRequestBuilder<SystemEvent, SystemEventRequestBuilder>
        implements IEXApiRestRequest<SystemEvent>, IEXCloudV1RestRequest<SystemEvent> {

    @Override
    public RestRequest<SystemEvent> build() {
        return RestRequestBuilder.<SystemEvent>builder()
                .withPath("/deep/system-event").get()
                .withResponse(SystemEvent.class)
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }

}
