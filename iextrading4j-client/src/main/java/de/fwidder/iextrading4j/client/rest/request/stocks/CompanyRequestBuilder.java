package de.fwidder.iextrading4j.client.rest.request.stocks;

import de.fwidder.iextrading4j.api.stocks.Company;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class CompanyRequestBuilder extends AbstractStocksRequestBuilder<Company, CompanyRequestBuilder>
        implements IEXCloudV1RestRequest<Company> {

    @Override
    public RestRequest<Company> build() {
        return RestRequestBuilder.<Company>builder()
                .withPath("/stock/{symbol}/company")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Company.class)
                .build();
    }

}
