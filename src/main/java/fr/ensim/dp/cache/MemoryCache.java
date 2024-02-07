package fr.ensim.dp.cache;

public class MemoryCache implements ICache {
    private static final MemoryCache singleton = new MemoryCache();
    private byte[] buf;
    private String key;

    private MemoryCache(){}

    public static MemoryCache getInstance(){
        return singleton;
    }

    @Override
    public long size() {
        if (buf == null)
            return 0;
        return buf.length;
    }

    @Override
    public boolean add(String key, byte[] buf) {
        if (!key.equals("") || !(buf == null)) {
            this.key = key;
            this.buf = buf.clone();
            return true;
        }
        return false;
    }

    @Override
    public byte[] retreive(String key) {
        if (this.key.equals(key) && !key.equals(""))
            return buf;
        return null;
    }

    @Override
    public void clear() {
        buf = new byte[0];
        key = "";
    }
}
