package de.fwidder.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import de.fwidder.iextrading4j.api.refdata.QualifiedDividendType;

import static de.fwidder.iextrading4j.api.refdata.QualifiedDividendType.NOT_AVAILABLE;
import static de.fwidder.iextrading4j.api.refdata.QualifiedDividendType.NOT_QUALIFIED;
import static de.fwidder.iextrading4j.api.refdata.QualifiedDividendType.NO_AFFIRMATION;
import static de.fwidder.iextrading4j.api.refdata.QualifiedDividendType.QUALIFIED;

class QualifiedDividendTypeDeserializer extends AbstractEnumDeserializer<QualifiedDividendType> {

    static final BiMap<String, QualifiedDividendType> QUALIFIED_DIVIDEND_TYPE_MAPPER = ImmutableBiMap.<String, QualifiedDividendType>builder()
            .put("Y", QUALIFIED)
            .put("N", NOT_QUALIFIED)
            .put("U", NO_AFFIRMATION)
            .put("", NOT_AVAILABLE)
            .build();

    QualifiedDividendTypeDeserializer() {
        super(QUALIFIED_DIVIDEND_TYPE_MAPPER, QualifiedDividendType.UNKNOWN);
    }

}
