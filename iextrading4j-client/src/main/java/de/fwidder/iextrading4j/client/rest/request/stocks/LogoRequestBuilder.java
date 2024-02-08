package de.fwidder.iextrading4j.client.rest.request.stocks;

import de.fwidder.iextrading4j.api.stocks.Logo;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class LogoRequestBuilder extends AbstractStocksRequestBuilder<Logo, LogoRequestBuilder>
        implements IEXCloudV1RestRequest<Logo> {

    @Override
    public RestRequest<Logo> build() {
        return RestRequestBuilder.<Logo>builder()
                .withPath("/stock/{symbol}/logo")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Logo.class)
                .build();
    }

}
