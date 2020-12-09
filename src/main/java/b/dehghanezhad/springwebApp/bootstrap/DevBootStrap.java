package b.dehghanezhad.springwebApp.bootstrap;

import b.dehghanezhad.springwebApp.model.Author;
import b.dehghanezhad.springwebApp.model.Book;
import b.dehghanezhad.springwebApp.repositories.AuthorRepository;
import b.dehghanezhad.springwebApp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        addData();
    }

    private void addData() {
        Author behnam = new Author();
        behnam.setFirstName("behnam");
        behnam.setLastName("dehghannezhad");

        Book myBook = new Book();
        myBook.setTitle("hamine ke hast");
        myBook.setIsbn("2563");
        myBook.setPublisher("behshad company");

        myBook.getAuthors().add(behnam);
        behnam.getBooks().add(myBook);

        authorRepository.save(behnam);
        bookRepository.save(myBook);
    }
}
