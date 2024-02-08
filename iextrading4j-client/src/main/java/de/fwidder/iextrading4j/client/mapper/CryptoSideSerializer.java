package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.alternative.CryptoSide;

import static de.fwidder.iextrading4j.client.mapper.CryptoSideDeserializer.CRYPTO_SIDE_MAPPER;

public class CryptoSideSerializer extends AbstractEnumSerializer<CryptoSide> {

    CryptoSideSerializer() {
        super(CRYPTO_SIDE_MAPPER.inverse(), null);
    }
}
