package com.yallapanthula.Spring.boot.tutorial.repository;

import com.yallapanthula.Spring.boot.tutorial.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
