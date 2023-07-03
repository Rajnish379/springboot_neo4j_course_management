package dev.rajineesh.springbootneo4j.services;

import dev.rajineesh.springbootneo4j.models.Course;
import dev.rajineesh.springbootneo4j.repositories.CourseRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course getCourseByIdentifier(String identifer){
        return courseRepository.findCourseByIdentifier(identifer)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
    }


}
