package fr.ensim.dp.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiskCacheTest {
	@Test
	public void testSize() {

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
		DiskCache mapnik1 = DiskCache.getInstanceMapnik();
		DiskCache osm1 = DiskCache.getInstanceOSM();
		DiskCache transport1 = DiskCache.getInstanceTransport();
		DiskCache mapnik2 = DiskCache.getInstanceMapnik();
		DiskCache osm2 = DiskCache.getInstanceOSM();
		DiskCache transport2 = DiskCache.getInstanceTransport();

		assertEquals(mapnik1, mapnik2);
		assertEquals(mapnik1, mapnik2);
		assertEquals(mapnik1, mapnik2);
	}

	@Test
	public void testRetreive() {
		DiskCache mapnik = DiskCache.getInstanceMapnik();
		DiskCache osm = DiskCache.getInstanceOSM();
		DiskCache transport = DiskCache.getInstanceTransport();
	}

	@Test
	public void testClear() {
		DiskCache mapnik = DiskCache.getInstanceMapnik();
		DiskCache osm = DiskCache.getInstanceOSM();
		DiskCache transport = DiskCache.getInstanceTransport();

		mapnik.clear();
		osm.clear();
		transport.clear();


	}

}
