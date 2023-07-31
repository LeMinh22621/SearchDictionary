package minh.lehong.searchdictionary.controllers;

import minh.lehong.searchdictionary.facades.WordFacade;
import minh.lehong.searchdictionary.payloads.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/words")
public class WordController {
    @Autowired
    private WordFacade wordFacade;
    @GetMapping
    public ResponseEntity<?> getAllWords(){
        Response response = wordFacade.getAllWords();
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        return new ResponseEntity(response, response.getHttpStatus());
    }
}
