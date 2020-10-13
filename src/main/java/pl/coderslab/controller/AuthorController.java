package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.service.AuthorService;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping("/add")
    @ResponseBody
    public String saveAuthor(){
        Author author = new Author();
        author.setFirstName("Andrzej");
        author.setLastName("Sapkowski");

        this.authorService.save(author);

        return "Author added" + author.getId();
    }

    @PutMapping("/find/{id}")
    @ResponseBody
    public Author findById(@PathVariable Long id){
       Author author =  this.authorService.findOneById(id);

        return author;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        Author author = this.authorService.findOneById(id);

        this.authorService.delete(author);

        return "Deleted author";
    }

}

