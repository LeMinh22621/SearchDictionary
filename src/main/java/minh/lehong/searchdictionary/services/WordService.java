package minh.lehong.searchdictionary.services;

import minh.lehong.searchdictionary.models.dtos.WordDto;
import minh.lehong.searchdictionary.models.entities.WordEntity;
import minh.lehong.searchdictionary.payloads.responses.WordResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WordService {
    List<WordResponse> getAllWords();

    List<WordEntity> saveAll(List<WordEntity> wordEntities);

    Page<WordEntity> getWordsByPageable(Pageable pageable);
}
