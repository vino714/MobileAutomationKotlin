package pages.android.tabs

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.tabs.TestStatTab
import java.util.logging.Logger

class TeamStatsTabAndroid : TestStatTab {
    private val log: Logger = Logger.getLogger(TeamStatsTabAndroid::class.java.name)

    private val txtTabName: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"Team Stats\"]/android.widget.TextView"))

    @Step("Verify Team Stat Tab is opened")
    override fun isOpen(): Boolean {
        log.info("Info tab is opened")
        return txtTabName.isEnabled
    }
}