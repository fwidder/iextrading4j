package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.refdata.QualifiedDividendType;

import static de.fwidder.iextrading4j.client.mapper.QualifiedDividendTypeDeserializer.QUALIFIED_DIVIDEND_TYPE_MAPPER;

class QualifiedDividendTypeSerializer extends AbstractEnumSerializer<QualifiedDividendType> {

    QualifiedDividendTypeSerializer() {
        super(QUALIFIED_DIVIDEND_TYPE_MAPPER.inverse(), QualifiedDividendType.UNKNOWN);
    }

}
