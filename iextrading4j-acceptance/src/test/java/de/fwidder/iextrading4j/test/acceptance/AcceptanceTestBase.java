package de.fwidder.iextrading4j.test.acceptance;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import de.fwidder.iextrading4j.client.IEXApiClient;
import de.fwidder.iextrading4j.client.IEXTradingClient;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public abstract class AcceptanceTestBase {

    protected static IEXApiClient iexTradingClient;

    @BeforeAll
    public static void setUp() throws Exception {
        iexTradingClient = IEXTradingClient.create();
    }

    @BeforeEach
    void beforeEach() throws InterruptedException {
        Thread.sleep(200);
    }

    @AfterAll
    public static void tearDown() {
        iexTradingClient = null;
    }

}
