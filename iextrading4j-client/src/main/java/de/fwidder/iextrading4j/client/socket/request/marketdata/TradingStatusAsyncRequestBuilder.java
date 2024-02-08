package de.fwidder.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import de.fwidder.iextrading4j.api.marketdata.TradingStatus;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequestBuilder;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class TradingStatusAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<TradingStatus>,
        TradingStatusAsyncRequestBuilder> {

    public TradingStatusAsyncRequestBuilder() {
        super.addChannel(DeepChannel.TRADING_STATUS);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<TradingStatus>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<TradingStatus>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<TradingStatus>>() {})
                .withParam(getDeepParam())
                .build();
    }

}
