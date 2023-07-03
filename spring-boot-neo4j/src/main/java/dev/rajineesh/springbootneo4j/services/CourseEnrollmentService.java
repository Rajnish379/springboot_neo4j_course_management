package dev.rajineesh.springbootneo4j.services;

import dev.rajineesh.springbootneo4j.models.Course;
import dev.rajineesh.springbootneo4j.queryresults.CourseEnrollmentQueryResult;
import dev.rajineesh.springbootneo4j.repositories.CourseRepository;
import dev.rajineesh.springbootneo4j.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseEnrollmentService {
    private final CourseRepository courseRepository;

    private final UserRepository userRepository;

    public CourseEnrollmentService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public Boolean getEnrollmentStatus(String username, String identifier) {
        return userRepository.findEnrollmentStatus(username, identifier);
    }

    public CourseEnrollmentQueryResult enrollIn(String username, String identifier) {
        // TODO: make sure that the user has not been enrolled in the course already
        return userRepository.createEnrollmentRelationship(username,identifier);
    }

    public List<Course> getAllEnrolledCoursesByUsername(String username) {
        return courseRepository.findAllEnrolledCoursesByUsername(username);

    }
}
