package fr.ensim.dp.cache;

/**
 * @author Denis Apparicio
 *
 */
public interface ICache {

  /**
   * @return Restitue la taille du cache
   */
  long size();

  /**
   * Ajoute un tableau de byte dans le cache.
   * 
   * @param key
   *          clé du buffer à mettre en cache.
   * @param buf
   *          le buffer à mettre en cache.
   * @return <code>true</code> si la mise en cache a réussi,
   *         <code>false</code> sinon.
   */
  boolean add(String key, byte[] buf);

  /**
   * Restitue le buffer en cache.
   * 
   * @param key
   *          clé du buffer recherchée;
   * @return le buffer en cache ou <code>null</code> si pas de cache
   *         trouvé pour cette clé
   */
  byte[] retreive(String key);

  /**
   * Efface le cache.
   */
  void clear();


}
