package fr.ensim.dp.cache.filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogFilterCacheTest {

    @Test
    void doAdd() {
        IFilterCache filterCache = new LogFilterCache();
        byte[] b = {1,2,3,4};
        filterCache.doAdd("", b);
    }

    @Test
    void doRetreive() {
        IFilterCache filterCache = new LogFilterCache();
        byte[] b = {1,2,3,4};
        filterCache.doRetreive("", b);
    }
}