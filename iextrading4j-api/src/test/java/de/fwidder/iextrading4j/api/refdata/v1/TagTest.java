package de.fwidder.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

class TagTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String name = fixture.create(String.class);

        final Tag tag = new Tag(name);

        assertThat(tag.getName()).isEqualTo(name);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Tag.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Tag.class))
                .verify();
    }

}
