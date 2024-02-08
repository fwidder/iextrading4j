package de.fwidder.iextrading4j.client.rest.manager;

public interface IRestPathRequestBuilder<R> {

    IRestRequestTypeBuilder<R> withPath(String path);

}
