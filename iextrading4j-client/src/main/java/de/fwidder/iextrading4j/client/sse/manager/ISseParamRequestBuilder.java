package de.fwidder.iextrading4j.client.sse.manager;

import java.util.Map;

public interface ISseParamRequestBuilder<R> {

    ISseParamRequestBuilder<R> addHeaderParam(String key, String value);

    ISseParamRequestBuilder<R> addQueryParam(String key, String value);

    ISseParamRequestBuilder<R> addQueryParam(Map<String, String> queryParams);

    ISseParamRequestBuilder<R> withSecretToken();

    SseRequest<R> build();

}
