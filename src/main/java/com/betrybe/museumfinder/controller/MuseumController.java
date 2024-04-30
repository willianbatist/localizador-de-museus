package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
   * The Post createMuseum.
   */
  @PostMapping
  public ResponseEntity<Museum> createMuseum(@RequestBody MuseumCreationDto museumCreationDto) {
    Museum dtoToModel = ModelDtoConverter.dtoToModel(museumCreationDto);
    Museum createMuseum = museumService.createMuseum(dtoToModel);

    return ResponseEntity.status(HttpStatus.CREATED).body(createMuseum);
  }
}
