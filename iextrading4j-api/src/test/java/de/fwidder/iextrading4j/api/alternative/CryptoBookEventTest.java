package de.fwidder.iextrading4j.api.alternative;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.marketdata.BookEntry;
import de.fwidder.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CryptoBookEventTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final List<BookEntry> asks = Lists.newArrayList(fixture.collections()
                .createCollection(BookEntry.class));
        final List<BookEntry> bids = Lists.newArrayList(fixture.collections()
                .createCollection(BookEntry.class));
        final String symbol = fixture.create(String.class);

        final CryptoBookEvent book = new CryptoBookEvent(bids, asks, symbol);

        assertThat(book.getAsk()).isEqualTo(asks);
        assertThat(book.getBid()).isEqualTo(bids);
        assertThat(book.getSymbol()).isEqualTo(symbol);
    }


    @Test
    void equalsContract() {
        EqualsVerifier.forClass(CryptoBookEvent.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CryptoBookEvent.class))
                .verify();
    }

}
