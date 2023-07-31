package minh.lehong.searchdictionary.payloads.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response<T> {
    @JsonProperty("data")
    private T data;
    @JsonProperty("is_success")
    private Boolean isSuccess;
    @JsonProperty("http_status")
    private HttpStatus httpStatus;
    @JsonProperty("message")
    private String message;
}
