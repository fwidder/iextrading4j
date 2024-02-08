package de.fwidder.iextrading4j.client.sse;

import de.fwidder.iextrading4j.client.IEndpoint;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;

import java.util.function.Consumer;

public interface ISseEndpoint extends IEndpoint {

    <R> void subscribe(SseRequest<R> sseRequest, Consumer<R> consumer);

    <R> void unsubscribe(SseRequest<R> sseRequest);

}
