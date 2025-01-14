package de.fwidder.iextrading4j.api.util;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MapUtilTest {

    @Test
    void shouldCreateEmptyMapForNullInput() {
        final Map<String, String> result = MapUtil.immutableMap(null);

        assertThat(result).isEmpty();
    }

    @Test
    void shouldCreateImmutableMapFromMap() {
        final Map<String, String> mutableMap = new HashMap<>();

        final Map<String, String> immutableMap = MapUtil.immutableMap(mutableMap);

        assertThat(immutableMap).isInstanceOf(ImmutableMap.class);
    }

}
