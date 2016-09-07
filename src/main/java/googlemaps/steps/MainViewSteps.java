package googlemaps.steps;

import googlemaps.views.MainView;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Steps for Main View
 */
@Component
public class MainViewSteps {

    private static final Logger LOGGER = Logger.getLogger(MainViewSteps.class.getName());

    @Autowired
    private MainView mainView;

    @Step
    public void tapSearchField() {
        LOGGER.info("Step start: Tap on Search Field");
        mainView.tapOnSearchField();

    }

    @Step
    public void setSearchField(String s) {
        LOGGER.info("Step start: set search field");
        mainView.setSearchField(s);
    }

    @Step
    public void submitSearch() {
        LOGGER.info("Step start: submit search");
        mainView.submit();
    }

    @Step
    public void viewShouldBeActive() {
        LOGGER.info("Step start: main map should be present");
        assertTrue("Main Map should be present",
                mainView.isMainMapPresent());
    }

    @Step
    public void searchFieldShouldBePresent() {
        LOGGER.info("Step start: search field should be present");
        assertTrue("Search Field should be present",
                mainView.isSearchFieldPresent());
    }

    @Step
    public void searchFieldShouldNotBePresent() {
        LOGGER.info("Step start: search field should not be present");
        assertTrue("Search Field should be present",
                mainView.isSearchFieldNotPresent());
    }

    @Step
    public void tapPlace() {
        LOGGER.info("Step start: tap on place");
        mainView.tapOnPlace();
    }

    @Step
    public void placeHeaderShouldBePresent() {
        LOGGER.info("Step start: place view should be active");
        assertTrue("Place view should be active",
                mainView.isPlaceHeaderPresent());
    }

    @Step
    public void placeShouldBeSameAs(String s) {
        LOGGER.info("Step start: place name should be same as");
        assertEquals(s,
                mainView.getPlaceHeader());
    }

    @Step
    public void stopDriver() {
        mainView.stop();
    }

    @Step
    public void tapExploreFoodAndDrinks() {
        LOGGER.info("Step start: tap Explore");
        mainView.tapExploreFoodAndDrinksButton();
    }

    @Step
    public void makeItCheapFrameShouldBePresent() {
        LOGGER.info("Step start: make it cheap should be present");
        assertTrue("<Make it cheap> frame should be present",
                mainView.isMakeItCheapFramePresent());
    }

    @Step
    public void placeCategoryMenuShouldBePresent() {
        LOGGER.info("Step start: place category menu should be present");
        assertTrue("Category menu should be present",
                mainView.isCategoryMenuPresent());
    }

    @Step
    public void tapOnMapBottom() {
        LOGGER.info("Step start: tap on map");
        mainView.tapOnMapBottom();
    }

    @Step
    public void tapOnMap() {
        LOGGER.info("Step start: tap on map");
        mainView.tapOnMap();
    }

    @Step
    public void start() {
        mainView.start();
    }

    @Step
    public void clickRoute() {
        LOGGER.info("Step start: click Route");
        mainView.clickRouteButton();
    }

    @Step
    public void setStartRoute(String s) {
        LOGGER.info("Step start: set start point");
        mainView.tapStartPointField();
        mainView.setField(s);
        mainView.submit();
    }

    @Step
    public void incorrectRouteMessageShouldBePresent() {
        LOGGER.info("Step start: click Route");
        assertTrue("<Incorrect Route> error should be present",
                mainView.isIncorrectRouteMessagePresent());
    }
}
