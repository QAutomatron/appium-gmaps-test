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
public class FindPlaces_Test {

    @Autowired
    protected MainViewSteps mainViewSteps;

    @Test
    public void find_places() {

        // Start app
        mainViewSteps.start();
        mainViewSteps.viewShouldBeActive();

        // Do search
        mainViewSteps.searchFieldShouldBePresent();
        mainViewSteps.tapSearchField();
        mainViewSteps.setSearchField("3544 Van Buren St, Gary, IN 46408, USA");
        mainViewSteps.submitSearch();

        // Open Place info
        mainViewSteps.tapPlace();
        mainViewSteps.placeHeaderShouldBePresent();
        mainViewSteps.placeShouldBeSameAs("3544 Van Buren St");

        // Open Explore
        mainViewSteps.tapExploreFoodAndDrinks();

        // Check result
        mainViewSteps.placeCategoryMenuShouldBePresent();
        mainViewSteps.makeItCheapFrameShouldBePresent();
    }
}
