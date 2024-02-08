package de.fwidder.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import de.fwidder.iextrading4j.api.marketdata.SsrStatus;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequestBuilder;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class SsrStatusAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<SsrStatus>,
        SsrStatusAsyncRequestBuilder> {

    public SsrStatusAsyncRequestBuilder() {
        super.addChannel(DeepChannel.SSR_STATUS);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<SsrStatus>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<SsrStatus>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<SsrStatus>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
