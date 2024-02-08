package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.refdata.SymbolType;

import static de.fwidder.iextrading4j.client.mapper.SymbolTypeDeserializer.SYMBOL_TYPE_MAPPER;

class SymbolTypeSerializer extends AbstractEnumSerializer<SymbolType> {

    SymbolTypeSerializer() {
        super(SYMBOL_TYPE_MAPPER.inverse(), SymbolType.UNKNOWN);
    }
}
