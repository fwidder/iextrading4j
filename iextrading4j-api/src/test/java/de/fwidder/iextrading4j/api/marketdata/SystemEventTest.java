package de.fwidder.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

class SystemEventTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final SystemEventType systemEventType = fixture.create(SystemEventType.class);
        final Long timestamp = fixture.create(Long.class);

        final SystemEvent systemEvent = new SystemEvent(systemEventType, timestamp);

        assertThat(systemEvent.getSystemEvent()).isEqualTo(systemEventType);
        assertThat(systemEvent.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(SystemEvent.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(SystemEvent.class))
                .verify();
    }

}
