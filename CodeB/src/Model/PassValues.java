package Model;

public class PassValues {
    private String title;
    private Integer degree;
    
    public PassValues(String title, Integer degree) {
        this.title = title;
        this.degree = degree;
    }
    
    public String getTitle() {
        return title;
    }

    public Integer getDegree() {
        return degree;
    }
}
