package nextstep.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<DataIntegrityViolationException> handleIllegalArgsException(DataIntegrityViolationException e) {
        return ResponseEntity.badRequest().body(e);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<IllegalArgumentException> extraIllegalArgsException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<UnauthorizedException> handleUnauthorizedException(UnauthorizedException e) {
        return ResponseEntity.status(401).body(e);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundException> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(404).body(e);
    }
}

