package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.alternative.CryptoEventReason;

import static de.fwidder.iextrading4j.client.mapper.CryptoEventReasonDeserializer.CRYPTO_EVENT_REASON_MAPPER;

public class CryptoEventReasonSerializer extends AbstractEnumSerializer<CryptoEventReason> {

    CryptoEventReasonSerializer() {
        super(CRYPTO_EVENT_REASON_MAPPER.inverse(), null);
    }
}
