package com.cardiff.repository;

import com.cardiff.entity.Activity;
import com.cardiff.entity.Community;
import com.cardiff.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
//    @Query("SELECT u FROM User u WHERE u.email = ?1")
//    User findByEmail(String email);
}
