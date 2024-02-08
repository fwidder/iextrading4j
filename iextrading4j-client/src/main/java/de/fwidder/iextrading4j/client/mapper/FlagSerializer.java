package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.refdata.Flag;

import static de.fwidder.iextrading4j.client.mapper.FlagDeserializer.FLAG_MAPPER;

class FlagSerializer extends AbstractEnumSerializer<Flag> {

    FlagSerializer() {
        super(FLAG_MAPPER.inverse(), Flag.UNKNOWN);
    }
}
