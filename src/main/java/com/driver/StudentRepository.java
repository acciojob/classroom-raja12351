package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentRepository {
    private HashMap<String , Student> studentData = new HashMap<>();
    private HashMap<String , Teacher> teacherData = new HashMap<>();
    private HashMap<String,ArrayList<String>> STpair = new HashMap<>();

    public void addStudent(Student student){
        studentData.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher){
        teacherData.put(teacher.getName(), teacher);
    }

    public List<Student> getAll(){
        return new ArrayList<>(studentData.values());
    }

    public List<Teacher> getAllTeacher(){
        return new ArrayList<>(teacherData.values());
    }

    public boolean makePair(String student , String teacher){
        if(teacherData.containsKey(teacher)){
            if(STpair.get(teacher).isEmpty()){
                ArrayList<String> update = new ArrayList<>();
                update.add(student);
                STpair.put(teacher,update);
            }
            else {
                ArrayList<String> update = STpair.get(teacher);
                update.add(student);
                STpair.put(teacher, update);
            }
            return true;
        }
        return false;
    }

    public List<String> getAllStudents(String teacher){
        if(STpair.containsKey(teacher)){
            return STpair.get(teacher);
        }
        return null;
    }

    public void deleteTeacher(String name){
        teacherData.remove(name);
    }

    public void removeAllTeacher(){
        teacherData.clear();
    }
}
