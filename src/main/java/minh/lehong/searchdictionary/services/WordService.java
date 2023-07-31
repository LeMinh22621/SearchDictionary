package minh.lehong.searchdictionary.services;

import minh.lehong.searchdictionary.payloads.responses.WordResponse;

import java.util.List;

public interface WordService {
    List<WordResponse> getAllWords();
}
