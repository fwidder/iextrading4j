package de.fwidder.iextrading4j.client.rest.request.refdata;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.refdata.ExchangeSymbol;
import de.fwidder.iextrading4j.client.rest.manager.MethodType;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SymbolsRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final RestRequest<List<ExchangeSymbol>> request = new SymbolsRequestBuilder().build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/ref-data/symbols");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<ExchangeSymbol>>() {});
        assertThat(request.getQueryParams()).isEmpty();
    }

}
