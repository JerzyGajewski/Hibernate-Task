package pl.coderslab.fixture;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.PublisherService;

@Component
public class PublisherFixture {

    private PublisherService publisherService;
    private Faker faker;

    @Autowired
    public PublisherFixture(PublisherService publisherService) {
        this.publisherService = publisherService;
        this.faker = new Faker();
    }

    public void createDataInDb(){

        for (int i = 0; i < 3; i++) {
        Publisher publisher = new Publisher();
        publisher.setName(faker.book().publisher());
        publisherService.save(publisher);
        }
    }
}
