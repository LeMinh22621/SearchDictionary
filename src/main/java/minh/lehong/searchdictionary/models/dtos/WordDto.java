package minh.lehong.searchdictionary.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class WordDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("term")
    private String term;
    @JsonProperty("types")
    private String types;
    @JsonProperty("meaning")
    private String meaning;

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(", ")
                .append(term).append(", ")
                .append(types).append(", ")
                .append(meaning).append("\n")
                .toString();
    }
}
