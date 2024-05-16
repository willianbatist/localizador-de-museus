package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Controller MuseumController.
 */
@RestController
@RequestMapping(value = "/museums")
public class MuseumController {

  @Autowired
  private MuseumServiceInterface museumService;

  /**
   * The Post createMuseum of class MuseumController.
   */
  @PostMapping
  public ResponseEntity<Museum> createMuseum(@RequestBody MuseumCreationDto museumCreationDto) {
    Museum dtoToModel = ModelDtoConverter.dtoToModel(museumCreationDto);
    Museum createMuseum = museumService.createMuseum(dtoToModel);

    return ResponseEntity.status(HttpStatus.CREATED).body(createMuseum);
  }

  /**
   * The Get Closest Museum.
   */
  @GetMapping("/closest")
  public ResponseEntity<Museum> getClosestMuseum(
      @RequestParam(name = "lat") double latitude,
      @RequestParam(name = "lng") double longitude,
      @RequestParam(name = "max_dist_km") double maxDistance
  ) {
    Coordinate coordinate = new Coordinate(latitude, longitude);
    Museum closestMuseum = museumService.getClosestMuseum(coordinate, maxDistance);
    return ResponseEntity.status(HttpStatus.OK).body(closestMuseum);
  }
}
