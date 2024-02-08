package de.fwidder.iextrading4j.client.rest.request.stocks;

import de.fwidder.iextrading4j.api.stocks.SectorPerformance;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class SectorPerformanceRequestBuilder implements IEXCloudV1RestRequest<List<SectorPerformance>> {

    @Override
    public RestRequest<List<SectorPerformance>> build() {
        return RestRequestBuilder.<List<SectorPerformance>>builder()
                .withPath("/stock/market/sector-performance").get()
                .withResponse(new GenericType<List<SectorPerformance>>(){})
                .build();
    }

}