package de.fwidder.iextrading4j.sample.iexcloud.sse;

import de.fwidder.iextrading4j.api.marketdata.Auction;
import de.fwidder.iextrading4j.api.marketdata.Book;
import de.fwidder.iextrading4j.api.marketdata.DeepResult;
import de.fwidder.iextrading4j.api.marketdata.LastTrade;
import de.fwidder.iextrading4j.api.marketdata.OpHaltStatus;
import de.fwidder.iextrading4j.api.marketdata.SecurityEvent;
import de.fwidder.iextrading4j.api.marketdata.SsrStatus;
import de.fwidder.iextrading4j.api.marketdata.SystemEvent;
import de.fwidder.iextrading4j.api.marketdata.TOPS;
import de.fwidder.iextrading4j.api.marketdata.Trade;
import de.fwidder.iextrading4j.api.marketdata.TradingStatus;
import de.fwidder.iextrading4j.client.IEXCloudClient;
import de.fwidder.iextrading4j.client.IEXCloudTokenBuilder;
import de.fwidder.iextrading4j.client.IEXTradingApiVersion;
import de.fwidder.iextrading4j.client.IEXTradingClient;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepConsumerAdapter;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.request.marketdata.AuctionSseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.marketdata.BookSseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.marketdata.DeepSseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.marketdata.LastSseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.marketdata.OpHaltStatusSseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.marketdata.SecurityEventSseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.marketdata.SsrStatusSseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.marketdata.SystemEventSseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.marketdata.TopsSseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.marketdata.TradeBreaksSseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.marketdata.TradesSseRequestBuilder;
import de.fwidder.iextrading4j.client.sse.request.marketdata.TradingStatusSseRequestBuilder;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class SseMarketDataSample {

    final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) throws InterruptedException {
        final SseMarketDataSample marketDataSample = new SseMarketDataSample();

        marketDataSample.topsSseRequestSample();
        marketDataSample.lastSseRequestSample();

        // marketDataSample.tradingStatusSseRequestSample();
        // marketDataSample.auctionSseRequestSample();
        // marketDataSample.opHaltStatusSseRequestSample();
        // marketDataSample.ssrStatusSseRequestBuilder();
        // marketDataSample.securityEventSseRequestBuilder();
        // marketDataSample.tradeBreakSseRequestSample();
        // marketDataSample.tradesSseRequestSample();
        marketDataSample.bookSseRequestSample();
        // marketDataSample.systemEventSseRequestSample();
        marketDataSample.deepSseRequestSample();
        // marketDataSample.deepSseRequestWithAdapterSample();

        new Semaphore(0).acquire();
    }

    private static final Consumer<List<TOPS>> TOPS_CONSUMER = System.out::println;

    private void topsSseRequestSample() {
        final SseRequest<List<TOPS>> request = new TopsSseRequestBuilder()
                .withSymbol("IBM")
                .build();

        cloudClient.subscribe(request, TOPS_CONSUMER);
    }

    private static final Consumer<List<LastTrade>> LAST_CONSUMER = System.out::println;

    private void lastSseRequestSample() {
        final SseRequest<List<LastTrade>> request = new LastSseRequestBuilder()
                .withSymbol("IBM")
                .build();

        cloudClient.subscribe(request, LAST_CONSUMER);
    }

    private static final Consumer<List<DeepAsyncResponse<TradingStatus>>> TRADING_STATUS_CONSUMER = System.out::println;

    private void tradingStatusSseRequestSample() {
        final SseRequest<List<DeepAsyncResponse<TradingStatus>>> request = new TradingStatusSseRequestBuilder()
                .withSymbol("IBM")
                .build();

        cloudClient.subscribe(request, TRADING_STATUS_CONSUMER);
    }

    private static final Consumer<List<DeepAsyncResponse<Auction>>> AUCTION_CONSUMER = System.out::println;

    private void auctionSseRequestSample() {
        final SseRequest<List<DeepAsyncResponse<Auction>>> request = new AuctionSseRequestBuilder()
                .withSymbol("IBM")
                .build();

        cloudClient.subscribe(request, AUCTION_CONSUMER);
    }

    private static final Consumer<List<DeepAsyncResponse<OpHaltStatus>>> OP_HALT_STATUS_CONSUMER = System.out::println;

    private void opHaltStatusSseRequestSample() {
        final SseRequest<List<DeepAsyncResponse<OpHaltStatus>>> request = new OpHaltStatusSseRequestBuilder()
                .withSymbol("IBM")
                .build();

        cloudClient.subscribe(request, OP_HALT_STATUS_CONSUMER);
    }

    private static final Consumer<List<DeepAsyncResponse<SsrStatus>>> SSR_STATUS_CONSUMER = System.out::println;

    private void ssrStatusSseRequestBuilder() {
        final SseRequest<List<DeepAsyncResponse<SsrStatus>>> request = new SsrStatusSseRequestBuilder()
                .withSymbol("IBM")
                .build();

        cloudClient.subscribe(request, SSR_STATUS_CONSUMER);
    }

    private static final Consumer<List<DeepAsyncResponse<SecurityEvent>>> SECURITY_EVENT_CONSUMER = System.out::println;

    private void securityEventSseRequestBuilder() {
        final SseRequest<List<DeepAsyncResponse<SecurityEvent>>> request = new SecurityEventSseRequestBuilder()
                .withSymbol("IBM")
                .build();

        cloudClient.subscribe(request, SECURITY_EVENT_CONSUMER);
    }

    private static final Consumer<List<DeepAsyncResponse<Trade>>> TRADE_BREAK_CONSUMER = System.out::println;

    private void tradeBreakSseRequestSample() {
        final SseRequest<List<DeepAsyncResponse<Trade>>> request = new TradeBreaksSseRequestBuilder()
                .withSymbol("IBM")
                .build();

        cloudClient.subscribe(request, TRADE_BREAK_CONSUMER);
    }

    private static final Consumer<List<DeepAsyncResponse<Trade>>> TRADES_CONSUMER = System.out::println;

    private void tradesSseRequestSample() {
        final SseRequest<List<DeepAsyncResponse<Trade>>> request = new TradesSseRequestBuilder()
                .withSymbol("IBM")
                .build();

        cloudClient.subscribe(request, TRADES_CONSUMER);
    }

    private static final Consumer<List<DeepAsyncResponse<Book>>> BOOK_CONSUMER = System.out::println;

    private void bookSseRequestSample() {
        final SseRequest<List<DeepAsyncResponse<Book>>> request = new BookSseRequestBuilder()
                .withSymbol("IBM")
                .build();

        cloudClient.subscribe(request, BOOK_CONSUMER);
    }

    private static final Consumer<List<DeepAsyncResponse<SystemEvent>>> SYSTEM_EVENT_CONSUMER = System.out::println;

    private void systemEventSseRequestSample() {
        final SseRequest<List<DeepAsyncResponse<SystemEvent>>> request = new SystemEventSseRequestBuilder()
                .withSymbol("IBM")
                .build();

        cloudClient.subscribe(request, SYSTEM_EVENT_CONSUMER);
    }

    private static final Consumer<List<DeepAsyncResponse<DeepResult>>> DEEP_ASYNC_RESPONSE_CONSUMER = System.out::println;

    private void deepSseRequestSample() {
        final SseRequest<List<DeepAsyncResponse<DeepResult>>> request = new DeepSseRequestBuilder()
                .withSymbol("IBM")
                .build();

        cloudClient.subscribe(request, DEEP_ASYNC_RESPONSE_CONSUMER);
    }

    private void deepSseRequestWithAdapterSample() {
        final SseRequest<List<DeepAsyncResponse<DeepResult>>> request = new DeepSseRequestBuilder()
                .withSymbol("IBM")
                .build();

        cloudClient.subscribe(request, DEEP_ASYNC_RESPONSE_PROXY_CONSUMER);
    }

    private static final SampleDeepConsumerAdapter ADAPTER = new SampleDeepConsumerAdapter();

    private static final Consumer<List<DeepAsyncResponse<DeepResult>>> DEEP_ASYNC_RESPONSE_PROXY_CONSUMER =
            (response) -> response.forEach(ADAPTER::accept);

    private static class SampleDeepConsumerAdapter extends DeepConsumerAdapter {

        @Override
        public void acceptTradingStatus(final DeepAsyncResponse<TradingStatus> tradingStatusResponse) {
            System.out.println("TradingStatus: " + tradingStatusResponse);
        }

        @Override
        public void acceptAuction(final DeepAsyncResponse<Auction> auctionResponse) {
            System.out.println("Auction: " + auctionResponse);
        }

        @Override
        public void acceptOpHaltStatus(final DeepAsyncResponse<OpHaltStatus> opHaltStatusResponse) {
            System.out.println("OpHaltStatus: " + opHaltStatusResponse);
        }

        @Override
        public void acceptSsrStatus(final DeepAsyncResponse<SsrStatus> ssrStatusResponse) {
            System.out.println("SsrStatus: " + ssrStatusResponse);
        }

        @Override
        public void acceptSecurityEvent(final DeepAsyncResponse<SecurityEvent> securityEventResponse) {
            System.out.println("SecurityEvent: " + securityEventResponse);
        }

        @Override
        public void acceptTradeBreak(final DeepAsyncResponse<Trade> tradeBreakResponse) {
            System.out.println("TradeBreak: " + tradeBreakResponse);
        }

        @Override
        public void acceptTrades(final DeepAsyncResponse<Trade> tradesResponse) {
            System.out.println("Trades: " + tradesResponse);
        }

        @Override
        public void acceptBook(final DeepAsyncResponse<Book> bookResponse) {
            System.out.println("Book: " + bookResponse);
        }

        @Override
        public void acceptSystemEvent(final DeepAsyncResponse<SystemEvent> systemEventResponse) {
            System.out.println("SystemEvent: " + systemEventResponse);
        }
    }

}
