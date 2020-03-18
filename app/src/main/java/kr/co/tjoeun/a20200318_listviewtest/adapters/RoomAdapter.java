package kr.co.tjoeun.a20200318_listviewtest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import kr.co.tjoeun.a20200318_listviewtest.R;
import kr.co.tjoeun.a20200318_listviewtest.datas.Room;

public class RoomAdapter extends ArrayAdapter<Room> {

    Context mContext;
    List<Room> mList;
    LayoutInflater inf;

    public RoomAdapter(@NonNull Context context, int resource, @NonNull List<Room> objects) {
        super(context, resource, objects);

        mContext = context;
        mList = objects;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.room_list_item, null);
        }

        Room data = mList.get(position);

        TextView priceTxt = row.findViewById(R.id.priceTxt);
        TextView addressTxtAndFloorTxt = row.findViewById(R.id.addressTxtAndFloorTxt);
        TextView descTxt = row.findViewById(R.id.descTxt);

//        가격 설정 => setText에는 int값 넣지 말자.
//        1만 이상? 억단위, 아니면? 숫자만 ,찍어서.

        if (data.getPrice() >= 10000) {

            int uk = data.getPrice() / 10000;
            int thousand = data.getPrice() % 10000;

            priceTxt.setText(String.format("%d억 %,d", uk, thousand));

        } else {
//            ?억%,d로 가공.
//            ?억?


            priceTxt.setText((String.format("%,d", data.getPrice())));
        }

//        주소 / 층수 결합해서

        String floorStr = "";
        if (data.getFloor() > 0){
            floorStr = String.format("%d층", data.getFloor());
        }else if(data .getFloor() == 0){
            floorStr = "반지하";

        }else {
            floorStr = String.format("지하 %d층", data.getFloor()*-1);
        }


        addressTxtAndFloorTxt.setText(String.format("%s, %s", data.getAddress(), floorStr));

        descTxt.setText((data.getDescription()));

        return row;
    }
}
