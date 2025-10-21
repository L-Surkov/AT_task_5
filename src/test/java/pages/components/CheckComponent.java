package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckComponent {
    private SelenideElement modalHeader = $(".modal-content #example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive");

    public CheckComponent checkModalIsOpen() {
        modalHeader.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public CheckComponent checkModalIsNotOpen() {
        modalHeader.shouldNotBe(visible);
        return this;
    }

    public CheckComponent checkResult(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}
