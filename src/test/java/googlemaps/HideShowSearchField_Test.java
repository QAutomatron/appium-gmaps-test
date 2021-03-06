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
public class HideShowSearchField_Test {

    @Autowired
    protected MainViewSteps mainViewSteps;

    @Test
    public void hide_show_search_field() {

        // Start app
        mainViewSteps.start();
        mainViewSteps.viewShouldBeActive();

        //
        mainViewSteps.setSearchField("3544 Van Buren St, Gary, IN 46408, USA");
        mainViewSteps.submitSearch();

        // Check search field
        mainViewSteps.searchFieldShouldBePresent();

        // Tap to hide search
        mainViewSteps.tapOnMapBottom();
        mainViewSteps.searchFieldShouldNotBePresent();

        // TAp to show search
        mainViewSteps.tapOnMap();
        mainViewSteps.searchFieldShouldBePresent();
    }
}
