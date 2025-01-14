package de.fwidder.iextrading4j.client.socket.endpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.marketdata.TOPS;
import de.fwidder.iextrading4j.client.socket.manager.SocketManager;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;
import de.fwidder.iextrading4j.client.socket.request.marketdata.TopsAsyncRequestBuilder;

import java.util.function.Consumer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GenericSocketEndpointTest {

    private GenericSocketEndpoint genericSocketEndpoint;
    private SocketManager socketManagerMock;

    @BeforeEach
    public void setUp() {
        socketManagerMock = mock(SocketManager.class);
        genericSocketEndpoint = new GenericSocketEndpoint(socketManagerMock);
    }

    @Test
    void shouldSuccessfullySubscribe() {
        final SocketRequest<TOPS> request = new TopsAsyncRequestBuilder().build();
        final Consumer<TOPS> topsConsumer = mock(Consumer.class);

        genericSocketEndpoint.subscribe(request, topsConsumer);

        verify(socketManagerMock).subscribe(request, topsConsumer);
    }

    @Test
    void shouldSuccessfullyUnsubscribe() {
        final SocketRequest<TOPS> request = new TopsAsyncRequestBuilder().build();

        genericSocketEndpoint.unsubscribe(request);

        verify(socketManagerMock).unsubscribe(request);
    }
}
