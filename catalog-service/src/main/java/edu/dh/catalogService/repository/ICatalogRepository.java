package edu.dh.catalogService.repository;

import edu.dh.catalogService.domain.model.Catalog;
import edu.dh.catalogService.domain.model.dto.CatalogWS;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICatalogRepository extends MongoRepository<Catalog, String> {

    Optional<Catalog> findByGenre(String genre);

    void deleteByGenre (String genre);
}
