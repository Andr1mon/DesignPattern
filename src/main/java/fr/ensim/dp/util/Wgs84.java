package fr.ensim.dp.util;

/**
 * @author Denis Apparicio 
 * 
 */
public final class Wgs84 {

  /**
   * 
   */
  private Wgs84() {
  }

  /**
   * Calcule la distance entre deux points.
   * 
   * @param lat1
   * @param lon1
   * @param lat2
   * @param lon2
   * @return la distance entre deux points en m&ecirc;tre.
   */
  public static double computeWsg84(double lat1,
                                    double lon1,
                                    double lat2,
                                    double lon2) {
    double val;
    double distance = 0;

    double p = Math.PI / 180;
    double lat1p = lat1 * p;
    double lon1p = lon1 * p;
    double lat2p = lat2 * p;
    double lon2p = lon2 * p;

    val = Math.cos(lat2p) * Math.cos(lat1p) * Math.cos(lon1p - lon2p)
          + Math.sin(lat2p) * Math.sin(lat1p);

    if (val > 1) {
      val = 1;
    }
    else if (val < -1) {
      val = -1;
    }
    distance = 6378137 * Math.acos(val);
    return distance;
  }
}
