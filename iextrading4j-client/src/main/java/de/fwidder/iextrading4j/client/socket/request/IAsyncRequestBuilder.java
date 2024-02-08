package de.fwidder.iextrading4j.client.socket.request;

import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;

public interface IAsyncRequestBuilder<R> {

    SocketRequest<R> build();

}
