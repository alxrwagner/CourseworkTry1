import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        fillDatabase(employees);

        showEmployeesWithMinSalaryOfDepartment(employees, 1);
        System.out.println();
        showEmployeesWithMaxSalaryOfDepartment(employees, 2);
        System.out.println();
        showSumAllSalaryOfDepartment(employees, 5);
        System.out.println();
        showAverageAmountSalaryOfDepartment(employees, 5);
        System.out.println();
        increaseSalaryAllEmployeesOfDepartment(5, employees, 3);
        System.out.println();
        showAllEmployeesOfDepartment(employees, 2);
        System.out.println();
        showEmployeesWithSalaryLessAmount(employees, 100000);
        System.out.println();
        showEmployeesWithSalaryMoreEqualAmount(employees, 100000);
    }

    public static List<Employee> getEmployeesWithMinSalaryOfDepartment(List<Employee> employees, int department) {
        if (!employees.isEmpty()) {
            List<Employee> employeesOfDepartment = new ArrayList<>();
            List<Employee> employeesWithMinSalary = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getDepartment() == department) {
                    employeesOfDepartment.add(employee);
                }
            }

            float minValue = employeesOfDepartment.stream()
                    .min(Comparator.comparing(Employee::getSalary))
                    .get().getSalary();

            for (Employee employee : employeesOfDepartment) {
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

    public static void increaseSalaryAllEmployeesOfDepartment(int percentageIncrease, List<Employee> employees, int department) {
        float increaseAmount;

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                increaseAmount = employee.getSalary();
                increaseAmount += employee.getSalary() / 100 * percentageIncrease;
                employee.setSalary(increaseAmount);
            }
        }

    }

    public static List<Employee> getEmployeesWithMaxSalaryOfDepartment(List<Employee> employees, int department) {
        if (!employees.isEmpty()) {
            List<Employee> employeesOfDepartment = new ArrayList<>();
            List<Employee> employeesWithMaxSalary = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getDepartment() == department) {
                    employeesOfDepartment.add(employee);
                }
            }

            float maxValue = employeesOfDepartment.stream()
                    .max(Comparator.comparing(Employee::getSalary)).get().getSalary();

            for (Employee employee : employeesOfDepartment) {
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

    public static float getSumAllSalaryOfDepartment(List<Employee> employees, int department) {
        float sumAllSalary = 0f;

        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                if (employee.getDepartment() == department) {
                    sumAllSalary += employee.getSalary();
                }
            }
        } else {
            System.out.println("База данных пуста");
        }
        return sumAllSalary;
    }

    public static void showSumAllSalaryOfDepartment(List<Employee> employees, int department) {
        System.out.printf("Общая сумма заработных плат в месяц составляет: %.2f рублей%n", getSumAllSalaryOfDepartment(employees, department));
    }

    public static void showAllEmployeesOfDepartment(List<Employee> employees, int department) {
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                if (employee.getDepartment() == department) {
                    System.out.printf("ID: %d Имя: %s %s %s%n", employee.getId(), employee.getName(), employee.getSurname(), employee.getMiddleName());
                }
            }
        } else {
            System.out.println("База данных пуста");
        }
    }

    public static void showEmployeesWithMinSalaryOfDepartment(List<Employee> employees, int department) {
        List<Employee> employeesWithMinSalary;

        employeesWithMinSalary = getEmployeesWithMinSalaryOfDepartment(employees, department);

        if (!employeesWithMinSalary.isEmpty()) {
            System.out.println("Сотрудники с минимальной заработной платой: ");
            for (Employee employee : employeesWithMinSalary) {
                System.out.printf("ID: %d Имя: %s %s %s | Отдел: %d | Зарплата: %.2f рублей%n", employee.getId(), employee.getName(), employee.getSurname(),
                        employee.getMiddleName(), employee.getDepartment(), employee.getSalary());

            }
        }
    }

    public static void showEmployeesWithMaxSalaryOfDepartment(List<Employee> employees, int department) {
        List<Employee> employeesWithMaxSalary;

        employeesWithMaxSalary = getEmployeesWithMaxSalaryOfDepartment(employees, department);

        if (!employeesWithMaxSalary.isEmpty()) {
            System.out.println("Сотрудники с максимальной заработной платой: ");
            for (Employee employee : employeesWithMaxSalary) {
                System.out.printf("ID: %d Имя: %s %s %s | Отдел: %d | Зарплата: %.2f рублей%n", employee.getId(), employee.getName(), employee.getSurname(), employee.getMiddleName(),
                        employee.getDepartment(), employee.getSalary());

            }
        }
    }

    public static float getAverageSalaryOfDepartment(List<Employee> employees, int department) {
        float averageAmount = 0f;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                averageAmount += employee.getSalary();
            }
        }
        return averageAmount;
    }

    public static void showAverageAmountSalaryOfDepartment(List<Employee> employees, int department) {
        System.out.printf("Средняя зарплата по отделу %d: %.2f%n", department, getAverageSalaryOfDepartment(employees, department));
    }

    public static void addEmployee(List<Employee> employees, Employee employee) {
        employees.add(employee);
    }

    public static void fillDatabase(List<Employee> employees) {
        addEmployee(employees, new Employee("Анатолий", "Мамонов", "Васильевич", 1, 60000));
        addEmployee(employees, new Employee("Галина", "Шварц", "Александровна", 2, 150000));
        addEmployee(employees, new Employee("Сергей", "Никифоров", "Николаевич", 3, 100000));
        addEmployee(employees, new Employee("Евгения", "Кулеш", "Валерьевна", 4, 90000));
        addEmployee(employees, new Employee("Александр", "Минин", "Александрович", 5, 60000));
        addEmployee(employees, new Employee("Евгений", "Богданов", "Игнатьевич", 1, 70000));
        addEmployee(employees, new Employee("Николай", "Савченко", "Юрьевич", 2, 150000));
        addEmployee(employees, new Employee("Лидия", "Александрова", "Степановна", 3, 200000));
        addEmployee(employees, new Employee("Наталья", "Кравцова", "Николаевна", 4, 90000));
        addEmployee(employees, new Employee("Петр", "Иванов", "Васильевич", 5, 70000));
    }

    public static void showEmployeesWithSalaryLessAmount(List<Employee> employees, float amountThreshold) {

        for (Employee employee : employees) {
            if (employee.getSalary() < amountThreshold) {
                System.out.printf("ID: %d Имя: %s Фамилия: %s Отчество: %s Зарплата: %f%n", employee.getId(), employee.getName(),
                        employee.getSurname(), employee.getMiddleName(), employee.getSalary());
            }
        }
    }

    public static void showEmployeesWithSalaryMoreEqualAmount(List<Employee> employees, float amountThreshold) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= amountThreshold) {
                System.out.printf("ID: %d Имя: %s Фамилия: %s Отчество: %s Зарплата: %f%n", employee.getId(), employee.getName(),
                        employee.getSurname(), employee.getMiddleName(), employee.getSalary());
            }
        }
    }
}