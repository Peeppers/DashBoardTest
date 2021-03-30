package com.example.dashboardtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import javax.annotation.Nullable;

public class ListeAct extends AppCompatActivity {

    ListView listView;
    String mTitle[]={"Tennis", "Foot", "Basket", "Volley", "Boxe"};
    String mDesc[]={"Facebook desc", "Whatsapp desc","Twitter desc","Instagram desc","Youtube desc"};
    int image[]={R.drawable.facebook,R.drawable.whats,R.drawable.twitter,R.drawable.insta,R.drawable.youtube};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listeact);

        listView = findViewById(R.id.listView);

        MyAdapter adapter= new MyAdapter(this, mTitle,mDesc,image);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent= new Intent(getApplicationContext(), Activite.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("Image",image[0]);
                    intent.putExtras(bundle);
                    intent.putExtra("Title",mTitle[0]);
                    intent.putExtra("Desc",mDesc[0]);
                    intent.putExtra("pos",""+0);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent= new Intent(getApplicationContext(), Activite.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("Image",image[1]);
                    intent.putExtras(bundle);
                    intent.putExtra("Title",mTitle[1]);
                    intent.putExtra("Desc",mDesc[1]);
                    intent.putExtra("pos",""+1);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent= new Intent(getApplicationContext(), Activite.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("Image",image[2]);
                    intent.putExtras(bundle);
                    intent.putExtra("Title",mTitle[2]);
                    intent.putExtra("Desc",mDesc[2]);
                    intent.putExtra("pos",""+2);
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent= new Intent(getApplicationContext(), Activite.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("Image",image[3]);
                    intent.putExtras(bundle);
                    intent.putExtra("Title",mTitle[3]);
                    intent.putExtra("Desc",mDesc[3]);
                    intent.putExtra("pos",""+3);
                    startActivity(intent);
                }
                if(position==4){
                    Intent intent= new Intent(getApplicationContext(), Activite.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("Image",image[4]);
                    intent.putExtras(bundle);
                    intent.putExtra("Title",mTitle[4]);
                    intent.putExtra("Desc",mDesc[4]);
                    intent.putExtra("pos",""+4);
                    startActivity(intent);
                }
            }
        });
    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDesc[];
        int rImage[];

        MyAdapter(Context c, String title[], String desc[], int imgs[]){
                super(c,R.layout.row,R.id.textView1,title);
                this.context =c;
                this.rTitle = title;
                this.rDesc = desc;
                this.rImage=imgs;
            }

            @androidx.annotation.NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
                LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View row= layoutInflater.inflate((R.layout.row), parent, false);
                ImageView images = row.findViewById(R.id.image);
                TextView myTitle = row.findViewById(R.id.textView1);
                TextView myDescription = row.findViewById(R.id.textView2);

                images.setImageResource(rImage[position]);
                myTitle.setText(rTitle[position]);
                myDescription.setText(rDesc[position]);

                return row;
        }
    }
}
