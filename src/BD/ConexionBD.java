
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author 501
 */
public class ConexionBD {
    Connection conn=null;
    
    public Connection conectar(){
        try{
            String ruta="jdbc:sqlserver://501-03:1433;databaseName=Huella;user=sa;password=cesde;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(ruta);
            
            if(conn!=null){
                JOptionPane.showMessageDialog(null, "Coneccion a base de datos lista...");
            }
            else if(conn==null){
                throw new SQLException();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Se produjo el siguiente error: "+e.getMessage());
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Se produjo el siguiente error: "+e.getMessage());
        }finally{
            return conn;
        }
    }
    
    public void desconectar(){
        conn = null;
        JOptionPane.showMessageDialog(null, "Desconexion de la base de datos lista...");
    }
}
