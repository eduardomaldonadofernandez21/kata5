package kataedu5;
    
import java.sql.SQLException;

public class KataEdu5 {
    private static Object datebase;
    
   
    public static void main(String[] args) throws SQLException {
           String URL = new String("jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\DB_SQLite\\prueba.db");
           DataBase database = new DataBase(URL);
           
           database.open();
           
           People people = new People("Fefo", "Hernandez", "Taller");
           database.insertPEOPLE(people);
           
           database.close();
    }
    
}
