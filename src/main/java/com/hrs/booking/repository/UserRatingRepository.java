package com.hrs.booking.repository;

import com.hrs.booking.model.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRatingRepository extends JpaRepository<UserRating,Long> {
}
