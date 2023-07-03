package dev.rajineesh.springbootneo4j.controllers;

import dev.rajineesh.springbootneo4j.models.Course;
import dev.rajineesh.springbootneo4j.objects.CourseDTO;
import dev.rajineesh.springbootneo4j.objects.CourseEnrollmentDTO;
import dev.rajineesh.springbootneo4j.queryresults.CourseEnrollmentQueryResult;
import dev.rajineesh.springbootneo4j.requests.CourseEnrollmentRequest;
import dev.rajineesh.springbootneo4j.services.CourseEnrollmentService;
import dev.rajineesh.springbootneo4j.services.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/enrollments")
public class CourseEnrollmentController {
    private final CourseEnrollmentService courseEnrollmentService;

    private final LessonService lessonService;

    public CourseEnrollmentController(CourseEnrollmentService courseEnrollmentService, LessonService lessonService) {
        this.courseEnrollmentService = courseEnrollmentService;
        this.lessonService = lessonService;
    }

    @PostMapping("/")
    public ResponseEntity<CourseEnrollmentDTO> enrollIn(@RequestBody CourseEnrollmentRequest request, Principal principal) {
        CourseEnrollmentQueryResult enrollmentQueryResult = courseEnrollmentService.enrollIn(principal.getName(),request.getCourseIdentifier());

        CourseEnrollmentDTO responseEnrollment = new CourseEnrollmentDTO(enrollmentQueryResult.getUser().getUsername(),
                enrollmentQueryResult.getUser().getName(),
                enrollmentQueryResult.getCourse()
        );

        return new ResponseEntity<>(responseEnrollment, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> enrollments(Principal principal) {
        List<Course> courses = courseEnrollmentService.getAllEnrolledCoursesByUsername(principal.getName());

        List<CourseDTO> responseCourses = courses.stream().map(
                (course) -> {
                    CourseDTO responseCourse = new CourseDTO(course.getIdentifier(),course.getTitle(),course.getTeacher());
                    responseCourse.setLessons(lessonService.getAllLessonsByCourseIdentifier(course.getIdentifier()));
                    responseCourse.setEnrolled(true);
                    return responseCourse;
                }
        ).collect(Collectors.toList());
        return new ResponseEntity<>(responseCourses,HttpStatus.OK);
    }
}
