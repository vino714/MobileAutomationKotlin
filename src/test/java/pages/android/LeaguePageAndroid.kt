package pages.android

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import core.utils.ElementHelpers
import io.qameta.allure.Step
import org.assertj.core.api.Assertions
import org.openqa.selenium.By
import pages.LeaguePage
import java.util.logging.Logger

class LeaguePageAndroid : LeaguePage {
    private val log: Logger = Logger.getLogger(LeaguePageAndroid::class.java.name)

    private val txtNewsTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"News\"]/android.widget.TextView"))
    private val txtScheduleTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"Schedule\"]/android.widget.TextView"))
    private val txtInfoTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"Info\"]/android.widget.TextView"))
    private val txtTeamName: SelenideElement = `$`(By.id("team_name"))
    private val btnBack: SelenideElement = `$`(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"))

    @Step("Opened League page")
    override fun isOpen(): Boolean {
        log.info("Opened League page")
        return txtTeamName.shouldBe(Condition.visible).exists()
    }

    @Step("Go back to previous page")
    override fun goBack() {
       ElementHelpers().tap(btnBack)
    }

    @Step("Get name of the League")
    override fun getTitleName(): String {
        log.info("Getting League Name text")
        return txtTeamName.text
    }

    @Step("Verify name of the League")
    override fun verifyLeagueName(teamName: String){
        log.info("Assert Team Name")
        Assertions.assertThat(teamName==getTitleName())
    }
}