package de.fwidder.iextrading4j.client.rest.request.stocks;

import de.fwidder.iextrading4j.api.stocks.Ipos;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

/**
 * This endpoint is temporarily unavailable while we identify a new source.
 * https://iexcloud.io/docs/api/#ipos
 */
@Deprecated
public class UpcomingIposRequestBuilder implements IEXCloudV1RestRequest<Ipos> {

    @Override
    public RestRequest<Ipos> build() {
        return RestRequestBuilder.<Ipos>builder()
                .withPath("/stock/market/upcoming-ipos").get()
                .withResponse(Ipos.class)
                .build();
    }

}
