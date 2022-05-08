package sg.edu.np.mad.mad_exercise3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.flwbutton);

        User ur = UserDetails();

        // Follow button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ur.followed == false) {
                    ur.followed = true;
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();

                } else {
                    ur.followed = false;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                follow(ur, btn);
            }
        });

        // ListActivity
        TextView text = findViewById(R.id.userid);
        Intent receivingEnd = getIntent();
        Integer getid = receivingEnd.getIntExtra("id",1);
        String s = String.format("MAD %d", getid);
        text.setText(s);

        // Message button
        Button msgbtn = findViewById(R.id.msgbutton);
        msgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent msgact = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(msgact);
            }
        });
    }


    // Methods

    public User UserDetails() {
        User ur = new User("MAD", "Week 2 practical", 1, false);
        return ur;
    }

    public void follow(User ur, Button btn) {

        TextView txt = btn;
        if (ur.followed == false) {
            txt.setText("Follow");
        } else {
            txt.setText("Unfollow");
        }
    }
}

