package de.fwidder.iextrading4j.client.rest.endpoint;

import de.fwidder.iextrading4j.client.rest.AbstractRestEndpoint;
import de.fwidder.iextrading4j.client.rest.manager.RestManager;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;

public class GenericRestEndpoint extends AbstractRestEndpoint {

    public GenericRestEndpoint(final RestManager restManager) {
        super(restManager);
    }

    public <R> R executeRequest(final RestRequest<R> restRequest) {
        return execute(restRequest);
    }

}
