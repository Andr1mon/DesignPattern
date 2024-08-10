package fr.ensim.dp.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryCacheTest {
	@Test
	public void testSize() {
		MemoryCache memoryCache = MemoryCache.getInstance();
		byte[] b = {12, 2, 3};
		memoryCache.add("key1", b);
		assertEquals(1, memoryCache.size());
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
		MemoryCache memoryCache1 = MemoryCache.getInstance();
		MemoryCache memoryCache2 = MemoryCache.getInstance();
		assertEquals(memoryCache1, memoryCache2);
	}

	@Test
	public void testRetreive() {
		MemoryCache memoryCache = MemoryCache.getInstance();
		byte[] b3 = {6, 7, 9};
		byte[] b4 = {2, 7, 18, 3};
		memoryCache.add("key3", b3);
		assertArrayEquals(b3, memoryCache.retreive("key3"));
		memoryCache.add("key4", b4);
		assertArrayEquals(b4, memoryCache.retreive("key4"));
		assertArrayEquals(b3, memoryCache.retreive("key3"));
	}

	@Test
	public void testClear() {
		MemoryCache memoryCache = MemoryCache.getInstance();
		byte[] b = {6, 7, 9};
		memoryCache.add("key3", b);
		memoryCache.clear();
		assertEquals(0, memoryCache.size());
	}

}
