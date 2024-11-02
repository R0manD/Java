package labs.lab1;

import labs.lab4.EmployeeBuilder;

import java.util.Objects;

/**
 * Клас, що представляє працівника в зоомагазині.
 */
public class Employee {
    private int id;                  // Унікальний ідентифікатор працівника
    private String fullname;          // ПІБ працівника
    private String position;          // Посада працівника
    private double salary;             // Зарплата працівника
    private String hireDate;          // Дата прийняття на роботу

    public Employee(EmployeeBuilder builder) {
        this.id = builder.id;
        this.fullname = builder.fullname;
        this.position = builder.position;
        this.salary = builder.salary;
        this.hireDate = builder.hireDate;
    }

    public Employee(){

    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", hireDate='" + hireDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(employee.salary, salary) == 0 &&
                fullname.equals(employee.fullname) &&
                position.equals(employee.position) &&
                hireDate.equals(employee.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, position, salary, hireDate);
    }
}