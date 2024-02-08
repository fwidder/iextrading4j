package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.refdata.FinancialStatus;

import static de.fwidder.iextrading4j.client.mapper.FinancialStatusDeserializer.FINANCIAL_STATUS_MAPPER;

class FinancialStatusSerializer extends AbstractEnumSerializer<FinancialStatus> {

    FinancialStatusSerializer() {
        super(FINANCIAL_STATUS_MAPPER.inverse(), FinancialStatus.UNKNOWN);
    }
}
