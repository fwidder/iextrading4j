package de.fwidder.iextrading4j.client.rest.manager;

import java.util.Map;

public interface IRestParamRequestBuilder<R> {

    IRestParamRequestBuilder<R> addHeaderParam(String key, String value);

    IRestParamRequestBuilder<R> addQueryParam(String key, String value);

    IRestParamRequestBuilder<R> addQueryParam(Map<String, String> queryParams);

    IRestParamRequestBuilder<R> withSecretToken();

    RestRequest<R> build();

}
