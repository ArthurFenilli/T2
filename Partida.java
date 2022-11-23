
/**
 * Escreva uma descrição da classe Partida aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Partida
{
    private String data;
    private int pontuaçãoTime1;
    private int pontuaçãoTime2;
    private int codigoTime1;
    private int codigoTime2;
    private int codigoPartida;
    
    
    public Partida(int codigo1, int codigo2, String dat, int pontuação1, int pontuação2, int codigo3){
        if(pontuação1>=0)pontuaçãoTime1 = pontuação1;
        else pontuaçãoTime1=0;
        if(pontuação2>=0)pontuaçãoTime2 = pontuação2;
        else pontuaçãoTime2 = 0;
        data = dat;
        codigoTime1 = codigo1;
        codigoTime2 = codigo2;
        codigoPartida = codigo3;
    }
    
    public String getData(){return data;}
    public int getPontuação1(){return pontuaçãoTime1;}
    public int getPontuação2(){return pontuaçãoTime2;}
    public int getCodigo1(){return codigoTime1;}
    public int getCodigo2(){return codigoTime2;}
    public int getCodigo3(){return codigoPartida;}
    
    public int setPontuação1(int novaPontuação){
        if(novaPontuação >=0) return pontuaçãoTime1 = novaPontuação;
        else return -1;
        
    }
    
    public int setPontuação2(int novaPontuação){
        if(novaPontuação >= 0) return pontuaçãoTime2 = novaPontuação;
        else return -1;
    }
    
    public String toString(){
         return "Partida disputada pelos times: " + codigoTime1 + " e " + codigoTime2 + "\n" +
                "Data: " + data + "\n" +
                "Pontuação da partida: " + pontuaçãoTime1 + " a " + pontuaçãoTime2 + "\n";
    }
}
