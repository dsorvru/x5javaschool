package university;

public class App {

    public static void main(String[] args) {
        Student newStudent = new Aspirant("Афонасьев","Роман", "группа 10", 5, "Какой формы Луна?");

        Student[] students = new Student[] {
                new Student("Петр", "Букин","группа 1", 5),
                new Student("Ирина", "Шпак","группа 1", 4),
                new Aspirant("Иван","Прохоров","группа 2",5, "Кто живет в лесу?"),
                new Aspirant("Елена","Антонова","группа 2",4, "Что растет в лесу?")
        };

        for (Student student: students) {
            System.out.println(student.getScholarship());
        }

    }
}
