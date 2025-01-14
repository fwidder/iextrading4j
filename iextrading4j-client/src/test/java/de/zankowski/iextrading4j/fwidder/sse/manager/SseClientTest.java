package de.fwidder.iextrading4j.client.sse.manager;

import jakarta.ws.rs.client.Client;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class SseClientTest {

    @Test
    void testConstructor() {
        final Client clientMock = mock(Client.class);
        final SseClientMetadata sseClientMetadata = mock(SseClientMetadata.class);

        final SseClient restClient = new SseClient(clientMock, sseClientMetadata);

        assertThat(restClient.getClient()).isEqualTo(clientMock);
        assertThat(restClient.getSseClientMetadata()).isEqualTo(sseClientMetadata);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(SseClient.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(new SseClient(null, null))
                .verify();
    }

}
