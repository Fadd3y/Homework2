import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = initEmployees();
        var result = employees.stream()
                .filter(e -> e.getAge() >= 30 && e.getAge() <= 50)
                .filter(e -> e.getSalary() > 60_000)
                .flatMap(e -> e.getProjects().stream())
                .filter(p -> p.getDuration() > 6)
                .collect(Collectors.groupingBy(
                        p -> p.getName().toUpperCase(),
                        LinkedHashMap::new,
                        Collectors.averagingInt(Project::getDuration))
                )
                .entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> e.getValue(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new)
                );

        System.out.println(result);
    }

    private static ArrayList<Employee> initEmployees() {
        ArrayList<Employee> employees = new ArrayList<>() {{
            add(new Employee(
                    "Иван",
                    40,
                    List.of(
                            new Project("ChatBot", 10),
                            new Project("Bank app", 7),
                            new Project("Car sharing", 5)),
                    100_000)
            );

            add(new Employee(
                    "Анна",
                    35,
                    List.of(
                            new Project("E-commerce", 12),
                            new Project("ChatBot", 8),
                            new Project("HR System", 6)),
                    75_000)
            );

            add(new Employee(
                    "Пётр",
                    45,
                    List.of(
                            new Project("Logistics AI", 15),
                            new Project("HR System", 7),
                            new Project("Data Analytics", 10)),
                    90_000)
            );

            add(new Employee(
                    "Мария",
                    29,
                    List.of(
                            new Project("Healthcare App", 9),
                            new Project("Data Analytics", 6),
                            new Project("Bank app", 8)),
                    80_000)
            );

            add(new Employee(
                    "Алексей",
                    50,
                    List.of(
                            new Project("Smart Home", 14),
                            new Project("E-commerce", 11),
                            new Project("Logistics AI", 9)),
                    110_000)
            );

            add(new Employee(
                    "Светлана",
                    32,
                    List.of(
                            new Project("Car sharing", 7),
                            new Project("Smart Home", 5),
                            new Project("Healthcare App", 13)),
                    70_000)
            );

            add(new Employee(
                    "Дмитрий",
                    47,
                    List.of(
                            new Project("Cyber Security", 10),
                            new Project("Cloud Storage", 6),
                            new Project("AI Research", 12)),
                    85_000)
            );

            add(new Employee(
                    "Екатерина",
                    38,
                    List.of(
                            new Project("E-commerce", 9),
                            new Project("Bank app", 10),
                            new Project("HR System", 8)),
                    95_000)
            );

            add(new Employee(
                    "Николай",
                    42,
                    List.of(
                            new Project("ChatBot", 11),
                            new Project("Cyber Security", 7),
                            new Project("Logistics AI", 13)),
                    88_000)
            );

            add(new Employee(
                    "Ольга",
                    34,
                    List.of(
                            new Project("Healthcare App", 14),
                            new Project("AI Research", 9),
                            new Project("Data Analytics", 7)),
                    73_000)
            );

            add(new Employee(
                    "Владимир",
                    44,
                    List.of(
                            new Project("Cloud Storage", 10),
                            new Project("Bank app", 8),
                            new Project("E-commerce", 12)),
                    102_000)
            );

            add(new Employee(
                    "Сергей",
                    39,
                    List.of(
                            new Project("HR System", 9),
                            new Project("Smart Home", 6),
                            new Project("AI Research", 11)),
                    78_000)
            );

            add(new Employee(
                    "Анастасия",
                    46,
                    List.of(
                            new Project("Car sharing", 10),
                            new Project("Logistics AI", 12),
                            new Project("Cyber Security", 8)),
                    91_000)
            );

            add(new Employee(
                    "Максим",
                    48,
                    List.of(
                            new Project("ChatBot", 9),
                            new Project("E-commerce", 10),
                            new Project("Bank app", 7)),
                    87_000)
            );

        }};
        return employees;
    }

}
