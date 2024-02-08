package de.fwidder.iextrading4j.sample.iexcloud.rest;

import de.fwidder.iextrading4j.api.system.SystemStatus;
import de.fwidder.iextrading4j.client.IEXCloudClient;
import de.fwidder.iextrading4j.client.IEXCloudTokenBuilder;
import de.fwidder.iextrading4j.client.IEXTradingApiVersion;
import de.fwidder.iextrading4j.client.IEXTradingClient;
import de.fwidder.iextrading4j.client.rest.request.system.SystemStatusRequestBuilder;

public class SystemSample {

    private final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) {
        final SystemSample systemSample = new SystemSample();
        systemSample.systemStatusRequestSample();
    }

    private void systemStatusRequestSample() {
        final SystemStatus systemStatus = cloudClient.executeRequest(new SystemStatusRequestBuilder()
                .build());
        System.out.println(systemStatus);
    }

}
