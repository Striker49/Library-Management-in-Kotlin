fun main() {
    val library = Library()

    println("=== Library Management System ===")

    while (true) {
        println("\nSelect an option:")
        println("1. Add a book")
        println("2. Borrow a book")
        println("3. Return a book")
        println("4. Search for a book")
        println("5. List all books")
        println("6. Leave")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("Book Title")
                val title = readLine() ?: continue
                println("Author")
                val author = readLine() ?: continue
                println("Year")
                val year = readLine()?.toIntOrNull() ?: continue
                val book = library.addBook(title, author, year)
                println("The book \"${book.title}\" was added with ID: ${book.id}")
            }
            2 -> {
                    println("ID of the book to borrow:")
                    val id = readLine()?.toIntOrNull() ?: continue
                    library.borrowBook(id)
            }
            3 -> {
                    println("ID of the book to return:")
                    val id = readLine()?.toIntOrNull() ?: continue
                    library.returnBook(id)
            }
            4 -> {
                println("Search (title or author):")
                val query = readLine() ?: continue
                val list = library.searchBooks(query)
                if (list.isNotEmpty())
                    println(list.joinToString(separator = "\n"))
                else
                    println("No results found for \'$query\'..!")
            }
            5 -> {
                println("List of books in this library")
                val list = library.getAllBooks()
                if (list.isNotEmpty())
                    println(list.joinToString(separator = "\n"))
                else
                    println("No books added to this library yet..!")
            }
            6 -> {
                println("Bye!")
                return
            }
            else -> println("Invalid option")
        }
    }
}