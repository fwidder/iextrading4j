package de.fwidder.iextrading4j.client.socket.request.marketdata;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.marketdata.Auction;
import de.fwidder.iextrading4j.client.socket.manager.SocketRequest;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncRequest;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

import static org.assertj.core.api.Assertions.assertThat;

class AuctionAsyncRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final SocketRequest<DeepAsyncResponse<Auction>> request = new AuctionAsyncRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/deep");

        final DeepAsyncRequest param = (DeepAsyncRequest) request.getParam();
        assertThat(param.getSymbols()).containsExactly(symbol);
        assertThat(param.getChannels()).containsExactly(DeepChannel.AUCTION);
    }

}
