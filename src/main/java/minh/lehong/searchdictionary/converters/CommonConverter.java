package minh.lehong.searchdictionary.converters;

import minh.lehong.searchdictionary.models.entities.WordEntity;
import minh.lehong.searchdictionary.payloads.responses.WordResponse;
import org.springframework.beans.BeanUtils;

public interface CommonConverter {
    WordResponse convertWordEntityToWordDto(WordEntity wordEntity);
    default <T1, T2> T2 convertEntityToDto(T1 source, final Class<T2> target){
        T2 response = null;
        try {
            response = target.newInstance();
            BeanUtils.copyProperties(source, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
}
