package de.fwidder.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import de.fwidder.iextrading4j.api.refdata.LuldTier;

import static de.fwidder.iextrading4j.api.refdata.LuldTier.NOT_APPLICABLE;
import static de.fwidder.iextrading4j.api.refdata.LuldTier.NOT_AVAILABLE;
import static de.fwidder.iextrading4j.api.refdata.LuldTier.TIER_1_NMS_STOCKS;
import static de.fwidder.iextrading4j.api.refdata.LuldTier.TIER_2_NMS_STOCKS;

class LuldTierDeserializer extends AbstractEnumDeserializer<LuldTier> {

    static final BiMap<String, LuldTier> LULD_TIER_MAPPER = ImmutableBiMap.<String, LuldTier>builder()
            .put("0", NOT_APPLICABLE)
            .put("1", TIER_1_NMS_STOCKS)
            .put("2", TIER_2_NMS_STOCKS)
            .put("", NOT_AVAILABLE)
            .build();

    LuldTierDeserializer() {
        super(LULD_TIER_MAPPER, LuldTier.UNKNOWN);
    }

}
