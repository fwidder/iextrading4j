package de.fwidder.iextrading4j.test.rest.v1.account;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.account.Metadata;
import de.fwidder.iextrading4j.client.rest.request.account.MetadataRequestBuilder;
import de.fwidder.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class MetadataServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void metadataServiceTest() {
        stubFor(get(urlEqualTo(secretPath("/account/metadata")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/account/MetadataResponse.json")));

        final Metadata metadata = cloudClient.executeRequest(new MetadataRequestBuilder()
                .build());

        assertThat(metadata.getPayAsYouGoEnabled()).isTrue();
        assertThat(metadata.getEffectiveDate()).isEqualTo(1547590582000L);
        assertThat(metadata.getEndDateEffective()).isEqualTo(1547830921000L);
        assertThat(metadata.getSubscriptionTermType()).isEqualTo("monthly");
        assertThat(metadata.getTierName()).isEqualTo("launch");
        assertThat(metadata.getMessageLimit()).isEqualTo(1000000000L);
        assertThat(metadata.getCreditLimit()).isEqualTo(540000L);
        assertThat(metadata.getMessagesUsed()).isEqualTo(215141655L);
        assertThat(metadata.getCreditsUsed()).isEqualTo(1500L);
        assertThat(metadata.getCircuitBreaker()).isEqualTo(3000000000L);
    }

}
