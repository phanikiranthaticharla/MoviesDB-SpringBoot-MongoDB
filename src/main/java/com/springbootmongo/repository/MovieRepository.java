package com.springbootmongo.repository;

import com.springbootmongo.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Document(collection="Movie")
public interface MovieRepository extends MongoRepository<Movie, Integer> {
}
