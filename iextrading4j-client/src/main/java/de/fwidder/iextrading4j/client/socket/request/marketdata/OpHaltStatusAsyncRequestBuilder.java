package de.fwidder.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import de.fwidder.iextrading4j.api.marketdata.OpHaltStatus;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequestBuilder;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class OpHaltStatusAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<OpHaltStatus>,
        OpHaltStatusAsyncRequestBuilder> {

    public OpHaltStatusAsyncRequestBuilder() {
        super.addChannel(DeepChannel.OP_HALT_STATUS);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<OpHaltStatus>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<OpHaltStatus>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<OpHaltStatus>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
