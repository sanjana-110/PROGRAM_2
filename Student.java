import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {
    private String name;
    private LocalDate dob;

    public Student(String name, String dobStr) {
        this.name = name;
        this.dob = parseDob(dobStr);
    }

    private LocalDate parseDob(String dobStr) {
        try {
            if (dobStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
                return LocalDate.parse(dobStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } else {
                return LocalDate.parse(dobStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Date format should be YYYY-MM-DD or DD-MM-YYYY");
        }
    }

    public void displayInfo() {
        LocalDate today = LocalDate.now();
        int age = Period.between(dob, today).getYears();
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
