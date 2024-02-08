package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.refdata.PaymentFrequency;

import static de.fwidder.iextrading4j.client.mapper.PaymentFrequencyDeserializer.PAYMENT_FREQUENCY_MAPPER;

class PaymentFrequencySerializer extends AbstractEnumSerializer<PaymentFrequency> {

    PaymentFrequencySerializer() {
        super(PAYMENT_FREQUENCY_MAPPER.inverse(), PaymentFrequency.UNKNOWN);
    }

}
