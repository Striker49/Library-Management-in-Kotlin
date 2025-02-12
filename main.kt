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
                if (library.borrowBook(id))
                    println("Book was successfully borrowed!")
                else
                    println("Looks like this book has already been borrowed..!")

            }
            3 -> {
                println("ID of the book to return:")
                val id = readLine()?.toIntOrNull() ?: continue
                if (library.returnBook(id))
                    println("The book was returned successfully!")
                else
                    println("Couldn't return the book. Are you sure this book belongs here..?")
            }
            4 -> {
                println("Search (title or author):")
                val query = readLine() ?: continue
                val list = library.searchBooks(query)
                println(list.joinToString(separator = "\n"))
            }
            5 -> {
                println("List of books in this library")
                val list = library.getAllBooks()
                println(list.joinToString(separator = "\n"))
            }
            6 -> {
                println("Bye!")
                return
            }
            else -> println("Invalid option")
        }
    }
}