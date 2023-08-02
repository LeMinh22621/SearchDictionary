package minh.lehong.searchdictionary.converters;

import minh.lehong.searchdictionary.models.entities.WordEntity;
import minh.lehong.searchdictionary.payloads.responses.WordResponse;
import org.springframework.beans.BeanUtils;

public interface CommonConverter {
    WordResponse convertWordEntityToWordDto(WordEntity wordEntity);
    default <SOURCE, TARGET> TARGET convertCopyProperties(SOURCE source, final Class<TARGET> target){
        TARGET response = null;
        try {
            response = target.newInstance();
            BeanUtils.copyProperties(source, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
}
