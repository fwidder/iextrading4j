package de.fwidder.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

class SecurityEventTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final SecurityEventType securityEventType = fixture.create(SecurityEventType.class);
        final Long timestamp = fixture.create(Long.class);

        final SecurityEvent securityEvent = new SecurityEvent(securityEventType, timestamp);

        assertThat(securityEvent.getSecurityEvent()).isEqualTo(securityEventType);
        assertThat(securityEvent.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(SecurityEvent.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(SecurityEvent.class))
                .verify();
    }

}
