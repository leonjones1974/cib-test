package uk.camsw.cib.bdd;

import cucumber.api.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {

    private final World world;

    public Steps(World world) {
        this.world = world;
    }

    @Then("the application publishes nothing internally")
    public void theApplicationPublishesNothing() {
        assertThat(world.publisher.published).isEmpty();
    }


}
