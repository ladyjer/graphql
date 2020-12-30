package eu.ladyj.service;

import eu.ladyj.model.Useless;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaginatedUselessRepository extends PagingAndSortingRepository<Useless, Integer> {
    Page<Useless> findAll(Pageable pageable);
}
