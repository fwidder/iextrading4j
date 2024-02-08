package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.refdata.DelistingReason;

import static de.fwidder.iextrading4j.client.mapper.DelistingReasonDeserializer.DELISTING_REASON_MAPPER;

class DelistingReasonSerializer extends AbstractEnumSerializer<DelistingReason> {

    DelistingReasonSerializer() {
        super(DELISTING_REASON_MAPPER.inverse(), DelistingReason.UNKNOWN);
    }
}
