package dev.rajineesh.springbootneo4j.requests;

public class CourseEnrollmentRequest {
    private String courseIdentifier;

    public String getCourseIdentifier() {
        return courseIdentifier;
    }

    public void setCourseIdentifier(String courseIdentifier) {
        this.courseIdentifier = courseIdentifier;
    }

    public CourseEnrollmentRequest() {

    }
}
