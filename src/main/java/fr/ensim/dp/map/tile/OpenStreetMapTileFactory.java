package fr.ensim.dp.map.tile;

import org.jdesktop.swingx.mapviewer.AbstractTileFactory;

/**
 * @author Denis Apparicio
 * 
 */
public final class OpenStreetMapTileFactory extends AbstractTileFactory {
	// mapnik
	private static final String MAPNIK = "mapnik";

	private static final String MAPNIK_URL = "http://tile.openstreetmap.org";

	// OSM France
	private static final String OSM_FRANCE = "OSM France";

	private static final String OSM_FRANCE_URL = "http://a.tile.openstreetmap.fr/osmfr";

	// OpenTopoMap
	private static final String OPEN_TOMAP = "Transport OpenPtMap";

	private static final String OPEN_TOMAP_URL = "https://a.tile.opentopomap.org";

	private static final String[] TILE_NAMES = { MAPNIK, OSM_FRANCE, OPEN_TOMAP };

	private OpenStreetMapTileFactory(OpenStreetMapTileProviderInfo tileProviderInfo) {
		super(tileProviderInfo);
		// TODO valoriser Le DiskCache adpator
		// methode void
		// org.jdesktop.swingx.mapviewer.AbstractTileFactory.setTileCache(TileCache
		// cache)
		// setTileCache(disk cache adaptor);
	}

	/**
	 * @param name
	 * @return
	 */
	public static AbstractTileFactory getTileFactory(String name) {
		if (MAPNIK.equals(name)) {
			return createMap(MAPNIK_URL, MAPNIK);
		}
		if (OSM_FRANCE.equals(name)) {
			return createMap(OSM_FRANCE_URL, OSM_FRANCE);
		}
		if (OPEN_TOMAP.equals(name)) {
			return createMap(OPEN_TOMAP_URL, OPEN_TOMAP);
		}

		throw new IllegalArgumentException("Tile inconnu " + name);
	}

	/**
	 * 
	 * @return Restitue la map Mapnik
	 */
	private static AbstractTileFactory createMap(String url, String name) {
		OpenStreetMapTileProviderInfo info = new OpenStreetMapTileProviderInfo(url, name);
		return new OpenStreetMapTileFactory(info);
	}

	/**
	 * Restitue les noms des maps.
	 * 
	 * @return les noms des maps
	 */
	public static String[] getTileNames() {
		return TILE_NAMES;
	}
}
