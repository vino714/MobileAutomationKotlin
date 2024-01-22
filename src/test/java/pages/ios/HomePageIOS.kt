package pages.ios

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import core.utils.ElementHelpers
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.HomePage
import java.util.logging.Logger

class HomePageIOS : HomePage {
    private val log: Logger = Logger.getLogger(HomePageIOS::class.java.name)
    private val homeSearchBar: SelenideElement = `$`(By.id("search_bar_text_view"))


    @Step("Opened Home Page")
    override fun isOpen(): Boolean {
        log.info("Opened Home Page")
        return homeSearchBar.shouldBe(Condition.visible).exists()
    }

    override fun tapSearchBar() {
        ElementHelpers().tap(homeSearchBar)
    }
}