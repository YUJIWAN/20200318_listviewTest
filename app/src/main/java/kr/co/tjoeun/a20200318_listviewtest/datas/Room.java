package kr.co.tjoeun.a20200318_listviewtest.datas;

import java.io.Serializable;

public class Room implements Serializable {

    private int price;
    private String address;
    private int floor;
    private String description;

    public String getFloorToString(){
        //        주소 / 층수 결합해서

        String floorStr = "";
        if (this.floor > 0){
            floorStr = String.format("%d층", this.floor);
        }else if(this .floor == 0){
            floorStr = "반지하";

        }else {
            floorStr = String.format("지하 %d층", this.floor*-1);
        }
        return floorStr;
    }

    public String getFormattedPrice(){
//        상황에 따라 ?억 ?천, ?천인지로.
//        나눠서 리턴을 해줌.
        if(this.price >= 10000){
            int uk = this.price / 10000;
            int thousand = this.price % 10000;

            return String.format("%d억 %,d", uk, thousand);
        }else {
            return String.format("%,d", this.price);
        }
    }



    public Room(int price, String address, int floor, String description) {
        this.price = price;
        this.address = address;
        this.floor = floor;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
