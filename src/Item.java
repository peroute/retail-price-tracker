import java.io.Serializable;

public class Item implements Serializable {
    private String url;
    private double targetPrice;
    private String email;

    public Item(String url, double targetPrice, String email){
        this.url = url;
        this.targetPrice = targetPrice;
        this.email = email;

    }
    public String getUrl(){
        return this.url;
    }
    public double getTargetPrice(){
        return this.targetPrice;
    }
    public String getEmail(){
        return this.email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        //if (obj == null || getClass() != obj.getClass()) return false;

        Item other = (Item) obj;

        return this.url.equals(other.url) && this.targetPrice == other.targetPrice;

    }


}


