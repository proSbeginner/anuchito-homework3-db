package  com.anuchito.database.person;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Optional<Person> findPersonByPersonId(String personId) {
        return repository.findByPersonId(personId);
    }

    public Optional<Person> findPeopleByLoanId(String loanId) {
        return repository.findByLoanId(loanId);
    }
}