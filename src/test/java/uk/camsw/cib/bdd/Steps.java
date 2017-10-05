package uk.camsw.cib.bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.camsw.cib.Instrument;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {

    private final World world;

    public Steps(World world) {
        this.world = world;
    }

    @Given("^the LME instrument (.+):$")
    public void theLmeInstruments(String code, List<InstrumentRefDataCto> instruments) {
        instruments.stream()
                .limit(1)
                .map(x -> x.toLme(code))
                .forEach(world::enqueInbound);
    }

    @When("^LME publishes instrument (.+)$")
    public void lmePublishesInstrument(String code) {
        world.publishInboundLme(code);
    }

    @Then("^the application publishes nothing internally$")
    public void theApplicationPublishesNothing() {
        assertThat(world.publisher.published).isEmpty();
    }

    @Then("^the application publishes the following instruments? internally:")
    public void theApplicationPublishes(List<InstrumentCto> instruments) {
        List<Instrument> expected = instruments.stream()
                .map(InstrumentCto::toInstrument)
                .collect(Collectors.toList());
        assertThat(world.publisher.published).isEqualTo(expected);

    }


}
