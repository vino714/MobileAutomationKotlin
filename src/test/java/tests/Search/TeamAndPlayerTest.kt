package tests.Search

import com.google.gson.Gson
import core.utils.JsonReader
import io.qameta.allure.Description
import io.qameta.allure.Feature
import org.assertj.core.api.Assertions
import org.testng.annotations.Test
import tests.BaseTest
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.util.logging.Logger

data class SearchData (
    @SerializedName("type") var type : String? = null,
    @SerializedName("searchText") var searchText : String? = null,
    @SerializedName("tab") var tab : String? = null
)

class TeamAndPlayerTest : BaseTest() {
    private val log: Logger = Logger.getLogger(TeamAndPlayerTest::class.java.name)

    @Test
    @Description("Test Description: Verify if user can search for League, Team, or Player Page and open sub-tab of their choice")
    @Feature("Search")
    fun teamAndPlayerTest() {
        log.info("Extract test data from JSON")
        var jsonFileString = JsonReader().getJsonDataFromAsset("src/test/java/data/TestData.json")
        var searchData: Array<SearchData> = convertJsonToSearchContent(jsonFileString)

        log.info("Iterate the test data Array and proceeding with validations")
        for(content in searchData) {
           if (pages.homePage.isOpen()) {
               pages.homePage.tapSearchBar()
           }
           Assertions.assertThat(pages.searchPage.isOpen())
           pages.searchPage.searchFor(content.searchText.toString())
            if(content.type == "Team") {
               log.info("Verifying results for search term: Team")
               pages.teamPage.verifyTeamName(content.searchText.toString())
               pages.teamPage.goToTeamStatTab()
            }else if (content.type=="Player"){
               log.info("Verifying results for search term: Player")
               pages.playerPage.verifyPlayerName(content.searchText.toString())
               pages.teamPage.goToInfoTab()
            }else if(content.type=="League"){
               log.info("Verifying results for search term: League")
                TODO()
            }
            pages.teamPage.verifySelectedTabIsEnabled(content.tab.toString())
            pages.teamPage.goBack()
            Assertions.assertThat(pages.searchPage.isOpen())
            pages.searchPage.goBack()
            Assertions.assertThat(pages.homePage.isOpen())
        }
    }

    private fun convertJsonToSearchContent(value: String?): Array<SearchData> {
        val gson = Gson()
        val searchDataType = object : TypeToken<Array<SearchData>>() {}.type
        var d: Array<SearchData> = gson.fromJson(value, searchDataType)
        return d
    }
}