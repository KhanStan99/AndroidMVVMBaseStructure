package `in`.trentweet.basetemplate.services.models

data class Timezone(
    val offset: String? = null,
    val zoneoffset: Int? = null,
    val zonedst: Int? = null,
    val zonetotaloffset: Int? = null,
    val zoneabb: String? = null
)
