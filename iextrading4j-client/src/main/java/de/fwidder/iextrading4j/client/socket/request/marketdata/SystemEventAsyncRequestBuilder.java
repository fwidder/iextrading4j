package de.fwidder.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import de.fwidder.iextrading4j.api.marketdata.SystemEvent;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequestBuilder;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class SystemEventAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<SystemEvent>,
        SystemEventAsyncRequestBuilder> {

    public SystemEventAsyncRequestBuilder() {
        super.addChannel(DeepChannel.SYSTEM_EVENT);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<SystemEvent>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<SystemEvent>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<SystemEvent>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
