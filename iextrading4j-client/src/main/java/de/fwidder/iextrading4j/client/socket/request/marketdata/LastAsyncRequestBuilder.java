package de.fwidder.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import de.fwidder.iextrading4j.api.marketdata.LastTrade;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequestBuilder;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class LastAsyncRequestBuilder extends AbstractSymbolAsyncRequestBuilder<LastTrade, LastAsyncRequestBuilder> {

    @Override
    public SocketRequest<LastTrade> build() {
        return SocketRequestBuilder.<LastTrade>builder()
                .withPath("/last")
                .withResponse(new TypeReference<LastTrade>() {})
                .withParam(getSymbol())
                .build();
    }
}
