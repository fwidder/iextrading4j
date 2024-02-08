package de.fwidder.iextrading4j.client.mapper;

import de.fwidder.iextrading4j.api.refdata.IssueSubType;

import static de.fwidder.iextrading4j.client.mapper.IssueSubTypeDeserializer.ISSUE_SUB_TYPE_MAPPER;

class IssueSubTypeSerializer extends AbstractEnumSerializer<IssueSubType> {

    IssueSubTypeSerializer() {
        super(ISSUE_SUB_TYPE_MAPPER.inverse(), IssueSubType.UNKNOWN);
    }

}
