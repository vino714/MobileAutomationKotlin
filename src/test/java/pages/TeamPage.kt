package pages

interface TeamPage:BaseContentPage {
    fun verifyTeamName(teamName: String)
    fun goToInfoTab()
    fun goToTeamStatTab()
    fun verifySelectedTabIsEnabled(tab: String)
}