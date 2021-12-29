package hm2;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubCheckWiki {
    @Test
    void checkGitHubWiki(){
        // открыть страничку репозитория Селенида
        open("https://github.com/selenide/selenide");
        //Перейти в раздел Wiki
        $("[data-content='Wiki']").click();
        $(".js-wiki-more-pages-link").click();
        //Найти и нажать на страницу SoftAssertions
        $("#wiki-pages-box").$$("li a").shouldHave(itemWithText("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        //Проверить что на странице SoftAssertions есть код про junit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
