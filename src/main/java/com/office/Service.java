package com.office;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Service {
    private String databaseUrl;
    
    // Конструктор для тестирования
    public Service(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }
    
    // Конструктор по умолчанию
    public Service() {
        this.databaseUrl = "jdbc:h2:.\\Office";
    }

    public void createDB() {
        try (Connection con = DriverManager.getConnection(databaseUrl)) {
            Statement stm = con.createStatement();
            stm.executeUpdate("DROP TABLE Employee IF EXISTS");
            stm.executeUpdate("DROP TABLE Department IF EXISTS");
            
            stm.executeUpdate("CREATE TABLE Department(ID INT PRIMARY KEY, NAME VARCHAR(255))");
            stm.executeUpdate("INSERT INTO Department VALUES(1,'Accounting')");
            stm.executeUpdate("INSERT INTO Department VALUES(2,'IT')");
            stm.executeUpdate("INSERT INTO Department VALUES(3,'HR')");

            stm.executeUpdate("CREATE TABLE Employee(ID INT PRIMARY KEY, NAME VARCHAR(255), DepartmentID INT, " +
                            "FOREIGN KEY (DepartmentID) REFERENCES Department(ID) ON DELETE CASCADE)");
            stm.executeUpdate("INSERT INTO Employee VALUES(1,'Pete',1)");
            stm.executeUpdate("INSERT INTO Employee VALUES(2,'Ann',1)");
            stm.executeUpdate("INSERT INTO Employee VALUES(3,'Liz',2)");
            stm.executeUpdate("INSERT INTO Employee VALUES(4,'Tom',2)");
            stm.executeUpdate("INSERT INTO Employee VALUES(5,'Todd',3)");

        } catch (SQLException e) {
            throw new RuntimeException("Ошибка создания базы данных", e);
        }
    }

    public void addDepartment(Department d) {
        try (Connection con = DriverManager.getConnection(databaseUrl)) {
            PreparedStatement stm = con.prepareStatement("INSERT INTO Department VALUES(?,?)");
            stm.setInt(1, d.getDepartmentID());
            stm.setString(2, d.getName());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка добавления отдела", e);
        }
    }

    // ИСПРАВЛЕННЫЙ МЕТОД: теперь с каскадным удалением сотрудников
    public void removeDepartment(Department d) {
        try (Connection con = DriverManager.getConnection(databaseUrl)) {
            // Сначала удаляем всех сотрудников этого отдела
            PreparedStatement deleteEmployees = con.prepareStatement("DELETE FROM Employee WHERE DepartmentID=?");
            deleteEmployees.setInt(1, d.getDepartmentID());
            deleteEmployees.executeUpdate();
            
            // Затем удаляем сам отдел
            PreparedStatement deleteDepartment = con.prepareStatement("DELETE FROM Department WHERE ID=?");
            deleteDepartment.setInt(1, d.getDepartmentID());
            deleteDepartment.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка удаления отдела", e);
        }
    }

    public void addEmployee(Employee empl) {
        try (Connection con = DriverManager.getConnection(databaseUrl)) {
            PreparedStatement stm = con.prepareStatement("INSERT INTO Employee VALUES(?,?,?)");
            stm.setInt(1, empl.getEmployeeId());
            stm.setString(2, empl.getName());
            stm.setInt(3, empl.getDepartmentId());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка добавления сотрудника", e);
        }
    }

    public void removeEmployee(Employee empl) {
        try (Connection con = DriverManager.getConnection(databaseUrl)) {
            PreparedStatement stm = con.prepareStatement("DELETE FROM Employee WHERE ID=?");
            stm.setInt(1, empl.getEmployeeId());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка удаления сотрудника", e);
        }
    }
    
    // Вспомогательные методы для проверки состояния БД в тестах
    public int getEmployeeCountInDepartment(int departmentId) {
        try (Connection con = DriverManager.getConnection(databaseUrl)) {
            PreparedStatement stm = con.prepareStatement("SELECT COUNT(*) FROM Employee WHERE DepartmentID=?");
            stm.setInt(1, departmentId);
            var rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подсчета сотрудников", e);
        }
    }
    
    public int getOrphanedEmployeesCount() {
        try (Connection con = DriverManager.getConnection(databaseUrl)) {
            PreparedStatement stm = con.prepareStatement(
                "SELECT COUNT(*) FROM Employee WHERE DepartmentID NOT IN (SELECT ID FROM Department)");
            var rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подсчета осиротевших сотрудников", e);
        }
    }
}