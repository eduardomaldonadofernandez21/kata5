
package kataedu5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DataBase {
    private String URL;
    private Connection connection = null;
    
    DataBase(String URL) {
        this.URL = URL;
    }

    void open() throws SQLException {
        try{
            this.connection = DriverManager.getConnection(this.URL);
            System.out.println("Base de datos abierta..");
        }
        catch (SQLException exception){
            System.out.println("Error DataBase: Open (SQLException)");
        }
    }

    void close() {
        try{
            if (this.connection != null){
                this.connection.close();
                System.out.println("Base de datos cerrada");
            }
        }
        catch (SQLException exception) {
            System.out.println("Error DataBase: Open (SQLException)");
        }
    }
    
    void selectPEOPLE() {
        String SQL = "SELECT * FROM PEOPLE";
        try{
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            System.out.println("ID \t NAME \t APELLIDOS \t DEPARTAMENTO");
            while (resultset.next()){
                System.out.println(resultset.getInt("ID") + " \t" +
                                   resultset.getString("NAME") + " \t" +
                                   resultset.getString("APELLIDOS") + " \t" +
                                   resultset.getString("DEPARTAMENTO"));
            }
        }
        catch (SQLException exception){
            System.out.println("Error DataBase: selectPEOPLE (SQLException)");
        }
    }

    void insertPEOPLE(People people) {
        String SQL = "INSERT INTO PEOPLE(NAME, APELLIDOS, DEPARTAMENTO) VALUES(?, ?, ?)";
        try{
            PreparedStatement preparedstatement = this.connection.prepareStatement(SQL);
            preparedstatement.setString(1, people.getName());
            preparedstatement.setString(2, people.getApellidos());
            preparedstatement.setString(3, people.getDepartamento());
            preparedstatement.executeUpdate();
        }
        catch (SQLException exception){
            System.out.println("Error DataBase: insertPEOPLE (SQLException)");
        }
    }
    
}
