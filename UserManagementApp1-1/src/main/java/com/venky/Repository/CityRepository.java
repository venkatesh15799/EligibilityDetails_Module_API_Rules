package com.venky.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venky.Entity.City;

@Repository
public interface CityRepository extends JpaRepository<City,Serializable> {

	List<City> findByStateId(Integer stateId);
}
