package fr.ensim.dp.cache;

import fr.ensim.dp.util.*;

import java.io.*;

import static fr.ensim.dp.util.FileUtil.*;

public class DiskCache implements ICache {
    private static final DiskCache mapnik = new DiskCache();
    private File dirMapnik = new File("H:/Home/Bureau/4A/S8/Design Pattern/tp1v3-dp-squelette-maven/tp1v3-dp-squelette-maven/temp/mapnik/");
    private static final DiskCache osm = new DiskCache();
    private File dirOSM = new File("H:/Home/Bureau/4A/S8/Design Pattern/tp1v3-dp-squelette-maven/tp1v3-dp-squelette-maven/temp/osm/");
    private static final DiskCache transport = new DiskCache();
    private File dirTransport = new File("H:/Home/Bureau/4A/S8/Design Pattern/tp1v3-dp-squelette-maven/tp1v3-dp-squelette-maven/temp/transport/");
    private String key;

    private DiskCache() {};

    public static DiskCache getInstanceMapnik() {
        return mapnik;
    }

    public static DiskCache getInstanceOSM() {
        return osm;
    }

    public static DiskCache getInstanceTransport() {
        return transport;
    }

    @Override
    public long size() {
        long lenDir = 0;
        if (this == mapnik)
            lenDir = dirLength(dirMapnik);
        else if (this == osm)
            lenDir = dirLength(dirOSM);
        else if (this == transport)
            lenDir = dirLength(dirTransport);
        return lenDir;
    }

    @Override
    public boolean add(String key, byte[] buf) {
        if (!key.equals("") || !(buf == null)) {
            if (this == mapnik)
                return copy(new ByteArrayInputStream(buf), new File (dirMapnik.getPath()+key));
            else if (this == osm)
                return copy(new ByteArrayInputStream(buf), new File (dirOSM.getPath()+key));
            else if (this == transport)
                return copy(new ByteArrayInputStream(buf), new File (dirTransport.getPath()+key));
        }
        return false;
    }

    @Override
    public byte[] retreive(String key) throws IOException {
        if (!key.equals("")) {
            if (this == mapnik)
                readFile(new File (dirMapnik.getPath()+key));
            else if (this == osm)
                readFile(new File (dirOSM.getPath()+key));
            else if (this == transport)
                readFile(new File (dirTransport.getPath()+key));
        }
        return null;
    }

    @Override
    public void clear() {
        key = "";
        if (this == mapnik)
            deleteDirectory(dirMapnik);
        else if (this == osm)
            deleteDirectory(dirOSM);
        else if (this == transport)
            deleteDirectory(dirTransport);
    }
}
