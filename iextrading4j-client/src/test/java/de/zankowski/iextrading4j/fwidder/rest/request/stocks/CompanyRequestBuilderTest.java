package de.fwidder.iextrading4j.client.rest.request.stocks;

import org.junit.jupiter.api.Test;
import de.fwidder.iextrading4j.api.stocks.Company;
import de.fwidder.iextrading4j.client.rest.manager.MethodType;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class CompanyRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final RestRequest<Company> request = new CompanyRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/company");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Company>() {});
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

}