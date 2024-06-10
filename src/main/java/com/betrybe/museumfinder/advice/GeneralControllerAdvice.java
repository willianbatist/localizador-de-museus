package com.betrybe.museumfinder.advice;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 * The Class GeneralControllerAdvice.
 */
@ControllerAdvice
public class GeneralControllerAdvice {

  /**
   * The method handleInvalidCoordinateException.
   */
  @ExceptionHandler(InvalidCoordinateException.class)
  public ResponseEntity<String> handleInvalidCoordinateException(
      InvalidCoordinateException e
  ) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage("Coordenada inválida!"));
  }

  /**
   * The method handleMuseumNotFoundException.
   */
  @ExceptionHandler(MuseumNotFoundException.class)
  public ResponseEntity<String> handleMuseumNotFoundException(
      MuseumNotFoundException e
  ) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage("Museu não encontrado!"));
  }

  /**
   * The method handleException.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Erro interno!");
  }
}
