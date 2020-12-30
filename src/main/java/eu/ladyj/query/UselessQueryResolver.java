package eu.ladyj.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import eu.ladyj.model.Person;
import eu.ladyj.model.Useless;
import eu.ladyj.service.PaginatedUselessRepository;
import eu.ladyj.service.PersonRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UselessQueryResolver implements GraphQLQueryResolver {
    public final PaginatedUselessRepository repository;
    public final PersonRepository personRepository;

    public UselessQueryResolver(PaginatedUselessRepository repository, PersonRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    public List<Useless> getRecentUseless(int count, int offset) {
        Page<Useless> page = repository.findAll(PageRequest.of(offset, count));

        return IteratorUtils.toList(page.iterator());
    }

    public List<Person> getPersons() {
        return IteratorUtils.toList(personRepository.findAll().iterator());
    }
}
