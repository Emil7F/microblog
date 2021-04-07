package pl.emil7f.microblog.exception;

public enum PostError {
    POST_NOT_EXIST("Post not exist"),
    COMMENT_NOT_EXIST("Comment not exist");


    private final String message;

    PostError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
