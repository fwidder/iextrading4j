package de.fwidder.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IncomeStatementsTest {


    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final List<IncomeStatement> statements = Lists.newArrayList(fixture.collections().createCollection(IncomeStatement.class));

        final IncomeStatements incomeStatements = new IncomeStatements(symbol, statements);

        assertThat(incomeStatements.getSymbol()).isEqualTo(symbol);
        assertThat(incomeStatements.getIncome()).isEqualTo(statements);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(IncomeStatements.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(IncomeStatements.class))
                .verify();
    }


}
