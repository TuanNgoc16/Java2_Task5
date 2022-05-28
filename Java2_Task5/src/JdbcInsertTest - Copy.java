import java.sql.*;
    public class JdbcInsertTest {
        public static void main(String[] args) {
            try (
                    Connection conn = DriverManager. getConnection(
                    "jdbc:mysql://localhost : 3306/ ebookshop?",
                    "root", "");

            Statement stmt = conn.createStatement();
            ){
           // DELETE
            String sqlDelete = "delete from books where id >= 3000 and id < 4000";
            System.out.println("The SQL statement is: " + sqlDelete + "\n");
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + "records deleted.\n");
            //INSERT
            String sqlInsert = "insert into books values (3001, 'Gone Fishing', 'Kumar',11.1)";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

                    sqlInsert = "insert into books values "
                    + "(3002, ‘Gone Fishing 2', 'Kumar', 22.22, 22),"
                    + "(3003, 'Gone Fishing 3', Kumar', 33.33, 33)";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

                    sqlInsert = "insert into books (id, title, author) values (3004, 'Fishing 101','Kumar',13.2 )";
            System.out.println("The SQL statement is: " + sqlInsert + "\n"); // Echo for de
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + "records inserted.\n");

            String strSelect = "select * from books";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()) { // Move the cursor to the next row
                System.out.println(rset.getInt("id") + ","
                        + rset.getString("author") + ","
                        + rset.getString("title") + " , "
                        + rset.getDouble("price") + ", "
                        + rset.getInt("qty"));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        }
    }


