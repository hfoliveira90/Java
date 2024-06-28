package questao2;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cachorro cachorroUm = new Cachorro("Toto", 20, "Shitzu");
        Cachorro cachorroDois = new Cachorro("Spike", 30, "Golden");
        Peixe peixeUm = new Peixe("Tucunaré", 3.200,"Água Doce");
        Peixe peixeDois = new Peixe("Anchova", 1.100, "Água Salgada");
       
        System.out.println("Nome: "+ cachorroUm.getNome() +"\nPeso: "+ cachorroUm.getPeso() +"\nRaça: "+ cachorroUm.getRaca());
        System.out.println("Nome: "+ cachorroDois.getNome() +"\nPeso: "+ cachorroDois.getPeso() +"\nRaça: "+ cachorroDois.getRaca());
        System.out.println("Nome: "+ peixeUm.getNome() +"\nPeso: "+ peixeUm.getPeso() +"\nRaça: "+ peixeUm.getTipoHabitat());
        System.out.println("Nome: "+ peixeDois.getNome() +"\nPeso: "+ peixeDois.getPeso() +"\nRaça: "+ peixeDois.getTipoHabitat());
    }
    
}
