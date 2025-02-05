package de.fwidder.iextrading4j.client.rest.manager;

public interface IRestRequestTypeBuilder<R> {

    IRestRequestTypeBuilder<R> addPathParam(String key, String value);

    IRestResponseTypeRequestBuilder<R> get();

    IRestRequestBodyBuilder<R> post();

}
