package com.venky.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venky.Entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Serializable> {
}
