package pages.android

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import core.utils.ElementHelpers
import io.qameta.allure.Step
import org.assertj.core.api.Assertions
import org.openqa.selenium.By
import pages.PlayerPage
import pages.android.tabs.InfoTabAndroid
import java.util.logging.Logger

class PlayerPageAndroid : PlayerPage {
    private val log: Logger = Logger.getLogger(PlayerPageAndroid::class.java.name)

    private val txtNewsTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"News\"]/android.widget.TextView"))
    private val txtScheduleTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"Schedule\"]/android.widget.TextView"))
    private val txtInfoTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"Info\"]/android.widget.TextView"))
    private val txtPlayerName: SelenideElement = `$`(By.id("txt_player_name"))
    private val btnBack: SelenideElement = `$`(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"))
    private var teamInfoTab = InfoTabAndroid()

    @Step("Opened Team page")
    override fun isOpen(): Boolean {
        log.info("Opened Team page")
        return txtPlayerName.shouldBe(Condition.visible).exists()
    }

    @Step("Go back to previous page")
    override fun goBack() {
       ElementHelpers().tap(btnBack)
    }

    @Step("Getting the name of Player")
    override fun getTitleName(): String {
        log.info("Getting Team Name text")
        return txtPlayerName.text
    }

    @Step("Verify the name of Player")
    override  fun verifyPlayerName(playerName: String){
        log.info("Validate Player Name")
        Assertions.assertThat(playerName == getTitleName())
    }

    @Step("Goto Info Tab")
    override fun goToInfoTab(){
        ElementHelpers().tap(txtInfoTab)
    }

    @Step("Verify Selected tab is enabled")
    override fun verifySelectedTabIsEnabled(tab: String){
        if(tab=="Info"){
            Assertions.assertThat(teamInfoTab.isOpen())
        }
    }
}