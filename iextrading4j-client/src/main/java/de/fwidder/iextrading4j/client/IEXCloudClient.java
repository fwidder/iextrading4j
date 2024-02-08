package de.fwidder.iextrading4j.client;

import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;

import java.util.function.Consumer;

public interface IEXCloudClient {

    <R> R executeRequest(final RestRequest<R> restRequest);

    <R> void subscribe(SseRequest<R> asyncRequest, Consumer<R> consumer);

    <R> void unsubscribe(SseRequest<R> asyncRequest);

}
