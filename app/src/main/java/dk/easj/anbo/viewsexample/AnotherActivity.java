package dk.easj.anbo.viewsexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class AnotherActivity extends AppCompatActivity {
    public static final String PERSON ="person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Intent data = getIntent();
        Person person = (Person)data.getSerializableExtra(PERSON);
        Log.d("MINE", ""+person.toString());
    }
}
