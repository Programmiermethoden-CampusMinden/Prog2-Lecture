package spy;

import java.util.ArrayList;
import java.util.List;

public class WuppiWarenlager implements IWuppiWarenlager {
    List<Wuppi> lager = new ArrayList<>();

    /**
     * @inheritDoc
     */
    @Override
    public List<Wuppi> getAlleWuppis() {
        return this.lager;
    }
    /**
     * @inheritDoc
     */
    @Override
    public void addWuppi(spy.Wuppi wuppi) {
        this.lager.add(wuppi);
    }
}
