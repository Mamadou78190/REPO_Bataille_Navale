import java.io.Serializable;

public class Data implements Serializable {
    private String x;
    private int y;

    public Data(String x, int y){
        this.x = x;
        this.y = y;

    }

    @Override
    public String toString(){
        return this.x+""+this.y;
    }
}
