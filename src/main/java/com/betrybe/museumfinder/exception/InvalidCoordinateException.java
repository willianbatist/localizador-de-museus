package com.betrybe.museumfinder.exception;

/**
 * The Class InvalidCoordinateException.
 */
public class InvalidCoordinateException extends RuntimeException {

  public InvalidCoordinateException() {
  }

  public InvalidCoordinateException(String message) {
    super(message);
  }

  /**
   * The method getMessage.
   */
  public String getMessage(String s) {
    return s;
  }
}
