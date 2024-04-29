package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Service MuseumService.
 */
@Service
public class MuseumService implements MuseumServiceInterface {

  @Autowired
  private MuseumFakeDatabase museumFakeDatabase;

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    if (CoordinateUtil.isCoordinateValid(coordinate) != true) {
      throw new InvalidCoordinateException("Invalid coordinate");
    }
    Optional<Museum> optionalMuseum = museumFakeDatabase.getClosestMuseum(coordinate, maxDistance);
    if (optionalMuseum.isPresent()) {
      return optionalMuseum.get();
    } else {
      throw new MuseumNotFoundException("Museum Not Found");
    }
  }

  @Override
  public Museum createMuseum(Museum museum) {
    if (CoordinateUtil.isCoordinateValid(museum.getCoordinate()) != true) {
      throw new InvalidCoordinateException("Invalid coordinate");
    }
    return museumFakeDatabase.saveMuseum(museum);
  }

  @Override
  public Museum getMuseum(Long id) {
    return null;
  }
}
