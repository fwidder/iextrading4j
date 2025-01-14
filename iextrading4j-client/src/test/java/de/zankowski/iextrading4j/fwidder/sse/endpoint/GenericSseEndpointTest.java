package de.fwidder.iextrading4j.client.sse.endpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.marketdata.TOPS;
import de.fwidder.iextrading4j.client.sse.manager.SseManager;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.request.marketdata.TopsSseRequestBuilder;

import java.util.List;
import java.util.function.Consumer;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GenericSseEndpointTest {

    private GenericSseEndpoint genericSseEndpoint;
    private SseManager sseManagerMock;

    @BeforeEach
    public void setUp() {
        sseManagerMock = mock(SseManager.class);
        genericSseEndpoint = new GenericSseEndpoint(sseManagerMock);
    }

    @Test
    void shouldSuccessfullySubscribe() {
        final SseRequest<List<TOPS>> request = new TopsSseRequestBuilder().build();
        final Consumer<List<TOPS>> topsConsumer = mock(Consumer.class);

        genericSseEndpoint.subscribe(request, topsConsumer);

        verify(sseManagerMock).subscribe(request, topsConsumer);
    }

    @Test
    void shouldSuccessfullyUnsubscribe() {
        final SseRequest<List<TOPS>> request = new TopsSseRequestBuilder().build();

        genericSseEndpoint.unsubscribe(request);

        verify(sseManagerMock).unsubscribe(request);
    }

}
