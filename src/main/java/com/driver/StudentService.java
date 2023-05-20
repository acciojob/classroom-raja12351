package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentService {
    StudentRepository studentRepository = new StudentRepository();

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public List<String> getAllNames(){
        List<Student> students=  studentRepository.getAll();
        ArrayList<String> names = new ArrayList<>();
        for(int i=0;i<students.size();i++){
            names.add(students.get(i).getName());
        }
        return names;
    }

    public Student getStudent(String name){
        List<Student> studentList = studentRepository.getAll();
        for(Student student : studentList){
            if(student.getName().equals(name)){
                return student;
            }
        }
        throw new RuntimeException("No such student with this name");
    }
    public Teacher getTeacher(String name){
        List<Teacher> teacherList = studentRepository.getAllTeacher();
        for(Teacher teacher : teacherList){
            if(teacher.getName().equals(name)){
                return teacher;
            }
        }
        throw new RuntimeException("No such Teacher with this name");
    }
    public boolean makePair(String student , String teacher){
        if(studentRepository.makePair(student,teacher)){
            return true;
        }
        throw new RuntimeException("No teacher with this name , unable to create pair.");
    }
    public List<String> getAllStudents(String teacher){
        ArrayList<String> ans = new ArrayList<>(studentRepository.getAllStudents(teacher));
        if(!ans.isEmpty()){
            return ans;
        }
        throw new RuntimeException("No Such pair is found");
    }

    public void deleteTeacher(String name){
        studentRepository.deleteTeacher(name);

    }

    public void deleteAllTeacher(){
        studentRepository.removeAllTeacher();
    }
}
