package dk.easj.anbo.viewsexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Register");
    }

    public void registerButtonClicked(View view) {
        EditText nameView = findViewById(R.id.mainNameEditText);
        String name = nameView.getText().toString();
        Spinner spinner = findViewById(R.id.mainCountrySpinner);
        String country = (String) spinner.getSelectedItem();

        RadioGroup genderView = findViewById(R.id.mainGenderRadioGroup);
        int id = genderView.getCheckedRadioButtonId();
        Person.Gender gender = (id == R.id.mainRadioMale) ? Person.Gender.Male : Person.Gender.Female;

        Switch newsStitch = findViewById(R.id.mainNewsSwitch);
        boolean news = newsStitch.isChecked();

        Person person = new Person(name, country, gender, news);
        Log.d("MINE", person.toString());

        Intent intent = new Intent(this, AnotherActivity.class);
        intent.putExtra(AnotherActivity.PERSON, person);
        startActivity(intent);
    }
}
