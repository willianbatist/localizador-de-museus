package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.util.CoordinateUtil;

/**
 * The Service MuseumService.
 */
@Service
public class MuseumService implements MuseumServiceInterface {

  @Autowired
  private MuseumFakeDatabase museumFakeDatabase;

//  public MuseumService(MuseumFakeDatabase museumFakeDatabase) {
//    this.museumFakeDatabase = museumFakeDatabase;
//  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    return null;
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
