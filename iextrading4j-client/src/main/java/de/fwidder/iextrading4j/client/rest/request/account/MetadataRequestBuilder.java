package de.fwidder.iextrading4j.client.rest.request.account;

import de.fwidder.iextrading4j.api.account.Metadata;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;

public class MetadataRequestBuilder extends AbstractRequestFilterBuilder<Metadata, MetadataRequestBuilder>
        implements IEXCloudV1RestRequest<Metadata> {

    @Override
    public RestRequest<Metadata> build() {
        return RestRequestBuilder.<Metadata>builder()
                .withPath("/account/metadata").get()
                .withResponse(new GenericType<Metadata>() {})
                .addQueryParam(getFilterParams())
                .withSecretToken()
                .build();
    }

}
