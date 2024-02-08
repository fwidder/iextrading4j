package de.fwidder.iextrading4j.sample.iexapi.rest;

import de.fwidder.iextrading4j.api.refdata.ExchangeSymbol;
import de.fwidder.iextrading4j.api.refdata.IEXCorporateActions;
import de.fwidder.iextrading4j.api.refdata.IEXDividends;
import de.fwidder.iextrading4j.api.refdata.IEXNextDayExDate;
import de.fwidder.iextrading4j.api.refdata.IEXSymbolDirectory;
import de.fwidder.iextrading4j.client.IEXApiClient;
import de.fwidder.iextrading4j.client.IEXTradingClient;
import de.fwidder.iextrading4j.client.rest.request.refdata.IEXCorporateActionsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.refdata.IEXDividendsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.refdata.IEXNextDayExDateRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.refdata.IEXSymbolDirectoryRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.refdata.SymbolsRequestBuilder;

import java.util.List;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class RefDataSample {

    private final IEXApiClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        final RefDataSample sampleSuite = new RefDataSample();

        sampleSuite.symbolsRequestSample();
        sampleSuite.nextDayExDateRequestSample();
        sampleSuite.corporateActionsRequestSample();
        sampleSuite.dividendsRequestSample();
        sampleSuite.symbolDirectoryRequestSample();
    }

    private void symbolsRequestSample() {
        final List<ExchangeSymbol> exchangeSymbolList = iexTradingClient.executeRequest(new SymbolsRequestBuilder()
                .build());
        System.out.println(exchangeSymbolList);
    }

    private void nextDayExDateRequestSample() {
        final List<IEXNextDayExDate> nextDayExDateList = iexTradingClient.executeRequest(new IEXNextDayExDateRequestBuilder()
                .withSample()
                .build());
        System.out.println(nextDayExDateList);
    }

    private void corporateActionsRequestSample() {
        final List<IEXCorporateActions> corporateActions = iexTradingClient.executeRequest(new IEXCorporateActionsRequestBuilder()
                .withSample()
                .build());
        System.out.println(corporateActions);
    }

    private void dividendsRequestSample() {
        final List<IEXDividends> dividendsList = iexTradingClient.executeRequest(new IEXDividendsRequestBuilder()
                .withSample()
                .build());
        System.out.println(dividendsList);
    }

    private void symbolDirectoryRequestSample() {
        final List<IEXSymbolDirectory> symbolDirectoryList = iexTradingClient.executeRequest(new IEXSymbolDirectoryRequestBuilder()
                .withSample()
                .build());
        System.out.println(symbolDirectoryList);
    }

}
