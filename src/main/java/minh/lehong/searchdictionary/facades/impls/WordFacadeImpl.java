package minh.lehong.searchdictionary.facades.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import minh.lehong.searchdictionary.converters.CommonConverter;
import minh.lehong.searchdictionary.facades.WordFacade;
import minh.lehong.searchdictionary.models.dtos.WordDto;
import minh.lehong.searchdictionary.models.entities.WordEntity;
import minh.lehong.searchdictionary.payloads.responses.Response;
import minh.lehong.searchdictionary.payloads.responses.WordResponse;
import minh.lehong.searchdictionary.services.WordService;
import minh.lehong.searchdictionary.utils.Constant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WordFacadeImpl implements WordFacade {

    @Autowired
    private WordService wordService;

    @Autowired
    private CommonConverter commonConverter;

    @Override
    public Response getAllWords() {
        Response response = new Response(null, false, HttpStatus.NOT_FOUND, Constant.GET_RECORDS_FAILED);
        try {
            List<WordResponse> wordResponses = wordService.getAllWords();
            if (wordResponses != null && !wordResponses.isEmpty()) {
                response = new Response(wordResponses, true, HttpStatus.OK, Constant.GET_RECORDS_FAILED);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response importFromLink(String fileLink) {
        Response response = new Response(null, false, HttpStatus.INTERNAL_SERVER_ERROR, Constant.IMPORT_WORDS_FAILED);
        try {
            if (!StringUtils.isEmpty(fileLink)) {
                List<WordDto> wordDtos = this.readFromCsvFile(fileLink);
                if (!CollectionUtils.isEmpty(wordDtos)) {
                    List<WordEntity> wordEntities = wordDtos.parallelStream()
                            .map(wordDto -> commonConverter.convertCopyProperties(wordDto, WordEntity.class))
                            .collect(Collectors.toList());
                    if (!CollectionUtils.isEmpty(wordEntities)) {
                        wordService.saveAll(wordEntities);
                        response = new Response(wordDtos, true, HttpStatus.OK, Constant.IMPORT_WORDS_SUCCESS);
                    } else {
                        response = new Response(null, false, HttpStatus.NO_CONTENT, Constant.ENTITY_HAVE_NO_CONTENT);
                    }
                } else {
                    response = new Response(null, false, HttpStatus.NO_CONTENT, Constant.DTO_HAVE_NO_CONTENTS);
                }
            } else {
                response = new Response(null, false, HttpStatus.BAD_REQUEST, Constant.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response getWordsByPage(int page, int size) {
        Response response = null;
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<WordEntity> wordEntityPage = wordService.getWordsByPageable(pageable);
            Page<WordDto> wordDtoPage = wordEntityPage.map(wordEntity -> commonConverter.convertCopyProperties(wordEntity, WordDto.class));
            response = new Response(wordDtoPage, true, HttpStatus.OK, Constant.GET_RECORDS_SUCCESS);
        } catch (Exception e) {
            response = new Response(null, false, HttpStatus.INTERNAL_SERVER_ERROR, Constant.GET_RECORDS_FAILED);
        }
        return response;
    }

    private List<WordDto> readFromCsvFile(String fileLink) {
        List<WordDto> wordDtos = null;
        try {
            File file = new File(fileLink);
            if (file != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                wordDtos = Arrays.asList(objectMapper.readValue(file, WordDto[].class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordDtos;
    }
}
