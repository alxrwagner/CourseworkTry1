package baseLvl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        fillDatabase(employees);

        showAllEmployees(employees);
        System.out.println();
        showSumAllSalary(employees);
        System.out.println();
        showEmployeesWithMinSalary(employees);
        System.out.println();
        showEmployeesWithMaxSalary(employees);
        System.out.println();
        showAverageAmountAllSalary(employees);
    }

    public static List<Employee> getEmployeesWithMinSalary(List<Employee> employees) {
        if (!employees.isEmpty()) {
            List<Employee> employeesWithMinSalary = new ArrayList<>();
            float minValue = employees.stream()
                    .min(Comparator.comparing(Employee::getSalary))
                    .get().getSalary();

            for (Employee employee : employees) {
                if (employee.getSalary() == minValue) {
                    employeesWithMinSalary.add(employee);
                }
            }
            return employeesWithMinSalary;
        } else {
            System.out.println("База данных пуста");
            return null;
        }
    }

    public static List<Employee> getEmployeesWithMaxSalary(List<Employee> employees) {
        if (!employees.isEmpty()) {
            List<Employee> employeesWithMaxSalary = new ArrayList<>();
            float maxValue = employees.stream()
                    .max(Comparator.comparing(Employee::getSalary)).get().getSalary();

            for (Employee employee : employees) {
                if (employee.getSalary() == maxValue) {
                    employeesWithMaxSalary.add(employee);
                }
            }
            return employeesWithMaxSalary;
        } else {
            System.out.println("База данных пуста");
            return null;
        }
    }

    public static float getSumAllSalary(List<Employee> employees) {
        float sumAllSalary = 0f;

        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                sumAllSalary += employee.getSalary();
            }
        } else {
            System.out.println("База данных пуста");
        }
        return sumAllSalary;
    }

    public static void showSumAllSalary(List<Employee> employees){
        System.out.printf("Общая сумма заработных плат в месяц составляет: %.2f рублей%n", getSumAllSalary(employees));
    }

    public static void showAllEmployees(List<Employee> employees) {
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                System.out.printf("ID: %d Имя: %s %s | Отдел: %d%n", employee.getId(), employee.getName(), employee.getSurname(), employee.getDepartment());
            }
        } else {
            System.out.println("База данных пуста");
        }
    }

    public static void showEmployeesWithMinSalary(List<Employee> employees) {
        List<Employee> employeesWithMinSalary = new ArrayList<>();

        employeesWithMinSalary = getEmployeesWithMinSalary(employees);

        if (!employeesWithMinSalary.isEmpty()) {
            System.out.println("Сотрудники с минимальной заработной платой: ");
            for (Employee employee : employeesWithMinSalary) {
                System.out.printf("ID: %d Имя: %s %s | Отдел: %d | Зарплата: %.2f рублей%n", employee.getId(), employee.getName(), employee.getSurname(),
                        employee.getDepartment(), employee.getSalary());
            }
        }
    }

    public static void showEmployeesWithMaxSalary(List<Employee> employees) {
        List<Employee> employeesWithMaxSalary = new ArrayList<>();

        employeesWithMaxSalary = getEmployeesWithMaxSalary(employees);

        if (!employeesWithMaxSalary.isEmpty()) {
            System.out.println("Сотрудники с максимальной заработной платой: ");
            for (Employee employee : employeesWithMaxSalary) {
                System.out.printf("ID: %d Имя: %s %s | Отдел: %d | Зарплата: %.2f рублей%n", employee.getId(), employee.getName(), employee.getSurname(),
                        employee.getDepartment(), employee.getSalary());
            }
        }
    }

    public static void showAverageAmountAllSalary(List<Employee> employees) {
        float sumAllSalary = getSumAllSalary(employees);
        float averageAmountAllSalary = sumAllSalary / employees.size();

        System.out.printf("Средняя сумма всех заработных плат в месяц составляет: %.2f рублей%n", averageAmountAllSalary);
    }

    public static void addEmployee(List<Employee> employees, Employee employee) {
        employees.add(employee);
    }

    public static void fillDatabase(List<Employee> employees){
        addEmployee(employees, new Employee("Анатолий", "Мамонов", 1, 60000));
        addEmployee(employees, new Employee("Галина", "Шварц", 2, 150000));
        addEmployee(employees, new Employee("Сергей", "Никифоров", 1, 100000));
        addEmployee(employees, new Employee("Евгения", "Кулеш", 5, 90000));
        addEmployee(employees, new Employee("Александр", "Минин", 2, 60000));
        addEmployee(employees, new Employee("Евгений", "Богданов", 3, 70000));
        addEmployee(employees, new Employee("Николай", "Савченко", 3, 150000));
        addEmployee(employees, new Employee("Лидия", "Александрова", 4, 200000));
        addEmployee(employees, new Employee("Наталья", "Кравцова", 1, 90000));
        addEmployee(employees, new Employee("Петр", "Иванов", 4, 70000));
    }
}
