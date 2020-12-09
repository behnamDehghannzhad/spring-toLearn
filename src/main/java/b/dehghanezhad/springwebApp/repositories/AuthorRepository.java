package b.dehghanezhad.springwebApp.repositories;

import b.dehghanezhad.springwebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
