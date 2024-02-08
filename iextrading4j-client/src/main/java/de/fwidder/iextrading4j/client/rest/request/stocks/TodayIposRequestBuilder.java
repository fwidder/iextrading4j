package de.fwidder.iextrading4j.client.rest.request.stocks;

import de.fwidder.iextrading4j.api.stocks.TodayIpos;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

/**
 * This endpoint is temporarily unavailable while we identify a new source.
 * https://iexcloud.io/docs/api/#ipos
 */
@Deprecated
public class TodayIposRequestBuilder implements IEXCloudV1RestRequest<TodayIpos> {

    @Override
    public RestRequest<TodayIpos> build() {
        return RestRequestBuilder.<TodayIpos>builder()
                .withPath("/stock/market/today-ipos").get()
                .withResponse(TodayIpos.class)
                .build();
    }

}
