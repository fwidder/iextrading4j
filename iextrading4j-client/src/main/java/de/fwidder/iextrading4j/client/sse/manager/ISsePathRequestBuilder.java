package de.fwidder.iextrading4j.client.sse.manager;

public interface ISsePathRequestBuilder<R> {

    ISseResponseTypeRequestBuilder<R> withPath(String path);

}
