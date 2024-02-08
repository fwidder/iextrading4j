package de.fwidder.iextrading4j.client.rest.request.marketdata;

import de.fwidder.iextrading4j.api.marketdata.SsrStatus;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXApiRestRequest;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.Map;

public class SsrStatusRequestBuilder extends AbstractMarketDataRequestBuilder<Map<String, SsrStatus>, SsrStatusRequestBuilder>
        implements IEXApiRestRequest<Map<String, SsrStatus>>, IEXCloudV1RestRequest<Map<String, SsrStatus>> {

    @Override
    public RestRequest<Map<String, SsrStatus>> build() {
        return RestRequestBuilder.<Map<String, SsrStatus>>builder()
                .withPath("/deep/ssr-status").get()
                .withResponse(new GenericType<Map<String, SsrStatus>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }
}
