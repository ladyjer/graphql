package eu.ladyj.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import eu.ladyj.model.Useless;
import eu.ladyj.service.PaginatedUselessRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UselessQueryResolver implements GraphQLQueryResolver {
    public final PaginatedUselessRepository repository;

    public UselessQueryResolver(PaginatedUselessRepository repository) {
        this.repository = repository;
    }

    public List<Useless> getRecentUseless(int count, int offset) {
        Page<Useless> page = repository.findAll(PageRequest.of(offset, count));

        return IteratorUtils.toList(page.iterator());
    }
}
