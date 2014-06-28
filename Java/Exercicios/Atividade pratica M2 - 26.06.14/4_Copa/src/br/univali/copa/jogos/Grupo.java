
package br.univali.copa.jogos;

import br.univali.copa.time.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Felipe Gonçalves
 * 
 * Grupo tem 4 times
 */
public class Grupo {
    private List<Time> times = new ArrayList<Time>();

    public List<Time> getTimes() {
        return times;
    }
    
    public void adicionarTime(Time time){
        this.times.add(time);
    }
    
    public void removerTime(Time time){
        this.times.remove(time);
    }
    
    public void listarTimes(){
        for (Time time : times) {
            System.out.println(time.getPais());
        }
    }
    
}
