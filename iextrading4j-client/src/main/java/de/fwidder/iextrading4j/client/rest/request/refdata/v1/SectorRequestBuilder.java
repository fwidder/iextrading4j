package de.fwidder.iextrading4j.client.rest.request.refdata.v1;

import de.fwidder.iextrading4j.api.refdata.v1.Sector;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class SectorRequestBuilder extends AbstractRequestFilterBuilder<List<Sector>, SectorRequestBuilder>
        implements IEXCloudV1RestRequest<List<Sector>> {

    @Override
    public RestRequest<List<Sector>> build() {
        return RestRequestBuilder.<List<Sector>>builder()
                .withPath("/ref-data/sectors").get()
                .withResponse(new GenericType<List<Sector>>() {})
                .addQueryParam(getFilterParams())
                .build();
    }

}
