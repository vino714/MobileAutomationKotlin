package pages.android

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import core.utils.ElementHelpers
import io.qameta.allure.Step
import org.assertj.core.api.Assertions
import org.openqa.selenium.By
import pages.TeamPage
import pages.android.tabs.InfoTabAndroid
import pages.android.tabs.TeamStatsTabAndroid
import java.util.logging.Logger

class TeamPageAndroid : TeamPage {

    private val log: Logger = Logger.getLogger(TeamPageAndroid::class.java.name)
    private val txtNewsTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"News\"]/android.widget.TextView"))
    private val txtScheduleTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"Schedule\"]/android.widget.TextView"))
    private val txtInfoTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"Info\"]/android.widget.TextView"))
    private val txtTeamStatTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"Team Stats\"]/android.widget.TextView"))
    private val txtTeamName: SelenideElement = `$`(By.id("team_name"))
    private val btnBack: SelenideElement = `$`(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"))
    private var teamInfoTab = InfoTabAndroid()
    private var teamStatTab = TeamStatsTabAndroid()

    @Step("Team page is opened")
    override fun isOpen(): Boolean {
        log.info("Team page is opened")
        return txtTeamName.shouldBe(Condition.visible).exists()
    }

    @Step("Go back to previous page")
    override fun goBack() {
       ElementHelpers().tap(btnBack)
    }

    @Step("Get Title name")
    override fun getTitleName(): String {
        log.info("Getting Team Name text")
        return txtTeamName.text
    }

    @Step("Verify Team name")
    override  fun verifyTeamName(teamName: String){
        log.info("Validate Team Name")
        Assertions.assertThat(teamName == getTitleName())
    }

    @Step("Goto Info tab")
    override fun goToInfoTab(){
        ElementHelpers().tap(txtInfoTab)
    }

    @Step("Goto Team Stats tab")
    override fun goToTeamStatTab(){
        ElementHelpers().tap(txtTeamStatTab)
    }

    @Step("Verify Selected tab is enabled")
    override fun verifySelectedTabIsEnabled(tab: String){
        if(tab=="Info"){
            Assertions.assertThat(teamInfoTab.isOpen())
        }
        else if(tab=="Team Stats") {
            Assertions.assertThat(teamStatTab.isOpen())
        }
    }
}