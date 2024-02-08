package de.fwidder.iextrading4j.client.sse.request.marketdata;

import de.fwidder.iextrading4j.api.marketdata.SsrStatus;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class SsrStatusSseRequestBuilder extends AbstractDeepSseRequestBuilder<List<DeepAsyncResponse<SsrStatus>>,
        SsrStatusSseRequestBuilder> {

    public SsrStatusSseRequestBuilder() {
        this.addChannel(DeepChannel.SSR_STATUS);
    }

    @Override
    public SseRequest<List<DeepAsyncResponse<SsrStatus>>> build() {
        return SseRequestBuilder.<List<DeepAsyncResponse<SsrStatus>>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<List<DeepAsyncResponse<SsrStatus>>>() {
                })
                .addQueryParam(CHANNEL_PARAM, getChannels())
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }
}
