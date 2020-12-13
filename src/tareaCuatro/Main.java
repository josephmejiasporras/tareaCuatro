/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tareaCuatro;

import tl.controlador.Controlador;
import java.io.IOException;
import java.sql.SQLException;


public class Main {

    
    public static void main(String[] args) throws IOException, SQLException {
        Controlador controlador = new Controlador();
        controlador.ejecutar();
    }

}
