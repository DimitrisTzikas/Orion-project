/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author Christos
 */
public class TableViewTakenCourse {
    private final String course;
    private final int degree;

    public TableViewTakenCourse(String course,int degree) {
        this.course = course;
        this.degree = degree;
    }

    public String getCourse() {
        return course;
    }

    public int getDegree() {
        return degree;
    }
    
}
