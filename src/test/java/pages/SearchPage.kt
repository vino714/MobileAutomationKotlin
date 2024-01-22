package pages


interface SearchPage {
    fun isOpen(): Boolean
    fun typeSearchContent(searchText: String)
    fun clickSearchContent(searchText: String)
    fun searchFor(searchText: String)
    fun goBack()
}