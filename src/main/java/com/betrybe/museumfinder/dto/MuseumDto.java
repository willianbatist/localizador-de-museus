package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * The class MuseumDto.
 */
public record MuseumDto(long id, String name, String description, String address,
                        String collectionType, String subject, String url, Coordinate coordinate) {
}
