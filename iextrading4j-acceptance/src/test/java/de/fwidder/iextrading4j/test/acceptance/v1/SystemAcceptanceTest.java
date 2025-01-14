package de.fwidder.iextrading4j.test.acceptance.v1;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.system.SystemStatus;
import de.fwidder.iextrading4j.client.rest.request.system.SystemStatusRequestBuilder;

import static org.assertj.core.api.Assertions.assertThat;

class SystemAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @Test
    void systemStatusTest() {
        final SystemStatus systemStatus = cloudClient.executeRequest(new SystemStatusRequestBuilder()
                .build());
        System.out.println(systemStatus);
        assertThat(systemStatus).isNotNull();
    }

}
