package fr.ensim.dp.cache.filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompressFilterCacheTest {

    @Test
    void doAddRetreive() {
        IFilterCache FilterCache = new CompressFilterCache();
        byte[] b = {1,2,3,4};
        byte[] bCompressed = FilterCache.doAdd("", b);
        assertEquals(1, FilterCache.doRetreive("", bCompressed)[0]);
        assertEquals(4, FilterCache.doRetreive("", bCompressed)[3]);
    }

    @Test
    void doRetreive() {

    }
}