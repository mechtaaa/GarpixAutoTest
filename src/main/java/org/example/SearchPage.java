package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    SelenideElement search = $(By.xpath("//button[@aria-label='Поиск']"));
    SelenideElement searchVisible = $(By.xpath("//input[@class='_search__input_1csk7_40']"));
    SelenideElement object = $(By.xpath("//button[text()='Объекты']"));
    ElementsCollection collectionListResponse = $$(By.xpath("//ul[@class='_results__list_1csk7_55']"));
    SelenideElement generalInformation = $(By.xpath("//span[text()='Общая информация']"));

    public void scenario() {
        //Нажать на поле поиска
        search.click();
        //Инпут поиска работает
        searchVisible.shouldBe(focused);
        //Переключиться на Объекты
        object.click();
        //Переключение на Объекты работает
        object.shouldHave(cssValue("background-color", "rgba(0, 74, 165, 1)"));
        //Ввести в поле поиска символы (прим. Новоталицкое сельское поселение)
        searchVisible.val("Новоталицкое сельское поселение");
        //Ввод символов в строку поиска работает
        searchVisible.shouldHave(value("Новоталицкое сельское поселение"));
        //Получить результаты поиска
        searchVisible.pressEnter();
        //Результаты поиска получены
        collectionListResponse.shouldHave(sizeGreaterThan(0));
        //Нажать на объект в результатах поиска
        collectionListResponse.first().click();
        //Происходит переход на детальную страницу объекта
        generalInformation.shouldBe(visible);
    }
}