package de.fwidder.iextrading4j.client.socket.request.marketdata;

import com.google.common.collect.Sets;
import de.fwidder.iextrading4j.client.socket.request.IAsyncRequestBuilder;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncRequest;
import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

import java.util.Set;

public abstract class AbstractDeepAsyncRequestBuilder<R, B extends IAsyncRequestBuilder> extends AbstractSymbolAsyncRequestBuilder<R, B> {

    private Set<DeepChannel> channels = Sets.newHashSet();

    public Set<DeepChannel> getChannels() {
        return channels;
    }

    B addChannel(final DeepChannel channel) {
        this.channels.add(channel);
        return (B) this;
    }

    protected DeepAsyncRequest getDeepParam() {
        return new DeepAsyncRequest(getSymbols(), getChannels());
    }

}
