package de.fwidder.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import de.fwidder.iextrading4j.api.refdata.DividendTypeId;

import static de.fwidder.iextrading4j.api.refdata.DividendTypeId.CASH_DIVIDEND;
import static de.fwidder.iextrading4j.api.refdata.DividendTypeId.CASH_STOCK_DIVIDEND;
import static de.fwidder.iextrading4j.api.refdata.DividendTypeId.FORWARD_SPLIT;
import static de.fwidder.iextrading4j.api.refdata.DividendTypeId.OTHER;
import static de.fwidder.iextrading4j.api.refdata.DividendTypeId.REVERSE_SPLIT;
import static de.fwidder.iextrading4j.api.refdata.DividendTypeId.RIGHTS_DISTRIBUTION;
import static de.fwidder.iextrading4j.api.refdata.DividendTypeId.SPECIAL_DIVIDEND;
import static de.fwidder.iextrading4j.api.refdata.DividendTypeId.SPIN_OFF;
import static de.fwidder.iextrading4j.api.refdata.DividendTypeId.STOCK_DIVIDEND;
import static de.fwidder.iextrading4j.api.refdata.DividendTypeId.STOCK_DIVIDEND_PAYABLE_IN_ANOTHER_COMPANY;
import static de.fwidder.iextrading4j.api.refdata.DividendTypeId.WARRANTS_DISTRIBUTION;

class DividendTypeIdDeserializer extends AbstractEnumDeserializer<DividendTypeId> {

    static final BiMap<String, DividendTypeId> DIVIDEND_TYPE_ID_MAPPER = ImmutableBiMap.<String, DividendTypeId>builder()
            .put("CP", STOCK_DIVIDEND_PAYABLE_IN_ANOTHER_COMPANY)
            .put("CS", CASH_STOCK_DIVIDEND)
            .put("FS", FORWARD_SPLIT)
            .put("RS", REVERSE_SPLIT)
            .put("SD", SPECIAL_DIVIDEND)
            .put("SO", SPIN_OFF)
            .put("XC", CASH_DIVIDEND)
            .put("XR", RIGHTS_DISTRIBUTION)
            .put("XS", STOCK_DIVIDEND)
            .put("XW", WARRANTS_DISTRIBUTION)
            .put("XX", OTHER)
            .build();

    DividendTypeIdDeserializer() {
        super(DIVIDEND_TYPE_ID_MAPPER, DividendTypeId.UNKNOWN);
    }
}
