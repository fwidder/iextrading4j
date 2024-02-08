package de.fwidder.iextrading4j.client.rest.request.marketdata;

import de.fwidder.iextrading4j.api.marketdata.OpHaltStatus;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXApiRestRequest;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.Map;

public class OpHaltStatusRequestBuilder extends AbstractMarketDataRequestBuilder<Map<String, OpHaltStatus>, OpHaltStatusRequestBuilder>
        implements IEXApiRestRequest<Map<String, OpHaltStatus>>, IEXCloudV1RestRequest<Map<String, OpHaltStatus>> {

    @Override
    public RestRequest<Map<String, OpHaltStatus>> build() {
        return RestRequestBuilder.<Map<String, OpHaltStatus>>builder()
                .withPath("/deep/op-halt-status").get()
                .withResponse(new GenericType<Map<String, OpHaltStatus>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }

}
