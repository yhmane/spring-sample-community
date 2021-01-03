package yhmane.spring.sample.vo.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class DefaultResponse<T> {

    private T data;
    private String message;
    private HttpStatus httpStatus;

    public DefaultResponse(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public DefaultResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public DefaultResponse(T data, HttpStatus httpStatus) {
        this.data = data;
        this.httpStatus = httpStatus;
    }
}
