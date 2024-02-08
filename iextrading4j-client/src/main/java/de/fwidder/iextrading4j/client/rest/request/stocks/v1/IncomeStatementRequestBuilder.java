package de.fwidder.iextrading4j.client.rest.request.stocks.v1;

import de.fwidder.iextrading4j.api.stocks.v1.IncomeStatements;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class IncomeStatementRequestBuilder extends AbstractLastStocksRequestBuilder<IncomeStatements,
        IncomeStatementRequestBuilder> implements IEXCloudV1RestRequest<IncomeStatements> {

    @Override
    protected RestRequest<IncomeStatements> request() {
        return RestRequestBuilder.<IncomeStatements>builder()
                .withPath("/stock/{symbol}/income")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(IncomeStatements.class)
                .addQueryParam(queryParameters)
                .build();
    }

    @Override
    protected RestRequest<IncomeStatements> requestWithLast() {
        return RestRequestBuilder.<IncomeStatements>builder()
                .withPath("/stock/{symbol}/income/{last}")
                .addPathParam("last", String.valueOf(last))
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(IncomeStatements.class)
                .addQueryParam(queryParameters)
                .build();
    }

}
