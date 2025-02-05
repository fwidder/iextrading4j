package de.fwidder.iextrading4j.client.socket.endpoint;

import de.fwidder.iextrading4j.client.socket.ISocketEndpoint;
import de.fwidder.iextrading4j.client.socket.manager.SocketManager;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;

import java.util.function.Consumer;

public class GenericSocketEndpoint implements ISocketEndpoint {

    private final SocketManager socketManager;

    public GenericSocketEndpoint(final SocketManager socketManager) {
        this.socketManager = socketManager;
    }

    @Override
    public <R> void subscribe(final SocketRequest<R> socketRequest, final Consumer<R> consumer) {
        socketManager.subscribe(socketRequest, consumer);
    }

    @Override
    public <R> void unsubscribe(final SocketRequest<R> socketRequest) {
        socketManager.unsubscribe(socketRequest);
    }

}
