/**
 * NumberPrinter
 */
public class NumberPrinter implements Runnable {
    int num ;
    public NumberPrinter(int num){
        this.num =num;
    }
    @Override
    public void run() {
        System.out.println(this.num + "printed by" + Thread.currentThread().getName());    
    }

    
}