package spy;

import java.util.List;

/**
 * Das Warenlager für die Wuppis gibt es noch gar nicht, es befindet sich derzeit aber bereits im
 * Bau. Später sollen darüber alle Wuppis bestellt werden können.
 */
public interface IWuppiWarenlager {
    /**
     * Gibt alle im Warenlager befindlichen Wuppis als Liste zurück.
     *
     * @return Eine Liste mit Wuppis des Warenlagers.
     */
    public List<Wuppi> getAlleWuppis();

    /**
     * Fügt dem Warenlager den übergebenen Wuppi hinzu.
     *
     * @param wuppi Der Wuppi der dem Lager hinzugefügt werden soll.
     */
    public void addWuppi(Wuppi wuppi);
}
