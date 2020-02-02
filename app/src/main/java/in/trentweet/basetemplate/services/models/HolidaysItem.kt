package `in`.trentweet.basetemplate.services.models


data class HolidaysItem(
    val date: Date? = null,
    val name: String? = null,
    val description: String? = null,
    val locations: String? = null,
    val type: List<String?>? = null,
    val states: String? = null
)
