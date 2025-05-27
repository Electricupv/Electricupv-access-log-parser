package com.office;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    
    private Service service;
    private String testDatabaseUrl;

    @BeforeEach
    void setUp() {
        // Используем in-memory базу данных для каждого теста
        testDatabaseUrl = "jdbc:h2:mem:testdb" + System.currentTimeMillis() + ";DB_CLOSE_DELAY=-1";
        service = new Service(testDatabaseUrl);
        service.createDB();
    }

    @AfterEach
    void tearDown() {
        // Очистка не требуется для in-memory базы
    }

    @Test
    void testCreateDB() {
        // Проверяем, что база данных создана корректно
        assertEquals(2, service.getEmployeeCountInDepartment(1), "В отделе Accounting должно быть 2 сотрудника");
        assertEquals(2, service.getEmployeeCountInDepartment(2), "В отделе IT должно быть 2 сотрудника");
        assertEquals(1, service.getEmployeeCountInDepartment(3), "В отделе HR должен быть 1 сотрудник");
        assertEquals(0, service.getOrphanedEmployeesCount(), "Не должно быть осиротевших сотрудников");
    }

    @Test
    void testAddDepartment() {
        // Добавляем новый отдел
        Department newDept = new Department(4, "Marketing");
        service.addDepartment(newDept);
        
        // Проверяем, что отдел добавлен (косвенно через добавление сотрудника)
        Employee marketingEmployee = new Employee(6, "Alice", 4);
        assertDoesNotThrow(() -> service.addEmployee(marketingEmployee));
        
        assertEquals(1, service.getEmployeeCountInDepartment(4), "В новом отделе Marketing должен быть 1 сотрудник");
    }

    @Test
    void testRemoveDepartmentWithCascadeDelete() {
        // ОСНОВНОЙ ТЕСТ: проверяем каскадное удаление сотрудников при удалении отдела
        
        // Проверяем начальное состояние
        assertEquals(2, service.getEmployeeCountInDepartment(2), "В IT отделе должно быть 2 сотрудника до удаления");
        assertEquals(0, service.getOrphanedEmployeesCount(), "Не должно быть осиротевших сотрудников до удаления");
        
        // Удаляем IT отдел
        Department itDepartment = new Department(2, "IT");
        service.removeDepartment(itDepartment);
        
        // Проверяем результат
        assertEquals(0, service.getEmployeeCountInDepartment(2), "В IT отделе не должно быть сотрудников после удаления");
        assertEquals(0, service.getOrphanedEmployeesCount(), "Не должно быть осиротевших сотрудников после удаления отдела");
        
        // Проверяем, что другие отделы не затронуты
        assertEquals(2, service.getEmployeeCountInDepartment(1), "Отдел Accounting не должен быть затронут");
        assertEquals(1, service.getEmployeeCountInDepartment(3), "Отдел HR не должен быть затронут");
    }

    @Test
    void testAddEmployee() {
        // Добавляем нового сотрудника в существующий отдел
        Employee newEmployee = new Employee(6, "John", 1);
        service.addEmployee(newEmployee);
        
        assertEquals(3, service.getEmployeeCountInDepartment(1), "В отделе Accounting должно быть 3 сотрудника");
    }

    @Test
    void testRemoveEmployee() {
        // Удаляем конкретного сотрудника
        Employee employeeToRemove = new Employee(1, "Pete", 1);
        service.removeEmployee(employeeToRemove);
        
        assertEquals(1, service.getEmployeeCountInDepartment(1), "В отделе Accounting должен быть 1 сотрудник");
        assertEquals(0, service.getOrphanedEmployeesCount(), "Не должно быть осиротевших сотрудников");
    }

    @Test
    void testRemoveMultipleDepartments() {
        // Тестируем удаление нескольких отделов подряд
        
        // Удаляем IT отдел
        Department itDepartment = new Department(2, "IT");
        service.removeDepartment(itDepartment);
        
        // Удаляем HR отдел
        Department hrDepartment = new Department(3, "HR");
        service.removeDepartment(hrDepartment);
        
        // Проверяем, что все сотрудники удаленных отделов удалены
        assertEquals(0, service.getEmployeeCountInDepartment(2), "IT отдел должен быть пустым");
        assertEquals(0, service.getEmployeeCountInDepartment(3), "HR отдел должен быть пустым");
        assertEquals(0, service.getOrphanedEmployeesCount(), "Не должно быть осиротевших сотрудников");
        
        // Проверяем, что Accounting отдел остался нетронутым
        assertEquals(2, service.getEmployeeCountInDepartment(1), "Отдел Accounting должен остаться нетронутым");
    }

    @Test
    void testRemoveNonexistentDepartment() {
        // Тестируем удаление несуществующего отдела
        Department nonExistentDept = new Department(999, "NonExistent");
        
        // Должно выполниться без ошибок
        assertDoesNotThrow(() -> service.removeDepartment(nonExistentDept));
        
        // Состояние базы не должно измениться
        assertEquals(2, service.getEmployeeCountInDepartment(1), "Отдел Accounting не должен быть затронут");
        assertEquals(2, service.getEmployeeCountInDepartment(2), "Отдел IT не должен быть затронут");
        assertEquals(1, service.getEmployeeCountInDepartment(3), "Отдел HR не должен быть затронут");
        assertEquals(0, service.getOrphanedEmployeesCount(), "Не должно быть осиротевших сотрудников");
    }

    @Test
    void testDepartmentCreationRequirement() {
        // Проверяем, что требование каскадного удаления выполняется с момента создания БД
        
        // Создаем новую базу данных
        String newTestDbUrl = "jdbc:h2:mem:cascadeTestDB" + System.currentTimeMillis() + ";DB_CLOSE_DELAY=-1";
        Service cascadeService = new Service(newTestDbUrl);
        cascadeService.createDB();
        
        // Проверяем начальное состояние
        assertEquals(2, cascadeService.getEmployeeCountInDepartment(2), "IT отдел должен содержать 2 сотрудника");
        
        // Удаляем IT отдел
        Department itDept = new Department(2, "IT");
        cascadeService.removeDepartment(itDept);
        
        // Проверяем, что требование выполнено
        assertEquals(0, cascadeService.getEmployeeCountInDepartment(2), "IT отдел должен быть пустым после удаления");
        assertEquals(0, cascadeService.getOrphanedEmployeesCount(), "Не должно быть осиротевших сотрудников");
    }
}