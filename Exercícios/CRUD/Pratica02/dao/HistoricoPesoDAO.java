package dao;

import factory.ConnectionFactory;
import modelo.HistoricoPeso;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class HistoricoPesoDAO {
    private Connection connection;

    public HistoricoPesoDAO() {
     this.connection = new ConnectionFactory().getConnection();
    }
  
    
public void adicionaHistorico(HistoricoPeso historicoPeso){
     // Comando SQL para inserir um novo histórico de peso
        String sql_adiciona_historico_peso = "INSERT INTO historico(cpf_aluno, data_pesagem, peso_dia) VALUES(?, ?, ?)";
        try {
            // Prepara o comando para execução
            PreparedStatement stmt = connection.prepareStatement(sql_adiciona_historico_peso);
            // Preenche os valores do comando SQL
            stmt.setString(1, historicoPeso.getCpf_aluno());
            stmt.setString(2, historicoPeso.getData_pesagem());
            stmt.setDouble(3, historicoPeso.getPeso_dia());
            // Executa o comando e fecha a conexão com o banco de dados
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            // Exibe uma mensagem de erro e lança uma exceção
            JOptionPane.showMessageDialog(null, "Houve algum erro ao adicionar o histórico de peso, tente mais tarde!");
            throw new RuntimeException(u);
        }
        

}
public HistoricoPeso ListaHistorico(String cpf, double peso) {
        String sql_seleciona_historicopeso = "SELECT * FROM historico WHERE cpf_aluno = ? AND peso_dia = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql_seleciona_historicopeso);
            stmt.setString(1, cpf);
            stmt.setDouble(2, peso);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String cpf_aluno = rs.getString("cpf_aluno");
                String data_pesagem = rs.getString("data_pesagem");
                double peso_dia = rs.getDouble("peso_dia");
                return new HistoricoPeso(cpf_aluno, data_pesagem, peso_dia);
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Houve algum erro ao listar o aluno, tente mais tarde!");
            throw new RuntimeException(e);
        }
    }

public void alteraHistorico(String cpf, String data, double novo_peso){
    // Comando SQL para atualizar o peso do histórico
        String sql_altera_historico_peso = "UPDATE historico SET peso_dia = ? WHERE cpf_aluno = ? AND data_pesagem = ?";
        try {
            // Prepara o comando para execução
            PreparedStatement stmt = connection.prepareStatement(sql_altera_historico_peso);
            // Preenche os valores do comando SQL
            stmt.setDouble(1, novo_peso);
            stmt.setString(2, cpf);
            stmt.setString(3, data);
            // Executa o comando de atualização e fecha a conexão com o banco de dados
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            // Exibe uma mensagem de erro e lança uma exceção
            JOptionPane.showMessageDialog(null, "Houve algum erro ao alterar o histórico de peso, tente mais tarde!");
            throw new RuntimeException(e);
        }
}

public void Remove_Historico(String cpf, String data) {
        // Comando SQL para remover um histórico de peso
        String sql_remove_historico_peso = "DELETE FROM historico WHERE cpf_aluno = ? AND data_pesagem = ?";
        try {
            // Prepara o comando para execução
            PreparedStatement stmt = connection.prepareStatement(sql_remove_historico_peso);
            // Preenche os valores do comando SQL
            stmt.setString(1, cpf);
            stmt.setString(2, data);
            // Executa o comando de remoção e fecha a conexão com o banco de dados
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            // Exibe uma mensagem de erro e lança uma exceção
            JOptionPane.showMessageDialog(null, "Houve algum erro ao remover o histórico de peso, tente mais tarde!");
            throw new RuntimeException(e);
        }
    }
}
