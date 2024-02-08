package de.fwidder.iextrading4j.sample.iexapi.rest;

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
import de.fwidder.iextrading4j.client.IEXApiClient;
import de.fwidder.iextrading4j.client.IEXTradingClient;
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

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class MarketDataSample {

    private final IEXApiClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        final MarketDataSample sampleSuite = new MarketDataSample();

        sampleSuite.bookRequestSample();
        sampleSuite.deepRequestSample();
        sampleSuite.histRequestSample();
        sampleSuite.histParameterizedRequestSample();
        sampleSuite.lastTradeRequestSample();
        sampleSuite.opHaltStatusRequestSample();
        sampleSuite.officialPriceRequestSample();
        sampleSuite.securityEventRequestSample();
        sampleSuite.ssrStatusRequestSample();
        sampleSuite.systemEventRequestSample();
        sampleSuite.topsRequestSample();
        sampleSuite.tradeBreakRequestSample();
        sampleSuite.tradeRequestSample();
        sampleSuite.tradingStatusRequestSample();
        sampleSuite.auctionRequestSample();
    }

    private void bookRequestSample() {
        final Map<String, Book> books = iexTradingClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .withSymbol("SNAP")
                .build());
        System.out.println(books);
    }

    private void deepRequestSample() {
        final DEEP deep = iexTradingClient.executeRequest(new DeepRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(deep);
    }

    private void histRequestSample() {
        final Map<String, List<HIST>> histMap = iexTradingClient.executeRequest(new HistRequestBuilder()
                .build());
        System.out.println(histMap);
    }

    private void histParameterizedRequestSample() {
        final List<HIST> histList = iexTradingClient.executeRequest(new HistRequestBuilder()
                .withDate(LocalDate.of(2017, 5, 15))
                .build());
        System.out.println(histList);
    }

    private void lastTradeRequestSample() {
        final List<LastTrade> lastTradeList = iexTradingClient.executeRequest(new LastTradeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(lastTradeList);
    }

    private void opHaltStatusRequestSample() {
        final Map<String, OpHaltStatus> opHaltStatuses = iexTradingClient.executeRequest(new OpHaltStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(opHaltStatuses);
    }

    private void officialPriceRequestSample() {
        final Map<String, OfficialPrice> officialPriceMap = iexTradingClient.executeRequest(new OfficialPriceRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(officialPriceMap);
    }

    private void securityEventRequestSample() {
        final Map<String, SecurityEvent> securityEvent = iexTradingClient.executeRequest(new SecurityEventRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(securityEvent);
    }

    private void ssrStatusRequestSample() {
        final Map<String, SsrStatus> ssrStatus = iexTradingClient.executeRequest(new SsrStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(ssrStatus);
    }

    private void systemEventRequestSample() {
        final SystemEvent systemEvent = iexTradingClient.executeRequest(new SystemEventRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(systemEvent);
    }

    private void topsRequestSample() {
        final List<TOPS> tops = iexTradingClient.executeRequest(new TopsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(tops);
    }

    private void tradeBreakRequestSample() {
        final Map<String, List<Trade>> tradeBreak = iexTradingClient.executeRequest(new TradeBreakRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(tradeBreak);
    }

    private void tradeRequestSample() {
        final Map<String, List<Trade>> trade = iexTradingClient.executeRequest(new TradeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(trade);
    }

    private void tradingStatusRequestSample() {
        final Map<String, TradingStatus> tradingStatus = iexTradingClient.executeRequest(new TradingStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(tradingStatus);
    }

    private void auctionRequestSample() {
        final Map<String, Auction> auction = iexTradingClient.executeRequest(new AuctionRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(auction);
    }

}
