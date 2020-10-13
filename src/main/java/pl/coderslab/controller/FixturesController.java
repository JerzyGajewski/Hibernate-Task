package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.fixture.AuthorFixture;
import pl.coderslab.fixture.BookFixture;
import pl.coderslab.fixture.PublisherFixture;

@Controller
@RequestMapping("/fixtures")
public class FixturesController {
    private PublisherFixture publisherFixture;
    private BookFixture bookFixture;
    private AuthorFixture authorFixture;

    @Autowired
    public FixturesController(PublisherFixture publisherFixture, BookFixture bookFixture, AuthorFixture authorFixture) {
        this.publisherFixture = publisherFixture;
        this.authorFixture = authorFixture;
        this.bookFixture = bookFixture;
    }


    @GetMapping
    @ResponseBody
    public String loadAllDataToDb(){
        authorFixture.createDataInDb();
        publisherFixture.createDataInDb();
        bookFixture.createDataInDb();
        return "Data loaded";
    }
}
