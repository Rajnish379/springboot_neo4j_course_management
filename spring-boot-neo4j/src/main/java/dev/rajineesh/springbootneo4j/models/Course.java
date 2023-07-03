package dev.rajineesh.springbootneo4j.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Course  {

    @Id
    @GeneratedValue
    private Long id;
    private String identifier;
    private String title;
    private String teacher;

//    @Relationship(type = "BELONGS_TO",direction= Relationship.Direction.INCOMING)
//    private List<Lesson> lessons = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Course(){

    }

//    public List<Lesson> getLessons() {
//        return lessons;
//    }
}
