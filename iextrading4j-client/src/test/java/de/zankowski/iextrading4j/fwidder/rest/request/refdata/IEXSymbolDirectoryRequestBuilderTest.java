package de.fwidder.iextrading4j.client.rest.request.refdata;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.refdata.IEXSymbolDirectory;
import de.fwidder.iextrading4j.client.rest.manager.MethodType;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class IEXSymbolDirectoryRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final LocalDate date = LocalDate.of(2017, 5, 5);

        final RestRequest<List<IEXSymbolDirectory>> request = new IEXSymbolDirectoryRequestBuilder()
                .withDate(date)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/ref-data/daily-list/symbol-directory/{date}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<IEXSymbolDirectory>>() {});
        assertThat(request.getPathParams()).contains(entry("date", "20170505"));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
