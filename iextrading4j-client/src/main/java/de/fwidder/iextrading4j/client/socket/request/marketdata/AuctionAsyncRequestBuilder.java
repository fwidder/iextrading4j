package de.fwidder.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import de.fwidder.iextrading4j.api.marketdata.Auction;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequestBuilder;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class AuctionAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<Auction>,
        AuctionAsyncRequestBuilder> {

    public AuctionAsyncRequestBuilder() {
        super.addChannel(DeepChannel.AUCTION);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<Auction>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<Auction>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<Auction>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
