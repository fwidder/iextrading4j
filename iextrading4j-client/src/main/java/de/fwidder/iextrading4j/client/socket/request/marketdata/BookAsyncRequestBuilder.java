package de.fwidder.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import de.fwidder.iextrading4j.api.marketdata.Book;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequestBuilder;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class BookAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<Book>,
        BookAsyncRequestBuilder> {

    public BookAsyncRequestBuilder() {
        super.addChannel(DeepChannel.BOOK);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<Book>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<Book>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<Book>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
