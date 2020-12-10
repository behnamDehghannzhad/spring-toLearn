package b.dehghanezhad.springwebApp.conteroller;

import b.dehghanezhad.springwebApp.model.Author;
import b.dehghanezhad.springwebApp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping ("/authors")
    public String getAuthors(Model model) {

        String attributeName = "authors";
        Iterable<Author> allAuthors = authorRepository.findAll();
        model.addAttribute(attributeName, allAuthors);

        return attributeName;
    }
}
