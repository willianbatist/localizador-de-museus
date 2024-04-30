package com.betrybe.museumfinder.exception;

/**
 * The Class MuseumNotFoundException.
 */
public class MuseumNotFoundException extends RuntimeException {

  public MuseumNotFoundException() {
  }

  public MuseumNotFoundException(String message) {
    super(message);
  }

  /**
   * The method getMessage.
   */
  public String getMessage(String s) {
    return s;
  }
}
