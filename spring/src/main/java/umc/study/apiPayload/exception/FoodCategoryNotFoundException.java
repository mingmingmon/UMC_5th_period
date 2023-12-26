package umc.study.apiPayload.exception;

public class FoodCategoryNotFoundException extends RuntimeException {

    public FoodCategoryNotFoundException() {
        super();
    }

    public FoodCategoryNotFoundException(String message) {
        super(message);
    }

    public FoodCategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}