package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingProductPage extends BasePage{

    HomePage homePage = new HomePage();

    public By drop_down = By.xpath("//select[@class='product_sort_container']");
    public By product_prices = By.className("inventory_item_price");
    public By product_names = By.className("inventory_item_name");

    public void NavigateHomeForSorting(String user, String pass){
        homePage.loadHomePage(user, pass);
    }

    public void sortBy(String sortingOption) {
        HandleDropdown(drop_down, sortingOption);
    }

    public ArrayList<Double> fetchProductPrices() {
        List<WebElement> priceElements = getElements(product_prices);
        ArrayList<Double> prices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            prices.add(Double.parseDouble(priceElement.getText().replace("$", ""))); // Remove $ and convert to Double
        }
        return prices;
    }

    public ArrayList<String> fetchProductNames() {
        List<WebElement> nameElements = getElements(product_names);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement nameElement : nameElements) {
            names.add(nameElement.getText());
        }
        return names;
    }

    public boolean isSortedByPriceLowToHigh() {
        ArrayList<Double> actualPrices = fetchProductPrices();
        ArrayList<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);
        return actualPrices.equals(expectedPrices);
    }

    public boolean isSortedByPriceHighToLow() {
        ArrayList<Double> actualPrices = fetchProductPrices();
        ArrayList<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Collections.reverseOrder());
        return actualPrices.equals(expectedPrices);
    }

    public boolean isSortedByNameAToZ() {
        ArrayList<String> actualNames = fetchProductNames();
        ArrayList<String> expectedNames = new ArrayList<>(actualNames);
        expectedNames.sort(String.CASE_INSENSITIVE_ORDER);
        return actualNames.equals(expectedNames);
    }

    public boolean isSortedByNameZToA() {
        ArrayList<String> actualNames = fetchProductNames();
        ArrayList<String> expectedNames = new ArrayList<>(actualNames);
        expectedNames.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        return actualNames.equals(expectedNames);
    }
}
