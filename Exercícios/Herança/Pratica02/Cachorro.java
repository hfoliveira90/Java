package questao2;

/**
 *
 * @author Administrator
 */
public class Cachorro extends Animal{
    private String raca;

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
    
    
    public Cachorro(String nome, double peso, String raca){
        super(nome, peso);
        this.raca = raca; 
    }
    
}
