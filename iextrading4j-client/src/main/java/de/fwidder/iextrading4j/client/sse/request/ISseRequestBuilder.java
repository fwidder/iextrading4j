package de.fwidder.iextrading4j.client.sse.request;

import de.fwidder.iextrading4j.client.sse.manager.SseRequest;

public interface ISseRequestBuilder<R> {

    SseRequest<R> build();

}
