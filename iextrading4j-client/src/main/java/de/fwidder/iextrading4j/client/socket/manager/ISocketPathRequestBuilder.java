package de.fwidder.iextrading4j.client.socket.manager;

public interface ISocketPathRequestBuilder<R> {

    ISocketResponseTypeRequestBuilder<R> withPath(String path);

}
