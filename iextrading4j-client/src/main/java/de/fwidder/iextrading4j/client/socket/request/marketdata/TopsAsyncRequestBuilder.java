package de.fwidder.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import de.fwidder.iextrading4j.api.marketdata.TOPS;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequestBuilder;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class TopsAsyncRequestBuilder extends AbstractSymbolAsyncRequestBuilder<TOPS, TopsAsyncRequestBuilder> {

    @Override
    public SocketRequest<TOPS> build() {
        return SocketRequestBuilder.<TOPS>builder()
                .withPath("/tops")
                .withResponse(new TypeReference<TOPS>() {})
                .withParam(getSymbol())
                .build();
    }
}
