package de.fwidder.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import de.fwidder.iextrading4j.api.refdata.DelistingReason;

import static de.fwidder.iextrading4j.api.refdata.DelistingReason.ACQUISTION_MERGER;
import static de.fwidder.iextrading4j.api.refdata.DelistingReason.ADR_PROGRAM_TERMINATION;
import static de.fwidder.iextrading4j.api.refdata.DelistingReason.CALLED_FOR_REDEMPTION;
import static de.fwidder.iextrading4j.api.refdata.DelistingReason.COMPANY_CHOICE_MATTER_PENDING;
import static de.fwidder.iextrading4j.api.refdata.DelistingReason.COMPANY_CHOICE_REORGANZATION_PENDING;
import static de.fwidder.iextrading4j.api.refdata.DelistingReason.CORPORATE_REORGANIZATION;
import static de.fwidder.iextrading4j.api.refdata.DelistingReason.EXPIRATION;
import static de.fwidder.iextrading4j.api.refdata.DelistingReason.FORM_15;
import static de.fwidder.iextrading4j.api.refdata.DelistingReason.LIQUIDATION;
import static de.fwidder.iextrading4j.api.refdata.DelistingReason.LISTED_ON_ANOTHER_MARKET;
import static de.fwidder.iextrading4j.api.refdata.DelistingReason.MATURITY;
import static de.fwidder.iextrading4j.api.refdata.DelistingReason.NOT_DELISTED;
import static de.fwidder.iextrading4j.api.refdata.DelistingReason.OTHER;
import static de.fwidder.iextrading4j.api.refdata.DelistingReason.REGULATORY;
import static de.fwidder.iextrading4j.api.refdata.DelistingReason.REMOVED_FROM_LISTING;

class DelistingReasonDeserializer extends AbstractEnumDeserializer<DelistingReason> {

    static final BiMap<String, DelistingReason> DELISTING_REASON_MAPPER = ImmutableBiMap.<String, DelistingReason>builder()
            .put("AM", ACQUISTION_MERGER)
            .put("AT", ADR_PROGRAM_TERMINATION)
            .put("CR", CALLED_FOR_REDEMPTION)
            .put("RE", COMPANY_CHOICE_REORGANZATION_PENDING)
            .put("RM", COMPANY_CHOICE_MATTER_PENDING)
            .put("RG", CORPORATE_REORGANIZATION)
            .put("EX", EXPIRATION)
            .put("FF", FORM_15)
            .put("LQ", LIQUIDATION)
            .put("LM", LISTED_ON_ANOTHER_MARKET)
            .put("MA", MATURITY)
            .put("OT", OTHER)
            .put("NC", REGULATORY)
            .put("RL", REMOVED_FROM_LISTING)
            .put("", NOT_DELISTED)
            .build();

    DelistingReasonDeserializer() {
        super(DELISTING_REASON_MAPPER, DelistingReason.UNKNOWN);
    }
}
