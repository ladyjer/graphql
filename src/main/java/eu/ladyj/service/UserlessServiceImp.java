package eu.ladyj.service;

import eu.ladyj.model.Useless;
import org.springframework.stereotype.Service;

@Service
public class UserlessServiceImp implements UselessService {
    public final UselessRepository repository;

    public UserlessServiceImp(UselessRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Useless> get() {
        return repository.findAll();
    }
}
