package de.fwidder.iextrading4j.test.acceptance;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.refdata.ExchangeSymbol;
import de.fwidder.iextrading4j.api.refdata.IEXCorporateActions;
import de.fwidder.iextrading4j.api.refdata.IEXDividends;
import de.fwidder.iextrading4j.api.refdata.IEXNextDayExDate;
import de.fwidder.iextrading4j.api.refdata.IEXSymbolDirectory;
import de.fwidder.iextrading4j.client.rest.request.refdata.IEXCorporateActionsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.refdata.IEXDividendsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.refdata.IEXNextDayExDateRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.refdata.IEXSymbolDirectoryRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.refdata.SymbolsRequestBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
@Disabled
class RefDataAcceptanceTest extends AcceptanceTestBase {

    @Test
    void symbolsAcceptanceTest() {
        final List<ExchangeSymbol> exchangeSymbolList = iexTradingClient.executeRequest(new SymbolsRequestBuilder()
                .build());
        assertThat(exchangeSymbolList).isNotNull();
    }

    @Test
    void nextDayExDateAcceptanceTest() {
        final List<IEXNextDayExDate> nextDayExDateList = iexTradingClient.executeRequest(new IEXNextDayExDateRequestBuilder()
                .withSample()
                .build());
        assertThat(nextDayExDateList).isNotNull();
    }

    @Test
    void corporateActionsAcceptanceTest() {
        final List<IEXCorporateActions> corporateActions = iexTradingClient.executeRequest(new IEXCorporateActionsRequestBuilder()
                .withSample()
                .build());
        assertThat(corporateActions).isNotNull();
    }

    @Test
    void dividendsAcceptanceTest() {
        final List<IEXDividends> dividendsList = iexTradingClient.executeRequest(new IEXDividendsRequestBuilder()
                .withSample()
                .build());
        assertThat(dividendsList).isNotNull();
    }

    @Test
    void symbolDirectoryAcceptanceTest() {
        final List<IEXSymbolDirectory> symbolDirectoryList = iexTradingClient.executeRequest(new IEXSymbolDirectoryRequestBuilder()
                .withSample()
                .build());
        assertThat(symbolDirectoryList).isNotNull();
    }

}
