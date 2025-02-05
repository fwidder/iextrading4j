package de.fwidder.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import de.fwidder.iextrading4j.api.stocks.v1.DirectIndirect;

import static de.fwidder.iextrading4j.api.stocks.v1.DirectIndirect.DIRECT;
import static de.fwidder.iextrading4j.api.stocks.v1.DirectIndirect.INDIRECT;

public class DirectIndirectDeserializer extends AbstractEnumDeserializer<DirectIndirect> {

    static final BiMap<String, DirectIndirect> DIRECT_INDIRECT_MAPPER = ImmutableBiMap.<String, DirectIndirect>builder()
            .put("D", DIRECT)
            .put("I", INDIRECT)
            .build();

    DirectIndirectDeserializer() {
        super(DIRECT_INDIRECT_MAPPER, null);
    }
}
