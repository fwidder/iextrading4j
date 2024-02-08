package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.refdata.DividendTypeId;

import static de.fwidder.iextrading4j.client.mapper.DividendTypeIdDeserializer.DIVIDEND_TYPE_ID_MAPPER;

class DividendTypeIdSerializer extends AbstractEnumSerializer<DividendTypeId> {

    DividendTypeIdSerializer() {
        super(DIVIDEND_TYPE_ID_MAPPER.inverse(), DividendTypeId.UNKNOWN);
    }
}
