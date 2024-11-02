package labs.lab4;

import labs.lab1.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Builder для створення об'єктів Employee з валідацією полів.
 */
public class EmployeeBuilder {
    public int id;
    public String fullname;
    public String position;
    public double salary;
    public String hireDate;

    private List<String> validationErrors = new ArrayList<>();

    public EmployeeBuilder setId(int id) {
        if (id <= 0) {
            validationErrors.add("Invalid ID: " + id + ". ID must be greater than 0.");
        }
        this.id = id;
        return this;
    }

    public EmployeeBuilder setFullname(String fullname) {
        if (fullname == null || fullname.trim().isEmpty()) {
            validationErrors.add("Invalid Full Name: '" + fullname + "'. Full Name cannot be null or empty.");
        }
        this.fullname = fullname;
        return this;
    }

    public EmployeeBuilder setPosition(String position) {
        if (position == null || position.trim().isEmpty()) {
            validationErrors.add("Invalid Position: '" + position + "'. Position cannot be null or empty.");
        }
        this.position = position;
        return this;
    }

    public EmployeeBuilder setSalary(double salary) {
        if (salary < 0) { // Зарплата не може бути негативною
            validationErrors.add("Invalid Salary: " + salary + ". Salary must be non-negative.");
        }
        this.salary = salary;
        return this;
    }

    public EmployeeBuilder setHireDate(String hireDate) {
        if (hireDate == null || !hireDate.matches("\\d{4}-\\d{2}-\\d{2}")) { // Формат дати YYYY-MM-DD
            validationErrors.add("Invalid Hire Date: '" + hireDate + "'. Hire Date must be in the format YYYY-MM-DD.");
        }
        this.hireDate = hireDate;
        return this;
    }

    public Employee build() {
        if (!validationErrors.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationErrors));
        }

        return new Employee(this);
    }
}