package de.fwidder.iextrading4j.sample.iexcloud.rest;

import de.fwidder.iextrading4j.api.options.Option;
import de.fwidder.iextrading4j.client.IEXCloudClient;
import de.fwidder.iextrading4j.client.IEXCloudTokenBuilder;
import de.fwidder.iextrading4j.client.IEXTradingApiVersion;
import de.fwidder.iextrading4j.client.IEXTradingClient;
import de.fwidder.iextrading4j.client.rest.request.options.OptionSide;
import de.fwidder.iextrading4j.client.rest.request.options.OptionsRequestBuilder;

import java.util.List;

public class OptionsSample {

    final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) {
        final OptionsSample optionsSample = new OptionsSample();

        optionsSample.optionsRequestSample();
        optionsSample.optionsWithExpirationDateRequestSample();
        optionsSample.optionsWithExpirationDateAndSideRequestSample();
    }

    private void optionsRequestSample() {
        final List<String> result = cloudClient.executeRequest(new OptionsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(result);
    }

    private void optionsWithExpirationDateRequestSample() {
        final List<Option> result = cloudClient.executeRequest(new OptionsRequestBuilder()
                .withSymbol("AAPL")
                .withExpirationDate("201906")
                .build());
        System.out.println(result);
    }

    private void optionsWithExpirationDateAndSideRequestSample() {
        final List<Option> result = cloudClient.executeRequest(new OptionsRequestBuilder()
                .withSymbol("AAPL")
                .withExpirationDate("201906")
                .withSide(OptionSide.CALL)
                .build());
        System.out.println(result);
    }

}
