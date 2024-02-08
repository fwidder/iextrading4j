package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.refdata.ListingCenter;

import static de.fwidder.iextrading4j.client.mapper.ListingCenterDeserializer.LISTING_CENTER_MAPPER;

class ListingCenterSerializer extends AbstractEnumSerializer<ListingCenter> {

    ListingCenterSerializer() {
        super(LISTING_CENTER_MAPPER.inverse(), ListingCenter.UNKNOWN);
    }

}
