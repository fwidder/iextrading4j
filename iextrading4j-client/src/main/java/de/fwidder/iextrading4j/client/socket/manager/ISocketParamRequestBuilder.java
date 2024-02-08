package de.fwidder.iextrading4j.client.socket.manager;

public interface ISocketParamRequestBuilder<R> {

    ISocketParamRequestBuilder<R> withParam(Object param);

    SocketRequest<R> build();

}
