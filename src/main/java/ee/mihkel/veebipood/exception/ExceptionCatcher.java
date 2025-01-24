package ee.mihkel.veebipood.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice // <-- läheb automaatikaga kõikidele kontrolleritele
public class ExceptionCatcher {

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleException(RuntimeException e) {
        ErrorMessage message = new ErrorMessage();
        message.setStatusCode(400);
        message.setDate(new Date());
        message.setMessage(e.getMessage());
        return ResponseEntity.badRequest().body(message);
    }
}
