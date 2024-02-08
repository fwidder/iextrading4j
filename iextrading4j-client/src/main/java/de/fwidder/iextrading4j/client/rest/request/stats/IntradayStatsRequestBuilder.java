package de.fwidder.iextrading4j.client.rest.request.stats;

import de.fwidder.iextrading4j.api.stats.IntradayStats;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXApiRestRequest;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class IntradayStatsRequestBuilder extends AbstractRequestFilterBuilder<IntradayStats, HistoricalStatsRequestBuilder>
        implements IEXApiRestRequest<IntradayStats>, IEXCloudV1RestRequest<IntradayStats> {

    @Override
    public RestRequest<IntradayStats> build() {
        return RestRequestBuilder.<IntradayStats>builder()
                .withPath("/stats/intraday").get()
                .withResponse(IntradayStats.class)
                .addQueryParam(getFilterParams())
                .build();
    }

}
