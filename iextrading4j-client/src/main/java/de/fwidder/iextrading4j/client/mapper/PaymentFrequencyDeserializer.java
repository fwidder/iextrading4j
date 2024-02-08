package de.fwidder.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import de.fwidder.iextrading4j.api.refdata.PaymentFrequency;

import static de.fwidder.iextrading4j.api.refdata.PaymentFrequency.ANNUAL;
import static de.fwidder.iextrading4j.api.refdata.PaymentFrequency.IRREGULAR;
import static de.fwidder.iextrading4j.api.refdata.PaymentFrequency.MONTHLY;
import static de.fwidder.iextrading4j.api.refdata.PaymentFrequency.NOT_AVAILABLE;
import static de.fwidder.iextrading4j.api.refdata.PaymentFrequency.ONE_TIME;
import static de.fwidder.iextrading4j.api.refdata.PaymentFrequency.QUARTERLY;
import static de.fwidder.iextrading4j.api.refdata.PaymentFrequency.SEMI_ANNUAL;

class PaymentFrequencyDeserializer extends AbstractEnumDeserializer<PaymentFrequency> {

    static final BiMap<String, PaymentFrequency> PAYMENT_FREQUENCY_MAPPER = ImmutableBiMap.<String, PaymentFrequency>builder()
            .put("I", IRREGULAR)
            .put("M", MONTHLY)
            .put("Q", QUARTERLY)
            .put("S", SEMI_ANNUAL)
            .put("A", ANNUAL)
            .put("O", ONE_TIME)
            .put("", NOT_AVAILABLE)
            .build();

    PaymentFrequencyDeserializer() {
        super(PAYMENT_FREQUENCY_MAPPER, PaymentFrequency.UNKNOWN);
    }

}
