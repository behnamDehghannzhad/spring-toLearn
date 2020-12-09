package b.dehghanezhad.springwebApp.repositories;

import b.dehghanezhad.springwebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
