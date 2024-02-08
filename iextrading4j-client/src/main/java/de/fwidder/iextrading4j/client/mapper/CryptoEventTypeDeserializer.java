package de.fwidder.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import de.fwidder.iextrading4j.api.alternative.CryptoEventType;

import static de.fwidder.iextrading4j.api.alternative.CryptoEventType.AUCTION;
import static de.fwidder.iextrading4j.api.alternative.CryptoEventType.BLOCK_TRADE;
import static de.fwidder.iextrading4j.api.alternative.CryptoEventType.CHANGE;
import static de.fwidder.iextrading4j.api.alternative.CryptoEventType.TRADE;

public class CryptoEventTypeDeserializer extends AbstractEnumDeserializer<CryptoEventType> {

    static final BiMap<String, CryptoEventType> CRYPTO_EVENT_TYPE_MAPPER = ImmutableBiMap.<String, CryptoEventType>builder()
            .put("change", CHANGE)
            .put("trade", TRADE)
            .put("block_trade", BLOCK_TRADE)
            .put("auction", AUCTION)
            .build();

    CryptoEventTypeDeserializer() {
        super(CRYPTO_EVENT_TYPE_MAPPER, null);
    }

}
