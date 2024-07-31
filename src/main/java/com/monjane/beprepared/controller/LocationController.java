package com.monjane.beprepared.controller;

import com.monjane.beprepared.dto.response.CityResponseDto;
import com.monjane.beprepared.dto.response.ProvinceResponseDto;
import com.monjane.beprepared.mapper.Mapper;
import com.monjane.beprepared.services.LocationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
@Tag(name = "4. Location Controller")
public class LocationController {

    private final Mapper mapper;
    private final LocationService locationService;

    @GetMapping("/provincies")
    public ResponseEntity<List<ProvinceResponseDto>> getAllProvincies() {
        return ResponseEntity.ok(mapper.mapProvinceToResponseDtoList(
                locationService.getAllProvinces()));
    }

    @GetMapping("/province")
    public ResponseEntity<ProvinceResponseDto> getProvinceById(@RequestParam Long id) {
        return ResponseEntity.ok(mapper.mapProvinceToResponseDto(
                locationService.getProvinceById(id)));
    }

    @GetMapping("/cities")
    public ResponseEntity<List<CityResponseDto>> getAllCities() {
        return ResponseEntity.ok(mapper.mapCityToResponseDtoList(locationService.getAllCities()));
    }

    @GetMapping("/cities/{provinceId}")
    public ResponseEntity<List<CityResponseDto>> getCitiesByProvinceId(@PathVariable Long provinceId) {
        return ResponseEntity.ok(mapper.mapCityToResponseDtoList(
                locationService.getAllCitiesProvinceId(provinceId)));
    }

    @GetMapping("/city")
    public ResponseEntity<CityResponseDto> getCityById(@RequestParam Long id) {
        return ResponseEntity.ok(mapper.mapCityToResponseDto(
                locationService.getCityById(id)));
    }
}