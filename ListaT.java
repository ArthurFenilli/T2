
/**
 * Escreva uma descrição da classe ListaT aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ListaT
{
    private Time[] lista_times;
    private int index;
    private int sequencia;
    
    public ListaT( int quant_times){
        lista_times = new Time[quant_times];
        index = 0;
        sequencia = 1;
    }
    
    public boolean incluirTime(String país){
        if(index == lista_times.length) return false;
        lista_times[index] = new Time(sequencia, país);
        index++;
        sequencia++;
        return true;
    }
    
    public Time consultarTime(int num){
        for(int i = 0; i<index; i++){
            if(lista_times[i].getCodigo() == num)return lista_times[i];
        }
        return null;
    }
    
    public boolean excluiTime(int num){
        
        int diminui = Integer.MAX_VALUE;
        
        if(consultarTime(num) == null) return false;
        lista_times[num-1] = null;
        
        if(index == 1) index--;
        if(index > 1){
            for(int i = 0; i<index; i++){
                if(lista_times[i] == null){
                  diminui = i; 
                }
                if(i > diminui){
                    int j = i - 1;
                    lista_times[j] = lista_times[i];
                    
                    
                }
            }
            lista_times[lista_times.length - 1] = null;
            index--;
        }
        return true;
    }
    
    public String toString(){
        String msg = "Times: " + "\n";
        for(int i=0; i<index; i++){
            msg = msg + lista_times[i].toString() + "\n";
        }
        return msg;
    }
}
