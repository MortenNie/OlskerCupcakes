package dat.backend.model.entities;

public class Bottoms {

    private int bottomsId;
    private String bottomsName;
    private int price;

    public Bottoms(int bottomsId, String bottomsName, int price) {
        this.bottomsId = bottomsId;
        this.bottomsName = bottomsName;
        this.price = price;
    }

    public int getBottomsId() {
        return bottomsId;
    }

    public String getBottomsName() {
        return bottomsName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Bottoms{" +
                "bottomsId=" + bottomsId +
                ", bottomsName='" + bottomsName + '\'' +
                ", price=" + price +
                '}';
    }
}
