/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.BandejaEntrada;
import vista.Login;
import vista.NuevoMensaje;

/**
 *
 * @author Rodrigo Chàvez
 */
public class BandejaEntradaController implements ActionListener {

    private BandejaEntrada vBandejaEntrada;

    public BandejaEntradaController(BandejaEntrada vBandejaEntrada) {
        this.vBandejaEntrada = vBandejaEntrada;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        NuevoMensaje nuevomensaje = new NuevoMensaje();//sería el Id del usuario logueado
        nuevomensaje.setVisible(true);
    }

}
