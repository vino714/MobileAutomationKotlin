package pages

interface PlayerPage:BaseContentPage {
    fun verifyPlayerName(teamName: String)
    fun goToInfoTab()
    fun verifySelectedTabIsEnabled(tab: String)
}