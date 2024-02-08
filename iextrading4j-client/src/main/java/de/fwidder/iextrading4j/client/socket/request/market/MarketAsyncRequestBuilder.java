package de.fwidder.iextrading4j.client.socket.request.market;

import com.fasterxml.jackson.core.type.TypeReference;
import de.fwidder.iextrading4j.api.market.MarketVolume;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequestBuilder;
import de.fwidder.iextrading4j.client.socket.request.IAsyncRequestBuilder;

import java.util.List;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class MarketAsyncRequestBuilder implements IAsyncRequestBuilder<List<MarketVolume>> {

    @Override
    public SocketRequest<List<MarketVolume>> build() {
        return SocketRequestBuilder.<List<MarketVolume>>builder()
                .withPath("/market")
                .withResponse(new TypeReference<List<MarketVolume>>() {})
                .build();
    }
}
