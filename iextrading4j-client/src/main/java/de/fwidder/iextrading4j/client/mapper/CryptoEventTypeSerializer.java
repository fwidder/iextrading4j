package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.alternative.CryptoEventType;

import static de.fwidder.iextrading4j.client.mapper.CryptoEventTypeDeserializer.CRYPTO_EVENT_TYPE_MAPPER;

public class CryptoEventTypeSerializer extends AbstractEnumSerializer<CryptoEventType> {

    CryptoEventTypeSerializer() {
        super(CRYPTO_EVENT_TYPE_MAPPER.inverse(), null);
    }
}
