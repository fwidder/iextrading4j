package de.fwidder.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import de.fwidder.iextrading4j.api.marketdata.SecurityEvent;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequestBuilder;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class SecurityEventAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<SecurityEvent>,
        SecurityEventAsyncRequestBuilder> {

    public SecurityEventAsyncRequestBuilder() {
        super.addChannel(DeepChannel.SECURITY_EVENT);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<SecurityEvent>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<SecurityEvent>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<SecurityEvent>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
