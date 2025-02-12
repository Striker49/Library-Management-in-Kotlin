data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val year: Int,
    var isAvailable: Boolean = true
)