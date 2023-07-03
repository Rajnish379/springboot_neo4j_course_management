package dev.rajineesh.springbootneo4j.queryresults;

import dev.rajineesh.springbootneo4j.models.Course;
import dev.rajineesh.springbootneo4j.models.User;

public class CourseEnrollmentQueryResult {

    private User user;

    private Course course;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
// Use Alt+Insert to insert setters and getters for class variables

    public CourseEnrollmentQueryResult() {
    }
}
