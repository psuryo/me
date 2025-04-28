import java.sql.*;

public class test {

    public static void main(String[] args) {
        // Database credentials and connection URL
        String url = "jdbc:mysql://localhost:3306/sales";
        String username = "nanang"; // Replace with your database username
        String password = "password"; // Replace with your database password

        // SQL query to fetch all records from the customer table
        String query = "SELECT * FROM cust";

        // Try-with-resources to ensure resources are closed
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("ID | Nama          | Kontak");
            System.out.println("-----------------------------");

            // Iterate through the result set and display the records
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                String kontak = resultSet.getString("kontak");

                System.out.printf("%d | %-15s | %s%n", id, nama, kontak);
            }

        } catch (SQLException e) {
            System.out.println("Database connection or query failed.");
            e.printStackTrace();
        }
    }
}
