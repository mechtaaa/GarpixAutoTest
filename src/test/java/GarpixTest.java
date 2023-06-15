import org.example.BasePage;
import org.example.SearchPage;
import org.testng.annotations.Test;

public class GarpixTest extends BasePage {
    SearchPage searchPage = new SearchPage();

    @Test
    public void startTest() {
        searchPage.scenario();
    }
}