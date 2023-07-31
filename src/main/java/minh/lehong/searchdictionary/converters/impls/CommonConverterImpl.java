package minh.lehong.searchdictionary.converters.impls;

import minh.lehong.searchdictionary.converters.CommonConverter;
import minh.lehong.searchdictionary.models.entities.WordEntity;
import minh.lehong.searchdictionary.payloads.responses.WordResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CommonConverterImpl implements CommonConverter {
    @Override
    public WordResponse convertWordEntityToWordDto(WordEntity wordEntity) {
        WordResponse wordResponse = new WordResponse();
        BeanUtils.copyProperties(wordEntity, wordResponse);
        return wordResponse;
    }
}

