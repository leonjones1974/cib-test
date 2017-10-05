package uk.camsw.cib.bdd;

import cucumber.api.Transformer;
import uk.camsw.cib.Market;

public class MarketTransformer  extends Transformer<Market> {

    @Override
    public Market transform(String market) {
        return new Market(market);
    }

}
