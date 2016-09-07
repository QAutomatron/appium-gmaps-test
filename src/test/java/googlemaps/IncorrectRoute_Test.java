package googlemaps;

import googlemaps.steps.MainViewSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class IncorrectRoute_Test {

    @Autowired
    protected MainViewSteps mainViewSteps;

    @Test
    public void incorrect_route() {

        // Start app
        mainViewSteps.start();
        mainViewSteps.viewShouldBeActive();

        //
        mainViewSteps.setSearchField("3544 Van Buren St, Gary, IN 46408, USA");
        mainViewSteps.submitSearch();

        // Check search field
        mainViewSteps.clickRoute();
        mainViewSteps.setStartRoute("Moscow");
        mainViewSteps.incorrectRouteMessageShouldBePresent();
    }
}
