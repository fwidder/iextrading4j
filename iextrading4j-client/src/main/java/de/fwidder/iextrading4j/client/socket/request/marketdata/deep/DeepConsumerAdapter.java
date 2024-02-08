package de.fwidder.iextrading4j.client.socket.request.marketdata.deep;

import de.fwidder.iextrading4j.api.exception.IEXTradingException;
import de.fwidder.iextrading4j.api.marketdata.Auction;
import de.fwidder.iextrading4j.api.marketdata.Book;
import de.fwidder.iextrading4j.api.marketdata.DeepResult;
import de.fwidder.iextrading4j.api.marketdata.OpHaltStatus;
import de.fwidder.iextrading4j.api.marketdata.SecurityEvent;
import de.fwidder.iextrading4j.api.marketdata.SsrStatus;
import de.fwidder.iextrading4j.api.marketdata.SystemEvent;
import de.fwidder.iextrading4j.api.marketdata.Trade;
import de.fwidder.iextrading4j.api.marketdata.TradingStatus;

import java.util.function.Consumer;

public class DeepConsumerAdapter implements Consumer<DeepAsyncResponse<DeepResult>> {

    @Override
    public final void accept(final DeepAsyncResponse deepAsyncResponse) {
        final DeepMessageType messageType = deepAsyncResponse.getMessageType();

        switch (messageType) {
            case TRADING_STATUS:
                acceptTradingStatus(deepAsyncResponse);
                break;
            case AUCTION:
                acceptAuction(deepAsyncResponse);
                break;
            case OP_HALT_STATUS:
                acceptOpHaltStatus(deepAsyncResponse);
                break;
            case SSR_STATUS:
                acceptSsrStatus(deepAsyncResponse);
                break;
            case SECURITY_EVENT:
                acceptSecurityEvent(deepAsyncResponse);
                break;
            case TRADE_BREAK:
                acceptTradeBreak(deepAsyncResponse);
                break;
            case TRADES:
                acceptTrades(deepAsyncResponse);
                break;
            case BOOK:
                acceptBook(deepAsyncResponse);
                break;
            case SYSTEM_EVENT:
                acceptSystemEvent(deepAsyncResponse);
                break;
            default:
                throw new IEXTradingException("Message type not supported: " + messageType);
        }
    }

    public void acceptTradingStatus(final DeepAsyncResponse<TradingStatus> tradingStatusResponse) {
        // empty
    }

    public void acceptAuction(final DeepAsyncResponse<Auction> auctionResponse) {
        // empty
    }

    public void acceptOpHaltStatus(final DeepAsyncResponse<OpHaltStatus> opHaltStatusResponse) {
        // empty
    }

    public void acceptSsrStatus(final DeepAsyncResponse<SsrStatus> ssrStatusResponse) {
        // empty
    }

    public void acceptSecurityEvent(final DeepAsyncResponse<SecurityEvent> securityEventResponse) {
        // empty
    }

    public void acceptTradeBreak(final DeepAsyncResponse<Trade> tradeBreakResponse) {
        // empty
    }

    public void acceptTrades(final DeepAsyncResponse<Trade> tradesResponse) {
        // empty
    }

    public void acceptBook(final DeepAsyncResponse<Book> bookResponse) {
        // empty
    }

    public void acceptSystemEvent(final DeepAsyncResponse<SystemEvent> systemEventResponse) {
        // empty
    }

}
