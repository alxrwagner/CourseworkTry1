import java.util.Scanner;
public class EmployeeBookApp {
    private final DatabaseOfEmployees dataBaseOfEmployee;
    Scanner input = new Scanner(System.in);

    public EmployeeBookApp() {
        this.dataBaseOfEmployee = new DatabaseOfEmployees();
    }

    private void showCommands(){
        System.out.println("Доступные команды:" +
                "\n1 - вывести список всех сотрудников" +
                "\n2 - вывести список всех сотрудников с минимальной заработной платой" +
                "\n3 - вывести список всех сотрудников с максимальной заработной платой" +
                "\n4 - посчитать сумму затрат на заработные платы в месяц" +
                "\n5 - посчитать среднее значение всех заработных плат" +
                "\n6 - завершить программу");
    }

    private void selectCommand(){
        System.out.println("Введите номер команды: ");
        String userInput = input.nextLine();

        switch (userInput){
            case "1":
                dataBaseOfEmployee.showAllEmployees();
                System.out.println();
                break;
            case "2":
                dataBaseOfEmployee.showEmployeesWithMinSalary();
                System.out.println();
                break;
            case "3":
                dataBaseOfEmployee.showEmployeesWithMaxSalary();
                System.out.println();
                break;
            case "4":
                dataBaseOfEmployee.showSumAllSalary();
                System.out.println();
                break;
            case "5":
                dataBaseOfEmployee.showAverageAmountAllSalary();
                System.out.println();
                break;
            case "6":
                System.out.println("Работа программы завершена");
                System.exit(0);
                break;
            default:
                System.out.println("Такой команды нет");
                break;
        }
    }

    public void fillDatabase(){
        dataBaseOfEmployee.addEmployee(new Employee("Анатолий", "Мамонов", "Сис. админ", 60000));
        dataBaseOfEmployee.addEmployee(new Employee("Галина", "Шварц", "Программист", 150000));
        dataBaseOfEmployee.addEmployee(new Employee("Сергей", "Никифоров", "Преподаватель", 100000));
        dataBaseOfEmployee.addEmployee(new Employee("Евгения", "Кулеш", "Тестировщик", 90000));
        dataBaseOfEmployee.addEmployee(new Employee("Александр", "Минин", "Менеджер", 60000));
        dataBaseOfEmployee.addEmployee(new Employee("Евгений", "Богданов", "Менеджер по продажам", 70000));
        dataBaseOfEmployee.addEmployee(new Employee("Николай", "Савченко", "Программист", 150000));
        dataBaseOfEmployee.addEmployee(new Employee("Лидия", "Александрова", "Тимлид", 200000));
        dataBaseOfEmployee.addEmployee(new Employee("Наталья", "Кравцова", "Программист джун", 90000));
        dataBaseOfEmployee.addEmployee(new Employee("Петр", "Иванов", "Тестировщик джун", 70000));
    }

    public void runApp(){

        while(true){
            showCommands();
            selectCommand();
        }
    }
}
