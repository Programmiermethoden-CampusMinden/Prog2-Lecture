package mock;

import java.util.List;

/**
 * Über unsere brandheißen WuppiStores verkaufen wir dann alle Wuppis aus dem Wuppi-Warenlager (wenn
 * es mal fertiggestellt ist).
 */
public class WuppiStore {

    public IWuppiWarenlager lager;

    public WuppiStore(IWuppiWarenlager lager) {
        this.lager = lager;
    }

    /**
     * Bestellt alle Wuppis aus dem angegebenen Warenlager
     *
     * @param lager Das Lager, aus dem die Wuppis geordert werden.
     * @return Eine Liste mit allen Wuppis, die bestellt wurden.
     */
    public List<String> bestelleAlleWuppis(IWuppiWarenlager lager) {
        return lager.getAlleWuppis();
    }
}
