package provider;

import db.DBConnection;
import model.Estudiante;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstudianteProvider {

    //SQL, consultas

    public ArrayList<Estudiante> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<Estudiante> output = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);

        while(resultSet.next()){

            int id = resultSet.getInt(resultSet.findColumn("id"));
            String nombre = resultSet.getString(resultSet.findColumn("nombre"));
            String codigo = resultSet.getString(resultSet.findColumn("codigo"));


            Estudiante estudiante = new Estudiante(id, nombre,codigo);
            output.add(estudiante);
        }
        connection.close();
        return output;

    }

    public void deleteById(String id) throws ClassNotFoundException, SQLException {
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.execute("DELETE FROM estudiantes WHERE id="+id);
    }
}
