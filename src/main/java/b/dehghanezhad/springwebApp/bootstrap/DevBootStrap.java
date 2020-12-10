package b.dehghanezhad.springwebApp.bootstrap;

import b.dehghanezhad.springwebApp.model.Author;
import b.dehghanezhad.springwebApp.model.Book;
import b.dehghanezhad.springwebApp.model.Publisher;
import b.dehghanezhad.springwebApp.repositories.AuthorRepository;
import b.dehghanezhad.springwebApp.repositories.BookRepository;
import b.dehghanezhad.springwebApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        addData();
    }

    private void addData() {

        Publisher publisher = new Publisher();
        publisher.setName("donyay honar");
        publisherRepository.save(publisher);

        Author behnam = new Author();
        behnam.setFirstName("behnam");
        behnam.setLastName("dehghannezhad");

        Book myBook = new Book();
        myBook.setTitle("hamine ke hast");
        myBook.setIsbn("2563");
        myBook.setPublisher(publisher);


        myBook.getAuthors().add(behnam);
        behnam.getBooks().add(myBook);

        authorRepository.save(behnam);
        bookRepository.save(myBook);
    }
}
