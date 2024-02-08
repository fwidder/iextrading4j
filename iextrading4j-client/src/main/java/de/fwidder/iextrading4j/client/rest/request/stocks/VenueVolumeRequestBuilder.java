package de.fwidder.iextrading4j.client.rest.request.stocks;

import de.fwidder.iextrading4j.api.stocks.VenueVolume;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXApiRestRequest;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class VenueVolumeRequestBuilder extends AbstractStocksRequestBuilder<List<VenueVolume>, VenueVolumeRequestBuilder>
        implements IEXApiRestRequest<List<VenueVolume>>, IEXCloudV1RestRequest<List<VenueVolume>> {

    @Override
    public RestRequest<List<VenueVolume>> build() {
        return RestRequestBuilder.<List<VenueVolume>>builder()
                .withPath("/stock/{symbol}/volume-by-venue")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<List<VenueVolume>>() {})
                .build();
    }

}
