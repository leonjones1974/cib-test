package uk.camsw.cib.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import uk.camsw.cib.InstrumentRefData;
import uk.camsw.cib.LmeInstrumentRefData;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {

    private final World world;

    public Steps(World world) {
        this.world = world;
    }

    @Given("^the LME instrument (.+):$")
    public void theLmeInstrument(String code, List<InstrumentRefDataCto> instruments) throws Throwable {
        throw new PendingException();
    }

    @Then("^the application publishes nothing internally")
    public void theApplicationPublishesNothing() {
        assertThat(world.publisher.published).isEmpty();
    }


}
