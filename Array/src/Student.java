import com.sun.javafx.binding.StringFormatter;

public class Student {

    private String name;
    private int score;

    Student(String studentName, int studentScore) {
        this.name = studentName;
        this.score = studentScore;
    }

    @Override
    public String toString() {return String.format("Student(name: %s, score: %d)", name, score); }

    public static void main(String[] args) {

        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Sakura",99));
        arr.addLast(new Student("tonghanyu",100));
        System.out.println(arr);
    }
}
