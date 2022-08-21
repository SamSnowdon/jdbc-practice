import java.sql.*;

public class MyJDBC {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "ChunkyRoot15241?";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            insertData(connection);
            updateData(connection);
            deleteData(connection);
            selectData(connection);
            
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String instertAuthor = "INSERT INTO author (age, name) VALUES ('33', 'Shakespere')";
        String insertBook = "INSERT INTO book (name, release_date) VALUES ('Lord of the Rings', '1954')";
        String insertBookAuthor = "INSERT into author_book (authorid, bookid) VALUES ('1', '1')";

        int rows = statement.executeUpdate(instertAuthor);
        int bookrows = statement.executeUpdate(insertBook);
        int bookauthorrows = statement.executeUpdate(insertBookAuthor);

        System.out.println(rows > 0);
        System.out.println(bookrows > 0);
        System.out.println(bookauthorrows > 0);
    }

    public static void selectData(Connection connection) throws SQLException {
        String selectAuthor = "SELECT * FROM author";

        Statement statement = connection.createStatement();
        ResultSet resultAuthor = statement.executeQuery(selectAuthor);


        while (resultAuthor.next()){
            int id = resultAuthor.getInt(1);
            String name = resultAuthor.getString(2);
            int age = resultAuthor.getInt(3);
            System.out.println(age + " " + name + " " + id);
        }

    }

    public static void updateData(Connection connection) throws SQLException {
        String authorUpdate = "UPDATE author SET name=? WHERE age=22";
        String name = "Alex";
        PreparedStatement statement = connection.prepareStatement(authorUpdate);
        statement.setString(1, name);
        int rows = statement.executeUpdate();
        if (rows > 0){
            System.out.println("Info has been updated.");
        }
    }

    public static void deleteData(Connection connection) throws SQLException {
        String authorName = "Shakespere";
        String deleteAuthor = "DELETE FROM author WHERE name=?";
        PreparedStatement statement = connection.prepareStatement(deleteAuthor);
        statement.setString(1, authorName);
        int rows = statement.executeUpdate();
        System.out.println("Information deleted" + " " + rows);
    }
}
