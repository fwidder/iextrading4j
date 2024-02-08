package de.fwidder.iextrading4j.client.rest.request.refdata;

import de.fwidder.iextrading4j.api.refdata.IEXNextDayExDate;
import de.fwidder.iextrading4j.client.rest.manager.RestRequest;
import de.fwidder.iextrading4j.client.rest.manager.RestRequestBuilder;
import de.fwidder.iextrading4j.client.rest.request.IEXApiRestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class IEXNextDayExDateRequestBuilder extends AbstractDailyListRequestBuilder<List<IEXNextDayExDate>, IEXNextDayExDateRequestBuilder>
        implements IEXApiRestRequest<List<IEXNextDayExDate>> {

    @Override
    public RestRequest<List<IEXNextDayExDate>> build() {
        return RestRequestBuilder.<List<IEXNextDayExDate>>builder()
                .withPath("/ref-data/daily-list/next-day-ex-date/{date}")
                .addPathParam("date", getPeriod()).get()
                .withResponse(new GenericType<List<IEXNextDayExDate>>() {
                })
                .build();
    }

}
