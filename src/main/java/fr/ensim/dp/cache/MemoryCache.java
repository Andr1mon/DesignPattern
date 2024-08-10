package fr.ensim.dp.cache;

import java.util.HashMap;

public class MemoryCache implements ICache {
    private static MemoryCache singleton = new MemoryCache();
    private byte[] buf;
    private String key;
    private HashMap<String, byte[]> hashMap = new HashMap<>();

    private MemoryCache(){}

    public static MemoryCache getInstance(){
        return singleton;
    }

    @Override
    public long size() {
        return hashMap.size();
    }

    @Override
    public boolean add(String key, byte[] buf) {
        if (!key.equals("") && buf != null) {
            this.key = key;
            this.buf = buf;
            hashMap.put(key, buf);
            return true;
        }
        return false;
    }

    @Override
    public byte[] retreive(String key) {
        if (hashMap.containsKey(key))
            return hashMap.get(key);
        return null;
    }

    @Override
    public void clear() {
        buf = null;
        key = "";
        hashMap.clear();
    }
}
