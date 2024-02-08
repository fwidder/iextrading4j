package de.fwidder.iextrading4j.client.rest;

import de.fwidder.iextrading4j.client.IEndpoint;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;

public interface IRestEndpoint extends IEndpoint {

    <R> R execute(RestRequest<R> restRequest);

}
