package modelo;

import java.util.Date;
/**
 *
 * @author Administrator
 */
public class HistoricoPeso {
    private String cpf_aluno;
    private String data_pesagem;
    private double peso_dia;

//Constructor
    public HistoricoPeso(String cpf_aluno, String data_pesagem, double peso_dia) {
        this.cpf_aluno = cpf_aluno;
        this.data_pesagem = data_pesagem;
        this.peso_dia = peso_dia;
    }

//Getters and Setters
    public String getCpf_aluno() {
        return cpf_aluno;
    }

    public void setCpf_aluno(String cpf_aluno) {
        this.cpf_aluno = cpf_aluno;
    }

    public String getData_pesagem() {
        return data_pesagem;
    }

    public void setData_pesagem(String data_pesagem) {
        this.data_pesagem = data_pesagem;
    }

    public double getPeso_dia() {
        return peso_dia;
    }

    public void setPeso_dia(double peso_dia) {
        this.peso_dia = peso_dia;
    }
    
    
    //Retorna o valor do IMC
     public double IMC(double altura, double peso) {
        return peso / (altura * altura);
    }
    
    //Interpreta os dados do IMC
     public String interpretarIMC(double altura, double peso) {
        double imc = IMC(altura, peso);
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }
}
