package de.fwidder.iextrading4j.test.rest;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Rule;
import org.junit.jupiter.api.extension.RegisterExtension;
import de.fwidder.iextrading4j.client.IEXApiClient;
import de.fwidder.iextrading4j.client.IEXTradingClient;

public abstract class BaseRestServiceTest {

    @RegisterExtension
    public WireMockExtension wireMockRule = new WireMockExtension(8089);

    protected IEXApiClient iexTradingClient;

    @BeforeEach
    public void setUp() throws Exception {
        iexTradingClient = IEXTradingClient.create();
    }

    @AfterEach
    public void tearDown() {
        iexTradingClient = null;
    }
}
