package de.fwidder.iextrading4j.api.stats;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class IntradayStatTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final BigDecimal value = fixture.create(BigDecimal.class);
        final Long lastUpdated = fixture.create(Long.class);

        final IntradayStat intradayStat = new IntradayStat(value, lastUpdated);

        assertThat(intradayStat.getValue()).isEqualTo(value);
        assertThat(intradayStat.getLastUpdated()).isEqualTo(lastUpdated);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(IntradayStat.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(IntradayStat.class))
                .verify();
    }

}
