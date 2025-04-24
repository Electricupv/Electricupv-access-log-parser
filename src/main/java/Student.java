import java.util.Arrays;

public class Student {

    private final String name;
    private int[] grades;
    private int size;

    public Student(String name) {
        this(name, new int[0]);
    }

//Конструктор: обязательный параметр name и опциональные оценки.
    public Student(String name, int... initialGrades) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя студента не может быть пустым");
        }
        this.name = name;
        this.size = 0;
        // Инициализируем массив с запасом: минимум длина initialGrades или 10
        int capacity = Math.max(initialGrades.length, 10);
        this.grades = new int[capacity];
        // Добавляем начальные оценки с проверкой
        for (int grade : initialGrades) {
            addGrade(grade);
        }
    }

//Добавляет новую оценку в список.
    public void addGrade(int grade) {
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть от 2 до 5: " + grade);
        }
        // При необходимости расширяем массив вдвое
        if (size >= grades.length) {
            grades = Arrays.copyOf(grades, grades.length * 2);
        }
        grades[size++] = grade;
    }

//Возвращает копию массива оценок текущего размера.
    public int[] getGrades() {
        return Arrays.copyOf(grades, size);
    }

//Строковое представление: "Имя: [оценка1, оценка2, ...]"
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": [");
        for (int i = 0; i < size; i++) {
            sb.append(grades[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Student s1 = new Student("Иван");
        s1.addGrade(4);
        s1.addGrade(5);

        Student s2 = new Student("Ольга", 3, 5, 2);

        System.out.println(s1);
        System.out.println(s2);

    }
}