package de.fwidder.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.util.ToStringVerifier;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class SymbolTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final LocalDate date = fixture.create(LocalDate.class);
        final Boolean isEnabled = fixture.create(Boolean.class);
        final String name = fixture.create(String.class);

        final Symbol symbolObject = new Symbol(symbol, date, isEnabled, name);

        assertThat(symbolObject.getSymbol()).isEqualTo(symbol);
        assertThat(symbolObject.getDate()).isEqualTo(date);
        assertThat(symbolObject.getEnabled()).isEqualTo(isEnabled);
        assertThat(symbolObject.getName()).isEqualTo(name);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Symbol.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Symbol.class))
                .verify();
    }

}
