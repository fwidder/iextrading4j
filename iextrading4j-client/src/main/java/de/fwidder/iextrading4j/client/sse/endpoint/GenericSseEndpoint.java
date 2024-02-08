package de.fwidder.iextrading4j.client.sse.endpoint;

import de.fwidder.iextrading4j.client.sse.ISseEndpoint;
import de.fwidder.iextrading4j.client.sse.manager.SseManager;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;

import java.util.function.Consumer;

public class GenericSseEndpoint implements ISseEndpoint {

    private final SseManager sseManager;

    public GenericSseEndpoint(final SseManager sseManager) {
        this.sseManager = sseManager;
    }

    @Override
    public <R> void subscribe(final SseRequest<R> sseRequest, final Consumer<R> consumer) {
        sseManager.subscribe(sseRequest, consumer);
    }

    @Override
    public <R> void unsubscribe(final SseRequest<R> sseRequest) {
        sseManager.unsubscribe(sseRequest);
    }

}
