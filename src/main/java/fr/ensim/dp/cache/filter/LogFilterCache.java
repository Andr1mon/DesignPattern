package fr.ensim.dp.cache.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogFilterCache implements IFilterCache {
    private static Logger log = LogManager.getLogger();
    private IFilterCache next;
    @Override
    public byte[] doAdd(String key, byte[] buf) {
        if (next != null) {
            if (log.isDebugEnabled()) {
                log.debug(">>return next.doAdd(key, buf)");
            }
            return next.doAdd(key, buf);
        }
        if (log.isDebugEnabled()) {
            log.debug(">>return doAdd: First element and Last element of buffer ["+buf[0]+", "+buf[buf.length-1]+"]");
        }
        return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        if (next != null) {
            if (log.isDebugEnabled()) {
                log.debug("<<return next.doRetreive(key, buf)");
            }
            return next.doRetreive(key, buf);
        }
        if (log.isDebugEnabled()) {
            log.debug("<<return doRetreive: First element and Last element of buffer ["+buf[0]+", "+buf[buf.length-1]+"]");
        }
        return buf;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        this.next = next;
        return this.next;
    }
}
