package de.fwidder.iextrading4j.client.rest.request;

import de.fwidder.iextrading4j.client.rest.manager.RestRequest;

public interface IRestRequestBuilder<R> {

    RestRequest<R> build();

}
