package com.example.repository;

import com.example.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Integer> {

//  Display all regions in Canada
    List<Region> findByCountry(String country);
    List<Region> getByCountry(String country);

//  Display all regions with country name includes 'United'
    List<Region> findByCountryContaining(String country);

//  Display all regions with country name includes 'United' in order (region)
    List<Region> findByCountryContainsOrderByRegionDesc(String country);

//  Display tor 2 regions inUnited States
    List<Region>findTopByCountry(String country);
    List<Region>findTop2ByCountry(String country);

    List<Region>findTopByCountryContainsOrderByRegion(String country);

}
