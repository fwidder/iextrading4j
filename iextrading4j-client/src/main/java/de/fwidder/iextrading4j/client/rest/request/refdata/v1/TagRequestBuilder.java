package de.fwidder.iextrading4j.client.rest.request.refdata.v1;

import de.fwidder.iextrading4j.api.refdata.v1.Tag;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class TagRequestBuilder extends AbstractRequestFilterBuilder<List<Tag>, TagRequestBuilder>
        implements IEXCloudV1RestRequest<List<Tag>> {

    @Override
    public RestRequest<List<Tag>> build() {
        return RestRequestBuilder.<List<Tag>>builder()
                .withPath("/ref-data/tags").get()
                .withResponse(new GenericType<List<Tag>>() {})
                .addQueryParam(getFilterParams())
                .build();
    }

}
