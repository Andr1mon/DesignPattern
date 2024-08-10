package fr.ensim.dp.cache.filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountFilterCacheTest {

    @Test
    void doCount() {
        CountFilterCache filterCache = new CountFilterCache();
        assertEquals(0, filterCache.countAdd);
        assertEquals(0, filterCache.countRetreive);
        byte[] b = {1,2,3,4};
        filterCache.doAdd("1234", b);
        filterCache.doAdd("123", b);
        filterCache.doRetreive("123", b);
        assertEquals(2, filterCache.countAdd);
        assertEquals(1, filterCache.countRetreive);
    }
}