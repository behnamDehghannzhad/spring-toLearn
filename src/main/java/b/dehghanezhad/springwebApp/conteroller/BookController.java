package b.dehghanezhad.springwebApp.conteroller;

import b.dehghanezhad.springwebApp.model.Book;
import b.dehghanezhad.springwebApp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        String attributeName = "books";
        Iterable<Book> AllBooks = bookRepository.findAll();
        model.addAttribute(attributeName, AllBooks);

        return attributeName;
    }
}
