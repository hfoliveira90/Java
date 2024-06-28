package questao01;

/**
 *
 * @author Administrator
 */
public class Funcionario extends Pessoa{
    
    private double salario;
    
    public double getSalario(){
        return salario;
    }
    
    public void setSalario(double salario){
        this.salario = salario;
    }
    
    public Funcionario(String Rg, String nome, double salario){
        super(Rg, nome);
        this.salario = salario;
    }
    
    public double aumentar_salario(double salario){
        double aumento = salario * 0.1;
        salario +=aumento;
        return salario;
    }
    
}
