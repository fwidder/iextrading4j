package de.fwidder.iextrading4j.client.sse.request.marketdata;

import de.fwidder.iextrading4j.api.marketdata.OpHaltStatus;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class OpHaltStatusSseRequestBuilder extends AbstractDeepSseRequestBuilder<List<DeepAsyncResponse<OpHaltStatus>>,
        OpHaltStatusSseRequestBuilder> {

    public OpHaltStatusSseRequestBuilder() {
        this.addChannel(DeepChannel.OP_HALT_STATUS);
    }

    @Override
    public SseRequest<List<DeepAsyncResponse<OpHaltStatus>>> build() {
        return SseRequestBuilder.<List<DeepAsyncResponse<OpHaltStatus>>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<List<DeepAsyncResponse<OpHaltStatus>>>() {})
                .addQueryParam(CHANNEL_PARAM, getChannels())
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}