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
public class TableViewAvailableCourse {
    private final String course;
    private final String add;

    public TableViewAvailableCourse(String course) {
        this.course = course;
        add = "+";
    }

    public String getCourse() {
        return course;
    }

    public String getAdd() {
        return add;
    }
    
}
