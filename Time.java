
/**
 * Escreva uma descrição da classe Time aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Time
{
    private int codigo;
    private String país;
    
    public Time(int codigo,String país){
        this.codigo = codigo;
        this.país = país;
    }
    
    public int getCodigo(){return codigo;}
    public String getPaís(){return país;}
    
    public String toString(){
        return "Time No: " + codigo + " ----- País de origem: " + país;
    }
}
