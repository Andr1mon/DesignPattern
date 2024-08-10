package fr.ensim.dp.cache;

import fr.ensim.dp.util.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static fr.ensim.dp.util.FileUtil.*;

public class DiskCache implements ICache {

    private File dir;
    private static Map<String, DiskCache> map = new HashMap<>();
    private DiskCache(String dir) {
        this.dir = new File(dir);
    }
    public static DiskCache getCache(String dir) {
        if (map.containsKey(dir))
            map.put(dir, new DiskCache(dir));
        return map.get(dir);
    }

    @Override
    public long size() {
        return dirLength(new File(dir.toString()));
    }

    @Override
    public boolean add(String key, byte[] buf) {
        if (!key.equals("")){
            copy(new ByteArrayInputStream(buf), new File(dir+"\\"+key));
            return true;
        }
        return false;
    }

    @Override
    public byte[] retreive(String key) throws IOException {
        if (!key.equals(""))
            return readFile(new File(dir+"\\"+key));
        return new byte[0];
    }

    @Override
    public void clear() {
        deleteDirectory(dir);
    }
}
