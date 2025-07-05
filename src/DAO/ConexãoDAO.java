package DAO; // Pacote DAO

import javax.swing.JOptionPane; // Importação Biblioteca Swing - JOptionPane

import java.sql.Connection; // Importação Conexão
import java.sql.DriverManager; //Importação do Driver
import java.sql.SQLException; //Importação de Exceção

// Classe de Conexão
public class ConexãoDAO {

    Connection conn; // Variável do tipo Connection

    public Connection conectaBD() { // Criação do Método de Conexão

        // Tratamento de exceções
        try {

            // URL de conexão com o banco de dados é armazenada na variável url que é utilizada em DriverManager.getConnection para estabelecer a conexão
            String url = "jdbc:mysql://localhost:3306/epidemia?user=root&password=&useTimezone=true&serverTimezone=UTC"; // Url de conexão com o Banco de Dados 
            conn = DriverManager.getConnection(url);

            //Exceção
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "conexaoDAO" + erro.getMessage()); // Mensagem de erro indicando a classe de conexão
        }
        return conn; // Retorno do tipo Connection
    }

}
