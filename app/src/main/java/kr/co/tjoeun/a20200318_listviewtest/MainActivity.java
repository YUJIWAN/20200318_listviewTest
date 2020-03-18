package kr.co.tjoeun.a20200318_listviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjoeun.a20200318_listviewtest.adapters.RoomAdapter;
import kr.co.tjoeun.a20200318_listviewtest.databinding.ActivityMainBinding;
import kr.co.tjoeun.a20200318_listviewtest.datas.Room;

public class MainActivity extends BaseActivity {

    List<Room> roomDatas = new ArrayList<>();
    RoomAdapter roomAdapter = null;

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {

        binding.roomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Log.i("리스트뷰 아이템 클릭", String.format("%d번 줄 클릭", position));

//                클릭된 방의 주소를 Toast 출력
//                클릭 된 방의 정보를 목록에서 빼옴. position번째
                Room clickedRoom = roomDatas.get(position);
//                Toast.makeText(mContext, clickedRoom.getAddress(),Toast.LENGTH_SHORT).show();
//                방 상세 화면으로 이동
                Intent intent = new Intent(mContext, RoomDetailActivity.class);
                intent.putExtra("room", clickedRoom);
                startActivity(intent);

            }
        });

        binding.roomListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

//                꾹 누르고 있으면, 해당 방의 설명을 Toast로 출력
//                Room data = roomDatas.get(position);
//                Toast.makeText(mContext, data.getDescription(),Toast.LENGTH_LONG).show();

//                꾹 누르면 해당 아이템을 목록에서 삭제
                roomDatas.remove(position);
//                어댑터에게 새로고침 시킴.
                roomAdapter.notifyDataSetChanged();

                return false; // true : 롱클릭만. false : 그냥클릭도 같이
            }
        });

    }

    @Override
    public void setValues() {

        roomAdapter = new RoomAdapter(mContext, R.layout.room_list_item, roomDatas);

        binding.roomListView.setAdapter(roomAdapter);


        addRooms();

    }

    private void addRooms() {
        roomDatas.add(new Room(8000, "서울시 은평구", 4, "역이랑 가깝다"));
        roomDatas.add(new Room(7000, "인천광역시 부평구", 0, "투룸입니다"));
        roomDatas.add(new Room(26600, "경기도 부천시", 3, "단독주택입니다."));
        roomDatas.add(new Room(45000, "경기도 포천시", -1, "살기 좋은 방입니다."));
        roomDatas.add(new Room(100000, "서울시 종로구", 15, "아파트입니다.."));


        roomAdapter.notifyDataSetChanged();
    }
}
