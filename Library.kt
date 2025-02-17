class Library {
    private val books = mutableListOf<Book>()
    private var lastId = 0

    fun addBook(title: String, author: String, year: Int): Book {
        val book = Book(++lastId, title, author, year)
        books.add(book)
        return (book)
    }

    fun borrowBook(id: Int): Boolean {
        if (books.isEmpty() || id < 1 || id - 1 !in books.indices) {
            println("There are no books with the id ($id) in our library..!")
            return (false)
        }
        if (books[id - 1].isAvailable) {
            books[id - 1].isAvailable = false
            println("Book '${books[id - 1].title}' was successfully borrowed!")
            return (true)
        }
        println("books indices: ${books.indices}")
        println("Looks like the book '${books[id - 1].title}' has already been borrowed..!")
        return (true)
    }

    fun returnBook(id: Int): Boolean {
        if (books.isEmpty() || id < 1 || id - 1 !in books.indices) {
            println("There are no books with the id ($id) in our library..!")
            return (false)
        }
        if (!books[id - 1].isAvailable) {
            books[id - 1].isAvailable = true
            println("The book \'${books[id - 1].title}\' was returned successfully!")
            return (true)
        }
        println("Couldn't return the book. Are you sure this book belongs here..?")
        return (true)
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