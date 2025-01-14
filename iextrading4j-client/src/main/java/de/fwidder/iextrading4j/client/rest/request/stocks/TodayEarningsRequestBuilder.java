package de.fwidder.iextrading4j.client.rest.request.stocks;

import de.fwidder.iextrading4j.api.stocks.TodayEarnings;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class TodayEarningsRequestBuilder implements IEXCloudV1RestRequest<TodayEarnings> {

    @Override
    public RestRequest<TodayEarnings> build() {
        return RestRequestBuilder.<TodayEarnings>builder()
                .withPath("/stock/market/today-earnings").get()
                .withResponse(TodayEarnings.class)
                .build();
    }

}
