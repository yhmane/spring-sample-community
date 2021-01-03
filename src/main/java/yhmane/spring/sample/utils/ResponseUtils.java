package yhmane.spring.sample.utils;

import org.springframework.http.HttpStatus;
import yhmane.spring.sample.vo.response.DefaultResponse;

public class ResponseUtils {

    public static DefaultResponse<?> data(Object object) {
        if (object == null) {
            return new DefaultResponse<Object>(HttpStatus.NOT_FOUND);
        }
        return new DefaultResponse<Object>(object, HttpStatus.OK);
    }

    public static DefaultResponse<?> save(Object object) {
        if (object == null) {
            return new DefaultResponse<Object>(HttpStatus.NOT_FOUND);
        }
        return new DefaultResponse<Object>(object, HttpStatus.OK);
    }

    public static DefaultResponse<?> delete(Object object) {
        if (object == null) {
            return new DefaultResponse<Object>(HttpStatus.NOT_FOUND);
        }
        return new DefaultResponse<Object>(object, HttpStatus.OK);
    }

    public static DefaultResponse<?> error() {
        return new DefaultResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static DefaultResponse<?> error(HttpStatus httpStatus) {
        return new DefaultResponse(httpStatus);
    }
}
