package de.fwidder.iextrading4j.client.rest.request.stocks.v1;

import de.fwidder.iextrading4j.api.stocks.v1.BarData;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.Map;

public class PreviousMarketRequestBuilder implements IEXCloudV1RestRequest<Map<String, BarData>> {

    @Override
    public RestRequest<Map<String, BarData>> build() {
        return RestRequestBuilder.<Map<String, BarData>>builder()
                .withPath("/stock/{symbol}/previous")
                .addPathParam("symbol", "market").get()
                .withResponse(new GenericType<Map<String, BarData>>(){})
                .build();
    }
}
