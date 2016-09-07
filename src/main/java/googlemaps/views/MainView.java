package googlemaps.views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.stereotype.Component;

/**
 * Main View
 */
@Component
public class MainView extends View {

    @AndroidFindBy(id = "com.google.android.apps.maps:id/search_omnibox_text_box")
    private MobileElement searchField;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/mainmap_container")
    private MobileElement mainMap;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/home_bottom_sheet_container")
    private MobileElement bottomContainer;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/recycler_view")
    private MobileElement placeInfo;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/header")
    private MobileElement placeHeader;

    @AndroidFindBy(xpath = "//*[@resource-id='com.google.android.apps.maps:id/recycler_view']//android.widget.TextView")
    private MobileElement placeHeaderText;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/placepage_directions_button")
    private MobileElement routeButton;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.TextView[@text='Explore food & drinks here']")
    private MobileElement exploreFoodAndDrinksButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[.//android.widget.TextView[@text='Make it cheap']]")
    private MobileElement makeItCheapFrame;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView")
    private MobileElement horizontalCategoryMenu;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/directions_startpoint_textbox")
    private MobileElement startPointField;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/search_omnibox_edit_text")
    private MobileElement field;

    @AndroidFindBy(xpath = "//*[@resource-id='com.google.android.apps.maps:id/directions_trip_cardlist']//android.widget.TextView[@text='No route found']")
    private MobileElement incorrectRoute;

    public void tapOnSearchField() {
        searchField.tap(1,1);
    }

    public void setSearchField(String s) {
        searchField.sendKeys(s);
    }

    public boolean isMainMapPresent() {
        return waitForElementPresent(mainMap);
    }

    public boolean isSearchFieldPresent() {
        return waitForElementPresent(searchField);
    }

    public boolean isSearchFieldNotPresent() {
        return waitForElementNotPresent(searchField);
    }

    public void tapOnPlace() {
        placeInfo.tap(1,1);
    }

    public boolean isPlaceHeaderPresent() {
        return waitForElementPresent(placeHeader);
    }

    public String getPlaceHeader() {
        return placeHeaderText.getText();
    }

    public void tapExploreFoodAndDrinksButton() {
        exploreFoodAndDrinksButton.tap(1,1);
    }

    public boolean isMakeItCheapFramePresent() {
        return waitForElementPresent(makeItCheapFrame);
    }

    public boolean isCategoryMenuPresent() {
        return waitForElementPresent(horizontalCategoryMenu);
    }

    public void tapOnMapBottom() {
        bottomContainer.tap(1,1);
    }

    public void tapOnMap() {
        mainMap.tap(1,1);
    }

    public void clickRouteButton() {
        routeButton.click();
    }

    public void setField(String s) {
        field.sendKeys(s);
    }

    public boolean isIncorrectRouteMessagePresent() {
        return waitForElementPresent(incorrectRoute);
    }

    public boolean startPointFieldShouldBePresent() {
        return waitForElementPresent(startPointField);
    }

    public void tapStartPointField() {
        startPointField.tap(1,1);
    }
}

