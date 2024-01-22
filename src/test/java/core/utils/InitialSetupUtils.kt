package core.utils

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import core.constants.Constants.Companion.IS_ANDROID
import org.openqa.selenium.By
import java.util.logging.Logger

class InitialSetupUtils {
    private val log: Logger = Logger.getLogger(InitialSetupUtils::class.java.name)

    private var btnGetStarted: SelenideElement = Selenide.`$`(By.id("action_button_text"))
    private var btnContinue: SelenideElement = Selenide.`$`(By.id("action_button_text"))
    private var txtRecommended: SelenideElement = Selenide.`$`(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"))
    private var btnContinueWithFav: SelenideElement = Selenide.`$`(By.id("action_button_text"))
    private var btnMayBeLater: SelenideElement = Selenide.`$`(By.id("btn_disallow"))
    private var btnDone: SelenideElement = Selenide.`$`(By.id("action_button_text"))
    private var btnAllow: SelenideElement = Selenide.`$`(By.xpath(".//android.widget.Button[@text='Allow']"))
    private var btnClose: SelenideElement = Selenide.`$`(By.id("dismiss_modal"))

    fun freshInstallApp(){
        if(IS_ANDROID) {
            if(btnAllow.isDisplayed) {
                btnAllow.click()
            }
            ElementHelpers().tap(btnGetStarted)
            btnContinue.click()
            btnMayBeLater.click()
            txtRecommended.click()
            btnContinueWithFav.click()
            btnDone.click()
            btnClose.click()
        }
    }
}