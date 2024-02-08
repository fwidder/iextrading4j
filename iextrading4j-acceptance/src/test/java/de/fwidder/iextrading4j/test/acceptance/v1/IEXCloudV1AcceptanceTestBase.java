package de.fwidder.iextrading4j.test.acceptance.v1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import de.fwidder.iextrading4j.client.IEXCloudClient;
import de.fwidder.iextrading4j.client.IEXCloudTokenBuilder;
import de.fwidder.iextrading4j.client.IEXTradingApiVersion;
import de.fwidder.iextrading4j.client.IEXTradingClient;

public abstract class IEXCloudV1AcceptanceTestBase {

    protected IEXCloudClient cloudClient;

    @BeforeEach
    public void setUp() throws InterruptedException {
        cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_STABLE_SANDBOX, new IEXCloudTokenBuilder()
                .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                .build());
        // Sandbox Testing has a request limit of 10 requests per second measured in milliseconds.
        Thread.sleep(200);
    }

    @AfterEach
    public void tearDown() {
        cloudClient = null;
    }

}
