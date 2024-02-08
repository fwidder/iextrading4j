package de.fwidder.iextrading4j.client.sse.request.marketdata;

import de.fwidder.iextrading4j.api.marketdata.DeepResult;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class DeepSseRequestBuilder extends AbstractDeepSseRequestBuilder<List<DeepAsyncResponse<DeepResult>>,
        DeepSseRequestBuilder> {

    public DeepSseRequestBuilder() {
        this.addChannel(DeepChannel.DEEP);
    }

    @Override
    public SseRequest<List<DeepAsyncResponse<DeepResult>>> build() {
        return SseRequestBuilder.<List<DeepAsyncResponse<DeepResult>>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<List<DeepAsyncResponse<DeepResult>>>() {})
                .addQueryParam(CHANNEL_PARAM, getChannels())
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}

