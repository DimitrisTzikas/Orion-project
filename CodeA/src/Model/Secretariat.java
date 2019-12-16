package Model;

import java.util.Date;

public class Secretariat extends User {

    public Secretariat(String username, String password, String name, String surname, Date birthday, String email, String phoneNumber) {
        super(username, password, name, surname, birthday, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "Secretariat{" + "username=" + this.username + ", password=" + password + ", name=" + name + ", surname=" + surname + ", birthday=" + birthday + ", email=" + email + ", phoneNumber=" + phoneNumber + ", registration=" + registration + '}';
    }
    
    public boolean addDegreeToStudent(Student student, Course course, int degree){
        return student.addDegree(course, degree);
    }

}
