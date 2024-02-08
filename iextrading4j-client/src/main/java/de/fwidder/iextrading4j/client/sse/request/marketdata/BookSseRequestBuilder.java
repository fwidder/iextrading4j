package de.fwidder.iextrading4j.client.sse.request.marketdata;

import de.fwidder.iextrading4j.api.marketdata.Book;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import de.fwidder.iextrading4j.client.sse.manager.SseRequest;
import de.fwidder.iextrading4j.client.sse.manager.SseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class BookSseRequestBuilder extends AbstractDeepSseRequestBuilder<List<DeepAsyncResponse<Book>>,
        BookSseRequestBuilder> {

    public BookSseRequestBuilder() {
        this.addChannel(DeepChannel.BOOK);
    }

    @Override
    public SseRequest<List<DeepAsyncResponse<Book>>> build() {
        return SseRequestBuilder.<List<DeepAsyncResponse<Book>>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<List<DeepAsyncResponse<Book>>>() {
                })
                .addQueryParam(CHANNEL_PARAM, getChannels())
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
