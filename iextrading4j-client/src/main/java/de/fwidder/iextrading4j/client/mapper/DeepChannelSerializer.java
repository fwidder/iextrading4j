package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

import static de.fwidder.iextrading4j.client.mapper.DeepChannelDeserializer.DEEP_CHANNEL_MAPPER;

class DeepChannelSerializer extends AbstractEnumSerializer<DeepChannel> {

    DeepChannelSerializer() {
        super(DEEP_CHANNEL_MAPPER.inverse(), DeepChannel.UNKNOWN);
    }
}
