package umc.study.apiPayload.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.FoodCategoryNotFoundException;
import umc.study.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

    @ExceptionHandler(FoodCategoryNotFoundException.class)
    public ResponseEntity<String> handleFoodCategoryNotFoundException(FoodCategoryNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}


