package minh.lehong.searchdictionary.payloads.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WordResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("term")
    private String term;
    @JsonProperty("types")
    private String types;
    @JsonProperty("meaning")
    private String meaning;
}
