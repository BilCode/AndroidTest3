package learn.b.btest;

import android.app.Fragment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements MessageCom {

    ListView lvTest;
    Handler handler,handler2;
    TextView tvTest,tvTest2;
    DownFragment fragmentDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTest = (TextView) findViewById(R.id.tvTest);
        tvTest2 = (TextView) findViewById(R.id.tvTest2);
        fragmentDown =(DownFragment)getFragmentManager().findFragmentById(R.id.downfrag);

        //lvTest = (ListView) findViewById(R.id.lvTest);

       // lvTest.setAdapter(new ListAdaptor(MainActivity.this));

        handler = new Handler();
        handler2 = new Handler();

        final Runnable r = new Runnable(){
            int a=0;
            @Override
            public void run() {
                //System.out.println("Test ");
                tvTest.setText("One "+a++);

                handler.postDelayed( this, 1000);
            }
        };

        final Runnable r2 = new Runnable(){
            int a=0;
            @Override
            public void run() {
                //System.out.println("Test ");
                tvTest2.setText("Two "+ (a+=2));

                handler.postDelayed( this, 1000);
            }
        };

        handler.postDelayed(r, 1000);

        handler2.postDelayed(r2, 1000);

        //sendMessage();
    }

    @Override
    public void sendMessage() {
        fragmentDown.updateMessage();
    }
}
