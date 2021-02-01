package com.venky.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venky.Entity.State;

@Repository
public interface StateRepository extends JpaRepository<State,Serializable> {

	 List<State> findByCountryId(Integer countryId);
}
