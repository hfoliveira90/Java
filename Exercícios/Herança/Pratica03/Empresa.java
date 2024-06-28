package questao3;

/**
 *
 * @author Administrator
 */
public class Empresa {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Gerente gerente1 = new Gerente("Bernardo Silva", 456789012, 2000.00, 1234);
        Gerente gerente2 = new Gerente("Mariana Vasquez", 567890123, 2500.00, 5678);

        System.out.println("Gerente 1:");
        System.out.println(gerente1.nome);

        System.out.println("\nGerente 2:");
        System.out.println(gerente2.nome);

        if (gerente1.autentica(1234)) {
            System.out.println("\nAutenticação Gerente 1 bem-sucedida!");
        } else {
            System.out.println("\nFalha na Autenticação Gerente 1");
        }

        if (gerente2.autentica(5678)) {
            System.out.println("\nAutenticação Gerente 2 bem-sucedida!");
        } else {
            System.out.println("\nFalha na Autenticação Gerente 2");
        }
    }
    
}
