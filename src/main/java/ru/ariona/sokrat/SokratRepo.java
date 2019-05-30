package ru.ariona.sokrat;

import org.springframework.data.repository.CrudRepository;

public interface SokratRepo extends CrudRepository<Sokrat, Long> {
    Sokrat findByUserLink(String userLink);

    Sokrat findByShortLink(String shortLink);
}
