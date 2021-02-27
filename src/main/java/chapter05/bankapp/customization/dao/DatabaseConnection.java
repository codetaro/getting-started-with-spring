package chapter05.bankapp.customization.dao;

public class DatabaseConnection {
    public static DatabaseConnection getInstance() {
        return new DatabaseConnection();
    }

    public void releaseConnection() {

    }
}
