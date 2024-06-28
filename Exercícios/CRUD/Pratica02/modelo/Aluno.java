package modelo;

/**
 *
 * @author Administrator
 */
public class Aluno {
    String cpf;
    String nome;
    String datanasc;
    double peso;
    double altura;
    
    // Constructor
    public Aluno(String cpf, String nome, String datanasc, double peso, double altura) {
        this.cpf = cpf;
        this.nome = nome;
        this.datanasc = datanasc;
        this.peso = peso;
        this.altura = altura;
    }

    //Getters and Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setData(String datanasc) {
        this.datanasc = datanasc;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
}
