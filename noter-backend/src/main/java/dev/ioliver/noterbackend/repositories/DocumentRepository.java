package dev.ioliver.noterbackend.repositories;

import dev.ioliver.noterbackend.domain.entities.Document;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DocumentRepository extends JpaRepository<Document, String> {
  @Query("SELECT d FROM Document d WHERE d.id = :id")
  Optional<Document> optionalById(@Param("id") String id);
}
