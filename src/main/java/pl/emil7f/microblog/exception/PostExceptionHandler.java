package pl.emil7f.microblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PostExceptionHandler {


    @ExceptionHandler(PostException.class)
    public ResponseEntity<ErrorInfo> handleException(PostException e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if (PostError.POST_NOT_EXIST.equals(e.getPostError())
                || PostError.COMMENT_NOT_EXIST.equals(e.getPostError())) {
            httpStatus = HttpStatus.NOT_FOUND;
        }

        return ResponseEntity.status(httpStatus).body(new ErrorInfo(e.getPostError().getMessage()));
    }
}
