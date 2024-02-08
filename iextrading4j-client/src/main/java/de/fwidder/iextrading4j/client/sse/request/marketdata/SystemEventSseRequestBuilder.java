package de.fwidder.iextrading4j.client.sse.request.marketdata;

import de.fwidder.iextrading4j.api.marketdata.SystemEvent;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class SystemEventSseRequestBuilder extends AbstractDeepSseRequestBuilder<List<DeepAsyncResponse<SystemEvent>>,
        SystemEventSseRequestBuilder> {

    public SystemEventSseRequestBuilder() {
        this.addChannel(DeepChannel.SYSTEM_EVENT);
    }

    @Override
    public SseRequest<List<DeepAsyncResponse<SystemEvent>>> build() {
        return SseRequestBuilder.<List<DeepAsyncResponse<SystemEvent>>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<List<DeepAsyncResponse<SystemEvent>>>() {
                })
                .addQueryParam(CHANNEL_PARAM, getChannels())
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}