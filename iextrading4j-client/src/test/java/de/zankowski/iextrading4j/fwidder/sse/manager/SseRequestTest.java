package de.fwidder.iextrading4j.client.sse.manager;

import com.google.common.collect.ImmutableMap;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.util.ToStringVerifier;

import jakarta.ws.rs.core.GenericType;
import java.io.Serializable;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class SseRequestTest {

    @Test
    void constructor() {
        final GenericType<Serializable> responseTypeMock = mock(GenericType.class);
        final String path = "path";
        final Map<String, String> headerParams = ImmutableMap.of();
        final Map<String, String> queryParams = ImmutableMap.of();
        final Map<String, String> pathParams = ImmutableMap.of();
        final Boolean useSecretToken = true;

        final SseRequest sseRequest = new SseRequest<>(responseTypeMock, path, headerParams, queryParams,
                pathParams, useSecretToken);

        assertThat(sseRequest.getResponseType()).isEqualTo(responseTypeMock);
        assertThat(sseRequest.getPath()).isEqualTo(path);
        assertThat(sseRequest.getHeaderParams()).isEqualTo(headerParams);
        assertThat(sseRequest.getQueryParams()).isEqualTo(queryParams);
        assertThat(sseRequest.getPathParams()).isEqualTo(pathParams);
        assertThat(sseRequest.getUseSecretToken()).isTrue();
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(SseRequest.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(new SseRequest<>(null, null, null, null,
                null, null))
                .verify();
    }

}
