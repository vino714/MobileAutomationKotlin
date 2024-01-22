package pages.ios

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import core.utils.ElementHelpers
import org.openqa.selenium.By
import pages.SearchPage
import java.util.logging.Logger

class SearchPageIOS : SearchPage {

    private val log: Logger = Logger.getLogger(SearchPageIOS::class.java.name)
    private val txtHomeSearchBar: SelenideElement = Selenide.`$`(By.xpath("//XCUIElementTypeOther"))
    private val selectSearchContent: String = "//XCUIElementTypeOther[contains(@text,\"%s\")]"
    private val btnBack: SelenideElement = Selenide.`$`(By.xpath("//XCUIElementTypeOther[@content-desc=\"Navigate up\"]"))

    override fun isOpen(): Boolean {
        log.info("Opened Search page")
        return txtHomeSearchBar.shouldBe(Condition.visible).exists()
    }

    override fun typeSearchContent(searchText: String) {
        ElementHelpers().typeText(txtHomeSearchBar,searchText)
    }

    override fun clickSearchContent(searchText: String) {
        val selectSearchContentElement: SelenideElement =
            Selenide.`$`(By.xpath(java.lang.String.format(selectSearchContent, searchText)))
        ElementHelpers().tap(selectSearchContentElement)
    }

    override fun searchFor(searchText: String) {
        typeSearchContent(searchText)
        clickSearchContent(searchText)
    }

    override fun goBack() {
        ElementHelpers().tap(btnBack)
    }
}