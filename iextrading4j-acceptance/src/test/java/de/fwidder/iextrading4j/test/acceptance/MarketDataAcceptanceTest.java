package de.fwidder.iextrading4j.test.acceptance;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.marketdata.Auction;
import de.fwidder.iextrading4j.api.marketdata.Book;
import de.fwidder.iextrading4j.api.marketdata.DEEP;
import de.fwidder.iextrading4j.api.marketdata.HIST;
import de.fwidder.iextrading4j.api.marketdata.LastTrade;
import de.fwidder.iextrading4j.api.marketdata.OfficialPrice;
import de.fwidder.iextrading4j.api.marketdata.OpHaltStatus;
import de.fwidder.iextrading4j.api.marketdata.SecurityEvent;
import de.fwidder.iextrading4j.api.marketdata.SsrStatus;
import de.fwidder.iextrading4j.api.marketdata.SystemEvent;
import de.fwidder.iextrading4j.api.marketdata.TOPS;
import de.fwidder.iextrading4j.api.marketdata.Trade;
import de.fwidder.iextrading4j.api.marketdata.TradingStatus;
import de.fwidder.iextrading4j.client.rest.request.marketdata.AuctionRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.marketdata.BookRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.marketdata.DeepRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.marketdata.HistRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.marketdata.LastTradeRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.marketdata.OfficialPriceRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.marketdata.OpHaltStatusRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.marketdata.SecurityEventRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.marketdata.SsrStatusRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.marketdata.SystemEventRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.marketdata.TopsRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.marketdata.TradeBreakRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.marketdata.TradeRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.marketdata.TradingStatusRequestBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
@Disabled
class MarketDataAcceptanceTest extends AcceptanceTestBase {

    @Disabled("403 Forbidden")
    @Test
    void bookAcceptanceTest() {
        final Map<String, Book> books = iexTradingClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .withSymbol("SNAP")
                .build());
        assertThat(books).isNotNull();
    }

    @Disabled("403 Forbidden")
    @Test
    void deepAcceptanceTest() {
        final DEEP deep = iexTradingClient.executeRequest(new DeepRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(deep).isNotNull();
    }

    @Test
    void histAcceptanceTest() {
        final List<HIST> histList = iexTradingClient.executeRequest(new HistRequestBuilder()
                .withDate(LocalDate.of(2017, 5, 15))
                .build());
        assertThat(histList).isNotNull();
    }

    @Test
    void histParameterizedAcceptanceTest() {
        final Map<String, List<HIST>> histMap = iexTradingClient.executeRequest(new HistRequestBuilder()
                .build());
        assertThat(histMap).isNotNull();
    }

    @Disabled("403 Forbidden")
    @Test
    void lastTradeAcceptanceTest() {
        final List<LastTrade> lastTradeList = iexTradingClient.executeRequest(new LastTradeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(lastTradeList).isNotNull();
    }

    @Disabled("403 Forbidden")
    @Test
    void opHaltStatusAcceptanceTest() {
        final Map<String, OpHaltStatus> opHaltStatuses = iexTradingClient.executeRequest(new OpHaltStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(opHaltStatuses).isNotNull();
    }

    @Disabled("403 Forbidden")
    @Test
    void officialPriceAcceptanceTest() {
        final Map<String, OfficialPrice> officialPriceMap = iexTradingClient.executeRequest(new OfficialPriceRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(officialPriceMap).isNotNull();
    }

    @Disabled("403 Forbidden")
    @Test
    void securityEventAcceptanceTest() {
        final Map<String, SecurityEvent> securityEvent = iexTradingClient.executeRequest(new SecurityEventRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(securityEvent).isNotNull();
    }

    @Disabled("403 Forbidden")
    @Test
    void ssrStatusAcceptanceTest() {
        final Map<String, SsrStatus> ssrStatus = iexTradingClient.executeRequest(new SsrStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(ssrStatus).isNotNull();
    }

    @Disabled("403 Forbidden")
    @Test
    void systemEventAcceptanceTest() {
        final SystemEvent systemEvent = iexTradingClient.executeRequest(new SystemEventRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(systemEvent).isNotNull();
    }

    @Disabled("403 Forbidden")
    @Test
    void topsAcceptanceTest() {
        final List<TOPS> tops = iexTradingClient.executeRequest(new TopsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(tops).isNotNull();
    }

    @Disabled("403 Forbidden")
    @Test
    void tradeBreakAcceptanceTest() {
        final Map<String, List<Trade>> tradeBreak = iexTradingClient.executeRequest(new TradeBreakRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(tradeBreak).isNotNull();
    }

    @Disabled("403 Forbidden")
    @Test
    void tradeAcceptanceTest() {
        final Map<String, List<Trade>> trade = iexTradingClient.executeRequest(new TradeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(trade).isNotNull();
    }

    @Disabled("403 Forbidden")
    @Test
    void tradingStatusAcceptanceTest() {
        final Map<String, TradingStatus> tradingStatus = iexTradingClient.executeRequest(new TradingStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(tradingStatus).isNotNull();
    }

    @Disabled("403 Forbidden")
    @Test
    void auctionAcceptanceTest() {
        final Map<String, Auction> auction = iexTradingClient.executeRequest(new AuctionRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(auction).isNotNull();
    }

}
