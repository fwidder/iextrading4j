package de.fwidder.iextrading4j.client.rest.request.system;

import de.fwidder.iextrading4j.api.system.SystemStatus;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class SystemStatusRequestBuilder implements IEXCloudV1RestRequest<SystemStatus> {

    @Override
    public RestRequest<SystemStatus> build() {
        return RestRequestBuilder.<SystemStatus>builder()
                .withPath("/status").get()
                .withResponse(SystemStatus.class)
                .build();
    }

}
