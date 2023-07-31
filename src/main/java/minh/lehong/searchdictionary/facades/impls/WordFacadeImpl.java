package minh.lehong.searchdictionary.facades.impls;

import minh.lehong.searchdictionary.converters.CommonConverter;
import minh.lehong.searchdictionary.facades.WordFacade;
import minh.lehong.searchdictionary.payloads.responses.Response;
import minh.lehong.searchdictionary.payloads.responses.WordResponse;
import minh.lehong.searchdictionary.services.WordService;
import minh.lehong.searchdictionary.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WordFacadeImpl implements WordFacade {

    @Autowired
    private WordService wordService;

    @Override
    public Response getAllWords() {
        Response response = new Response(null, false, HttpStatus.NOT_FOUND, Constant.GET_ALL_RECORDS_FAILED);
        try{
            List<WordResponse> wordResponses = wordService.getAllWords();
            if(wordResponses != null && !wordResponses.isEmpty())
            {
                response = new Response(wordResponses, true, HttpStatus.OK, Constant.GET_ALL_RECORDS_SUCCESS);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
