package de.fwidder.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import de.fwidder.iextrading4j.api.marketdata.Trade;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequestBuilder;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class TradeBreakAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<Trade>,
        TradeBreakAsyncRequestBuilder> {

    public TradeBreakAsyncRequestBuilder() {
        super.addChannel(DeepChannel.TRADE_BREAK);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<Trade>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<Trade>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<Trade>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
