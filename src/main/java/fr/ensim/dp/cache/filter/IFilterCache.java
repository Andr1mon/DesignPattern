package fr.ensim.dp.cache.filter;

/**
 * Chain of responsbility
 */
public interface IFilterCache {

  /**
   * @param key
   * @param buf
   */
  byte[] doAdd(String key, byte[] buf);

  /**
   * @param key
   * @return <code>true</code>, s'il ne faut pas appele de suivant.
   */
  byte[] doRetreive(String key, byte[] buf);
  
  
  public IFilterCache setNext(IFilterCache next);

}
