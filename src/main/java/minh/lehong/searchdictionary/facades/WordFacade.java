package minh.lehong.searchdictionary.facades;

import minh.lehong.searchdictionary.payloads.responses.Response;

public interface WordFacade {
    Response getAllWords();

    Response importFromLink(String fileLink);

    Response getWordsByPage(int page, int size);
}
