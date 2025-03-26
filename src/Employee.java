import java.util.List;

public class Employee {
    private final String name;
    private final int age;
    private final List<Project> projects;
    private final int salary;

    public Employee(String name, int age, List<Project> projects, int salary) {
        this.name = name;
        this.age = age;
        this.projects = projects;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", projects=" + projects +
                ", salary=" + salary +
                '}';
    }
}
