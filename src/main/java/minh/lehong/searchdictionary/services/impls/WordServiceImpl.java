package minh.lehong.searchdictionary.services.impls;

import minh.lehong.searchdictionary.converters.CommonConverter;
import minh.lehong.searchdictionary.models.dtos.WordDto;
import minh.lehong.searchdictionary.models.entities.WordEntity;
import minh.lehong.searchdictionary.payloads.responses.WordResponse;
import minh.lehong.searchdictionary.repositories.WordRepository;
import minh.lehong.searchdictionary.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private CommonConverter commonConverter;

    @Override
    public List<WordResponse> getAllWords() {
        List<WordResponse> wordResponses = null;
        try {
            List<WordEntity> wordEntities = wordRepository.findAll();
            if(wordEntities != null && !wordEntities.isEmpty())
            {
                wordResponses = new ArrayList<>();
                List<WordResponse> finalWordResponses = wordResponses;
                wordEntities.forEach(wordEntity -> {
                    finalWordResponses.add(commonConverter.convertWordEntityToWordDto(wordEntity));
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordResponses;
    }

    @Override
    public List<WordEntity> saveAll(List<WordEntity> wordEntities) {
        return wordRepository.saveAll(wordEntities);
    }

    @Override
    public Page<WordEntity> getWordsByPageable(Pageable pageable) {
        return wordRepository.findAll(pageable);
    }
}
