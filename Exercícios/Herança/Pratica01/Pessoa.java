package questao01;

/**
 *
 * @author Administrator
 */
public class Pessoa {
    protected String Rg;
    protected String nome;
    
    public String getRg(){
        return Rg;
    }
    
    public void setRg(String Rg){
        this.Rg = Rg;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public Pessoa (String Rg, String nome){
        this.Rg = Rg;
        this.nome = nome;
    }
    
}
