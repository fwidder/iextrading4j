package de.fwidder.iextrading4j.test.acceptance.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.corporate.AdvancedBonus;
import de.fwidder.iextrading4j.api.corporate.AdvancedDistribution;
import de.fwidder.iextrading4j.api.corporate.AdvancedSplits;
import de.fwidder.iextrading4j.client.rest.request.corporate.AdvancedBonusRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.corporate.AdvancedDistributionRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.corporate.AdvancedSplitsRequestBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled("Sandbox environment is disabled for this subscription tier.")
class CorporateActionsAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @BeforeEach
    @Override
    public void setUp() throws InterruptedException {
        super.setUp();
        // Additional delay, otherwise requests are failing with 429 Too Many Requests.
        Thread.sleep(550);
    }

    @Test
    void advancedBonusAcceptanceTest() {
        final List<AdvancedBonus> advancedBonus = cloudClient.executeRequest(
                new AdvancedBonusRequestBuilder()
                        .withSymbol("AAPL")
                        .build());
        assertThat(advancedBonus).isNotNull();
    }

    @Test
    void advancedDistributionAcceptanceTest() {
        final List<AdvancedDistribution> advancedDistributions = cloudClient.executeRequest(
                new AdvancedDistributionRequestBuilder()
                        .withSymbol("KERRF")
                        .build());
        assertThat(advancedDistributions).isNotNull();
    }

    @Test
    void advancedSplitsAcceptanceTest() {
        final List<AdvancedSplits> advancedSplits = cloudClient.executeRequest(
                new AdvancedSplitsRequestBuilder()
                        .withSymbol("AAPL")
                        .build());
        assertThat(advancedSplits).isNotNull();
    }

}
