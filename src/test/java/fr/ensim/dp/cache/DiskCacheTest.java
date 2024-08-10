package fr.ensim.dp.cache;

import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiskCacheTest {
	@Test
	public void testSize() {
		MemoryCache memoryCache;
		DiskCache mapnik = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\mapnik");
		DiskCache osm = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\osm");
        DiskCache transport = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\transport");
        byte[] b1 = {1,2,3,4};
		byte[] b2 = {9,8,7,6,5};
		mapnik.add("key1", b1);
		mapnik.add("key2", b2);
		osm.add("key1", b1);
		osm.add("key2", b2);
		transport.add("key1", b1);
		transport.add("key2", b2);

		assertEquals(2, mapnik.size());
		assertEquals(2, osm.size());
		assertEquals(2, transport.size());
	}

	@Test
	public void testAll() {
		// cle
		// Size vaut0
		// byte [] b = {12,2 ,3} ,
		// add("key1", b)
		// Size vaut 3
	}

	@Test
	public void testSingleton() {
		DiskCache mapnik1 = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\mapnik");
		DiskCache osm1 = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\osm");
		DiskCache transport1 = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\transport");
		DiskCache mapnik2 = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\mapnik");
		DiskCache osm2 = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\osm");
		DiskCache transport2 = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\transport");

		assertEquals(mapnik1, mapnik2);
		assertEquals(osm1, osm2);
		assertEquals(transport1, transport2);
		assertEquals(mapnik1, osm1);
	}

	@Test
	public void testRetreive() throws IOException {
		DiskCache mapnik = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\mapnik");
		DiskCache osm = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\osm");
		DiskCache transport = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\transport");
		byte[] b1 = {1,2,3,4};
		byte[] b2 = {9,8,7,6,5};
		mapnik.add("key1", b1);
		mapnik.add("key2", b2);
		osm.add("key1", b1);
		osm.add("key2", b2);
		transport.add("key1", b1);
		transport.add("key2", b2);

		assertEquals(b1.length, mapnik.retreive("key1").length);
		assertEquals(b2.length, mapnik.retreive("key2").length);
		assertEquals(b1[0], mapnik.retreive("key1")[0]);
		assertEquals(b2[0], mapnik.retreive("key2")[0]);
		assertEquals(b1.length, osm.retreive("key1").length);
		assertEquals(b2.length, osm.retreive("key2").length);
		assertEquals(b1[0], osm.retreive("key1")[0]);
		assertEquals(b2[0], osm.retreive("key2")[0]);
		assertEquals(b1.length, transport.retreive("key1").length);
		assertEquals(b2.length, transport.retreive("key2").length);
		assertEquals(b1[0], transport.retreive("key1")[0]);
		assertEquals(b2[0], transport.retreive("key2")[0]);
	}

	@Test
	public void testClear() {
		DiskCache mapnik = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\mapnik");
		DiskCache osm = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\osm");
		DiskCache transport = DiskCache.getCache("H:\\Home\\Bureau\\4A\\S8\\Design Pattern\\tp1v3-dp-squelette-maven\\tp1v3-dp-squelette-maven\\DiskCache\\transport");

		mapnik.clear();
		osm.clear();
		transport.clear();

		assertEquals(0,mapnik.size());
		assertEquals(0,osm.size());
		assertEquals(0,transport.size());
	}

}