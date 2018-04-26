package com.tukkijamm.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.tukkijamm.backend.model.Trip;

public interface TripRepository extends CrudRepository<Trip, Long> {

}
