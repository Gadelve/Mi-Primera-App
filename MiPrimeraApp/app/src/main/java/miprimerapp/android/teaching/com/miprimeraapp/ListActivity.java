package miprimerapp.android.teaching.com.miprimeraapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    String[] gameNames = { "Final Fantasy VII", "Final Fantasy VIII", "Final Fantasy X"};
    int[] gameIcons = { R.drawable.iconffvii, R.drawable.iconfviii, R.drawable.iconffx};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(new MyAdapter());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "Seleccionada posición " + position,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.list_item, parent, false);

            ImageView icon = rowView.findViewById(R.id.image_view);
            icon.setImageResource(gameIcons[position]);

            TextView textView = rowView.findViewById(R.id.text_view);
            textView.setText(gameNames[position]);

            return rowView;
        }
    }



}
