class Library {
    private val books = mutableListOf<Book>()
    private var lastId = 0

    fun addBook(title: String, author: String, year: Int): Book {
        val book = Book(++lastId, title, author, year)
        books.add(book)
        return (book)
    }

    fun borrowBook(id: Int): Boolean {
        if (books.isEmpty() || id < 1 || id - 1 !in books.indices)
            return (false)
        if (books[id - 1].isAvailable) {
            books[id - 1].isAvailable = false
            return (true)
        }
        println("books indices: ${books.indices}")
        return (false)
    }

    fun returnBook(id: Int): Boolean {
        if (books.isEmpty() || id < 1 || id - 1 !in books.indices)
            return (false)
        if (!books[id - 1].isAvailable) {
            books[id - 1].isAvailable = true
            return (true)
        }
        return (false)
    }

    fun searchBooks(query: String): List<Book> {
        val list = books.filter {
            it.title.contains(query, ignoreCase = true) ||
            it.author.contains(query, ignoreCase = true)
        }
        return (list)
    }

    fun getAllBooks(): List<Book> = books.toList()
}