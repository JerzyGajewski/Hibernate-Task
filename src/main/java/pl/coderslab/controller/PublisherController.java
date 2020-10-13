package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.PublisherService;

import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    private PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/add")
    @ResponseBody
    public String savePublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("Goliath");

        this.publisherService.save(publisher);

        return "Publisher saved" + publisher.getId();
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Publisher findById(@PathVariable Long id){
        Publisher publisher = this.publisherService.findOneById(id);
        return publisher;
    }
    

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        Publisher publisher = this.publisherService.findOneById(id);
        this.publisherService.delete(publisher);

        return "Publisher deleted";
    }
}
