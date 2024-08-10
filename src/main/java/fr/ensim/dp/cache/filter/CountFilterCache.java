package fr.ensim.dp.cache.filter;

import fr.ensim.dp.cache.MemoryCache;

public class CountFilterCache implements IFilterCache {
    static long countAdd, countRetreive;
    private IFilterCache next;
    @Override
    public byte[] doAdd(String key, byte[] buf) {
        countAdd++;
        if (next != null)
            return next.doAdd(key, buf);
        return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        countRetreive++;
        if (next != null)
            return next.doRetreive(key, buf);
        return buf;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        this.next = next;
        return this.next;
    }
}
