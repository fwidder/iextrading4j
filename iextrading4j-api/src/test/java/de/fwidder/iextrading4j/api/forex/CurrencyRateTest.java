package de.fwidder.iextrading4j.api.forex;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyRateTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final BigDecimal rate = fixture.create(BigDecimal.class);
        final Long timestamp = fixture.create(Long.class);
        final Boolean isDerived = fixture.create(Boolean.class);

        final CurrencyRate currencyConversion = new CurrencyRate(symbol, rate,
                timestamp, isDerived);

        assertThat(currencyConversion.getSymbol()).isEqualTo(symbol);
        assertThat(currencyConversion.getRate()).isEqualTo(rate);
        assertThat(currencyConversion.getTimestamp()).isEqualTo(timestamp);
        assertThat(currencyConversion.isDerived()).isEqualTo(isDerived);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(CurrencyRate.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CurrencyRate.class))
                .verify();
    }
}
