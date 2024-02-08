package de.fwidder.iextrading4j.client.rest.request.corporate;

import de.fwidder.iextrading4j.api.corporate.AdvancedBonus;
import de.fwidder.iextrading4j.client.rest.request.datapoint.AbstractStockTimeSeriesRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class AdvancedBonusRequestBuilder extends AbstractStockTimeSeriesRequestBuilder<List<AdvancedBonus>,
        AdvancedBonusRequestBuilder> {

    public AdvancedBonusRequestBuilder() {
        super("advanced_bonus", new GenericType<List<AdvancedBonus>>() {});
    }

}
