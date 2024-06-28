package questao01;

/**
 *
 * @author Administrator
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Funcionario funcionario = new Funcionario("567891234", "Rafael Andrade", 2000.00);
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("RG: " +funcionario.getRg());
        System.out.println("Salario: " +funcionario.getSalario());
        
        System.out.println("Aumento de salário em 10%: " +funcionario.aumentar_salario(funcionario.getSalario()));
    }
    
}
