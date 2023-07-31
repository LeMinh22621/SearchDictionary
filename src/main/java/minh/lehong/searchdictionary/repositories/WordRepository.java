package minh.lehong.searchdictionary.repositories;

import minh.lehong.searchdictionary.models.entities.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<WordEntity, Long> {
}
