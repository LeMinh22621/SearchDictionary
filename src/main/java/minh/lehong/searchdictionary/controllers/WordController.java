package minh.lehong.searchdictionary.controllers;

import minh.lehong.searchdictionary.facades.WordFacade;
import minh.lehong.searchdictionary.payloads.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("search")
    public ResponseEntity<?> getWordsByPage(@RequestParam(name = "page", defaultValue = "0") int page,
                                            @RequestParam(name = "size", defaultValue = "10") int size){
        Response response = wordFacade.getWordsByPage(page, size);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        return new ResponseEntity(response, response.getHttpStatus());
    }

    @PostMapping("imports")
    public ResponseEntity<?> importWordsFromCsvFile(){
        String fileLink = "D:\\Java\\SpringBoot\\SearchDictionary\\EDMTDictionary.json";
        Response response = wordFacade.importFromLink(fileLink);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        return new ResponseEntity(response, response.getHttpStatus());
    }
}