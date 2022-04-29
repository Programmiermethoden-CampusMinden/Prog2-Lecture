package mock;

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
    public List<String> getAlleWuppis();
}
