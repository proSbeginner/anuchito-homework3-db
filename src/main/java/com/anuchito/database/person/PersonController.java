package  com.anuchito.database.person;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public List<Person> getAll() {
        return service.findAll();
    }

    @GetMapping("/{personId}")
    public Person findByPersonId(@PathVariable String personId) {
        Optional<Person> optional = service.findPersonByPersonId(personId);
        if(optional.isPresent()) return optional.get();
        return null;
    }

    @GetMapping("/loans/{loanId}")
    public Person findPersonByLoanId(@PathVariable String loanId) {
        Optional<Person> optional = service.findPeopleByLoanId(loanId);
        if(optional.isPresent()) return optional.get();
        return null;
    }
}