package fr.ensim.dp.util;

/**
 * @author Denis Apparicio 
 * 
 */
public class ProxyConfiguration {

  /**
   * Configuration du proxy.
   */
  public static void configure() {
    System.setProperty("http.proxyHost", "proxy.univ-lemans.fr");
    System.setProperty("http.proxyPort", "3128");
  }
}
