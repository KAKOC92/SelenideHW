import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppDeliveryAppTestOne {
    private String generateData (int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    public void PositiveTest(){
    open ("http://localhost:9999/");
    $("[data-test-id='city'] input").setValue("Воронеж");
    String Date = generateData(4,"dd.MM.yyyy");
    $("[data-test-id='date'] input").sendKeys(Keys.DELETE);
    $("[data-test-id='name'] input").setValue("Алексей Бабкин");
    $("[data-test-id='phone'] input").setValue("+79102436802");
    $("[data-test-id='agreement']").click();
    $("button.button").click();
    $("[data-test-id='notification']").shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
}
