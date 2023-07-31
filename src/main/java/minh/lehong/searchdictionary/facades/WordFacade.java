package minh.lehong.searchdictionary.facades;

import minh.lehong.searchdictionary.payloads.responses.Response;
import minh.lehong.searchdictionary.payloads.responses.WordResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WordFacade {
    Response getAllWords();
}
