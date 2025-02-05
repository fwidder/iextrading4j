package de.fwidder.iextrading4j.client.rest.request.stocks.v1;

import de.fwidder.iextrading4j.api.stocks.v1.CashFlows;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

/**
 * Cash Flow
 * <p>
 * Pulls cash flow data. Available quarterly or annually, with the default being the last available quarter.
 * This data is currently only available for U.S. symbols.
 * </p>
 * https://iexcloud.io/docs/api/#cash-flow
 */
public class CashFlowRequestBuilder extends AbstractLastStocksRequestBuilder<CashFlows, CashFlowRequestBuilder>
        implements IEXCloudV1RestRequest<CashFlows> {

    @Override
    protected RestRequest<CashFlows> request() {
        return RestRequestBuilder.<CashFlows>builder()
                .withPath("/stock/{symbol}/cash-flow")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(CashFlows.class)
                .addQueryParam(queryParameters)
                .build();
    }

    @Override
    protected RestRequest<CashFlows> requestWithLast() {
        return RestRequestBuilder.<CashFlows>builder()
                .withPath("/stock/{symbol}/cash-flow/{last}")
                .addPathParam("last", String.valueOf(last))
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(CashFlows.class)
                .addQueryParam(queryParameters)
                .build();
    }

}
