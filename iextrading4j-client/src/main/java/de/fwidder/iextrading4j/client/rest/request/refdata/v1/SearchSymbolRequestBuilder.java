package de.fwidder.iextrading4j.client.rest.request.refdata.v1;

import de.fwidder.iextrading4j.api.refdata.v1.SymbolDescription;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class SearchSymbolRequestBuilder implements IEXCloudV1RestRequest<List<SymbolDescription>> {

    private String fragment;

    public SearchSymbolRequestBuilder withFragment(final String fragment) {
        this.fragment = fragment;
        return this;
    }

    @Override
    public RestRequest<List<SymbolDescription>> build() {
        return RestRequestBuilder.<List<SymbolDescription>>builder()
                .withPath("/search/{fragment}")
                .addPathParam("fragment", fragment).get()
                .withResponse(new GenericType<List<SymbolDescription>>() {
                })
                .build();
    }

}
