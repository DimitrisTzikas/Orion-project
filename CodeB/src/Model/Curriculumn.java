/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Christos
 */
public class Curriculumn {
    private static ArrayList<Course> activeCurriculumCourses = new ArrayList<Course>();
    
    public static void addCourse(Course course){
        activeCurriculumCourses.add(course);
    }
    public static void addCourse(ArrayList<Course> course){
        activeCurriculumCourses.addAll(course);
    }
    
     public static void removeCourse(Course course){
        activeCurriculumCourses.remove(course);
    }
    
    public static ArrayList<Course> getCurriculum(){
        return activeCurriculumCourses;
    }
    
    public static ArrayList<Course> getCurriculum(int semester){
        ArrayList<Course> tempCurriculum = new ArrayList<>();
         for (Course c : activeCurriculumCourses){
            if(c.getSemester() == semester){
                tempCurriculum.add(c);
            }
        }
        return tempCurriculum;
    }
    
    public static void getCurriculumConsole(int semester){
        ArrayList<Course> tempCurriculum = new ArrayList<>();
         for (Course c : activeCurriculumCourses){
            if(c.getSemester() == semester){
                tempCurriculum.add(c);
            }
        }
        for (Course c :  tempCurriculum){
            System.out.println(c);
        }
    }
    
    public static ArrayList<Course> getNonCurriculum(){
        ArrayList<Course> tempCurriculum = new ArrayList<>(Course.getCourses());
        ArrayList<Course> coursesToRemove = new ArrayList<>();
        tempCurriculum.forEach(tcourse -> {
           activeCurriculumCourses.forEach(acourse->{
               if(tcourse.getTitle().equals(acourse.getTitle())){
                  coursesToRemove.add(tcourse);
               }
           });
        });
        tempCurriculum.removeAll(coursesToRemove);
        return  tempCurriculum;
    }
    
     public static void writeToFile() {
        try{
            FileOutputStream writeData = new FileOutputStream("Curriculum.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(Curriculumn.activeCurriculumCourses);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void importFromFile() throws IOException {
        try{
            FileInputStream readData = new FileInputStream("Curriculum.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            Curriculumn.activeCurriculumCourses = (ArrayList<Course>) readStream.readObject();
            readStream.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
