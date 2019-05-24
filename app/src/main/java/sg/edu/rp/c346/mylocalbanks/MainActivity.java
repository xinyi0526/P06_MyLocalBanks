package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText1;
    TextView tvTranslatedText2;
    TextView tvTranslatedText3;
    int mode = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText1 = findViewById(R.id.textView);
        tvTranslatedText2 = findViewById(R.id.textView2);
        tvTranslatedText3 = findViewById(R.id.textView3);

        registerForContextMenu(tvTranslatedText1);
        registerForContextMenu(tvTranslatedText2);
        registerForContextMenu(tvTranslatedText3);


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"website");
        menu.add(0,1,1,"Contact the bank");

        if(v.getId()==R.id.textView){
            mode =1;
        }else if(v.getId()==R.id.textView2){
            mode = 2;
        }else{
            mode =3;
        }
        Log.d("Test",""+v.getId()+" "+mode);




    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getItemId()==0){
            if(mode==1){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            }else if(mode==2){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            }else if(mode==3){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            }
        }else if(item.getItemId()==1){
            if(mode ==1){
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + 1800+1111111));
                startActivity(intent);
            }else if(mode ==2){
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + 1800+3633333));
                startActivity(intent);
            }else if(mode==3){
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + 1800+2222121));
                startActivity(intent);
            }
        }


        return super.onContextItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvTranslatedText1.setText("DBS");
            tvTranslatedText2.setText("OCBC");
            tvTranslatedText3.setText("UOB");
            return true;
        }else if (id == R.id.chineseSelection) {
            tvTranslatedText1.setText("星展银行");
            tvTranslatedText2.setText("华侨银行");
            tvTranslatedText3.setText("大华银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
