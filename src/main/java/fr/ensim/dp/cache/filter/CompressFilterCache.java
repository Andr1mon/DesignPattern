package fr.ensim.dp.cache.filter;

import fr.ensim.dp.util.GzipUtil;

import java.io.IOException;

public class CompressFilterCache implements IFilterCache {
    private IFilterCache next;
    @Override
    public byte[] doAdd(String key, byte[] buf) {
        try {
            if (next != null)
                return next.doAdd(key, GzipUtil.compress(buf));
            return GzipUtil.compress(buf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        try {
            if (next != null)
                return next.doAdd(key, GzipUtil.uncompress(buf));
            return GzipUtil.uncompress(buf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        this.next = next;
        return this.next;
    }
}
