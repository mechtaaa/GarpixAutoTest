import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeTest;

public class BasePage {

    @BeforeTest
    public void settings() {
        open("https://qa:Q49s$2bmc$@invmap.infra.garpix.com/ru");
    }
}