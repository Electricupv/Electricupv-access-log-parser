import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class StudentTest {

    // Проверка инкапсуляции
    @Test(expected = UnsupportedOperationException.class)
    public void testGradesListIsUnmodifiable() {
        Student student = new Student("Иван");
        student.addGrade(5);
        List<Integer> grades = student.getGrades();
        grades.add(4);
    }

    // Тест на добавление допустимой оценки
    @Test
    public void testAddValidGrade() {
        Student student = new Student("Мария");
        student.addGrade(3);
        assertTrue(student.getGrades().contains(3));
    }

    // Тест на добавление недопустимой оценки <2
    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidGradeBelowMin() {
        Student student = new Student("Алексей");
        student.addGrade(1);
    }

    // Тест на добавление недопустимой оценки >5
    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidGradeAboveMax() {
        Student student = new Student("Ольга");
        student.addGrade(6);
    }

    // Проверка методов setName и getName
    @Test
    public void testSetAndGetName() {
        Student student = new Student("Дмитрий");
        student.setName("Дмитрий");
        assertEquals("Дмитрий", student.getName());
    }

    // Проверка метода equals
    @Test
    public void testEqualsForSameStudents() {
        Student student1 = new Student("Елена");
        student1.addGrade(4);
        Student student2 = new Student("Елена");
        student2.addGrade(4);
        assertEquals(student1, student2);
    }

    // Проверка метода equals для разных имен
    @Test
    public void testNotEqualsDifferentNames() {
        Student student1 = new Student("Павел");
        Student student2 = new Student("Сергей");
        assertNotEquals(student1, student2);
    }

    // Проверка метода equals для разных оценок
    @Test
    public void testNotEqualsDifferentGrades() {
        Student student1 = new Student("Анна");
        student1.addGrade(5);
        Student student2 = new Student("Анна");
        student2.addGrade(4);
        assertNotEquals(student1, student2);
    }

    // Проверка hashCode для одинаковых студентов
    @Test
    public void testHashCodeConsistency() {
        Student student = new Student("Ирина");
        student.addGrade(3);
        int hash1 = student.hashCode();
        int hash2 = student.hashCode();
        assertEquals(hash1, hash2);
    }

    // Проверка hashCode для эквивалентных студентов
    @Test
    public void testHashCodeEquality() {
        Student student1 = new Student("Ирина");
        student1.addGrade(3);
        Student student2 = new Student("Ирина");
        student2.addGrade(3);
        assertEquals(student1.hashCode(), student2.hashCode());
    }

    // Проверка toString()
    @Test
    public void testToString() {
        Student student = new Student("Николай");
        student.addGrade(5);
        student.addGrade(4);
        String str = student.toString();
        assertTrue(str.contains("Николай"));
        assertTrue(str.contains("[5, 4]"));
    }

    // Проверка equals с null
    @Test
    public void testEqualsWithNull() {
        Student student = new Student("Дарья");
        assertNotEquals(student, null);
    }

    // Проверка equals с объектом другого класса
    @Test
    public void testEqualsWithDifferentClass() {
        Student student = new Student("Артем");
        assertNotEquals(student, new Object());
    }

    // Проверка equals с тем же объектом
    @Test
    public void testEqualsWithSameObject() {
        Student student = new Student("Светлана");
        assertEquals(student, student);
    }
}