package dao;

import factory.ConnectionFactory;
import modelo.Aluno;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class AlunoDao {
    private Connection connection;
    
    public AlunoDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Aluno aluno){
        String sql = "INSERT INTO aluno(cpf, nome, data_nascimento, peso, altura) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getCpf()); // Define o CPF
            stmt.setString(2, aluno.getNome()); // Define o nome
            stmt.setString(3, aluno.getData()); // Define a data de nascimento
            stmt.setFloat(4, aluno.getPeso()); // Define o peso
            stmt.setFloat(5, aluno.getAltura()); // Define a altura
            stmt.execute();
            stmt.close(); 
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    public void consultar (Aluno aluno, JLabel jLabelnome, JLabel jLabelcpf, JLabel jLabeldata, JLabel jLabelaltura, JLabel jLabelpeso){
        String cpf = aluno.getCpf(); //Obtém CPF do aluno
        String sql = "SELECT * FROM aluno WHERE cpf = ?";
        
        try{
             PreparedStatement stmt = connection.prepareStatement(sql);
             stmt.setString(1, cpf);
             ResultSet rs = stmt.executeQuery();
        
            if (rs.next()) {
                // Se o aluno for encontrado, preencha os JLabels com os dados retornados
                jLabelnome.setText(rs.getString("nome"));
                jLabelcpf.setText(rs.getString("cpf"));
                jLabeldata.setText(rs.getString("data_nascimento"));
                jLabelaltura.setText(rs.getString("altura"));
                jLabelpeso.setText(rs.getString("peso"));
            } else {
                // Se nenhum aluno for encontrado com o CPF fornecido, exiba uma mensagem de erro
                JOptionPane.showMessageDialog(null, "Aluno não encontrado");
            }

            rs.close();
            stmt.close();
            
        } catch (SQLException u) {
            throw new RuntimeException(u);
            }
    
    }
    
    public void excluir (String cpf){
        String sql = "DELETE FROM aluno WHERE cpf =?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null,"Registro removido com sucesso.");
            } else {
                System.out.println("Nenhum registro encontrado para remover com o CPF fornecido.");
            }
            stmt.close(); // Fechando o PreparedStatement
        }   catch (SQLException e) {
            System.err.println("Erro ao remover registro: " + e.getMessage());
            e.printStackTrace(); // Isso ajudará na depuração, mas você pode optar por outro tratamento de exceção.
            }
    }
    
    public void atualiza(Aluno aluno, String cpf, JTextField TextFieldNome, JTextField TextFieldData, JTextField TextFieldPeso, JTextField TextFieldAltura){
        String sql = "UPDATE aluno SET nome = ?, peso = ?, altura = ?, data_nascimento = ? WHERE cpf = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, TextFieldNome.getText()); // Define o novo nome
            stmt.setFloat(2, Float.parseFloat(TextFieldPeso.getText())); // Define o novo peso
            stmt.setFloat(3, Float.parseFloat(TextFieldAltura.getText())); // Define a nova altura
            stmt.setString(4, TextFieldData.getText()); // Define a nova data de nascimento
            stmt.setString(5, cpf); // Define o CPF para identificar o aluno a ser atualizado

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null,"Nenhum aluno atualizado. Verifique o CPF fornecido.");
            }

            stmt.close();
        } catch (SQLException e) {
            // Lança uma RuntimeException com uma mensagem de erro significativa
            throw new RuntimeException("Erro ao atualizar aluno: " + e.getMessage(), e);
        }      

        }
    
}
