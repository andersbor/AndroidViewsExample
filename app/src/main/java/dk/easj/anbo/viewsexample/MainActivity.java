package dk.easj.anbo.viewsexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Register");

        setupSpinnerEventHandler();
        setupRadioButtonListener();
        setupSwitch();
    }

    private void setupRadioButtonListener() {
        final RadioGroup genderView = findViewById(R.id.mainGenderRadioGroup);
        genderView.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            // https://stackoverflow.com/questions/6780981/android-radiogroup-how-to-configure-the-event-listener
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //Log.d("MINE", "radio " + checkedId);
                RadioButton checkedRadioButton = genderView.findViewById(checkedId);
                boolean isChecked = checkedRadioButton.isChecked();
                Log.d("MINE", "Radio button " + checkedRadioButton.getText() + " is checked");
            }
        });
    }

    private void setupSpinnerEventHandler() {
        final Spinner spinner = findViewById(R.id.mainCountrySpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Object obj = spinner.getItemAtPosition(position);
                Log.d("MINE", obj.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // No action
            }
        });
    }

    private void setupSwitch() {
        Switch newsStitch = findViewById(R.id.mainNewsSwitch);
        newsStitch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        Log.d("MINE", "Switch " + isChecked);
                        EditText commentsView = findViewById(R.id.mainCommentsEditText);
                        if (isChecked)
                            commentsView.setVisibility(View.VISIBLE);
                        else commentsView.setVisibility(View.GONE);
                    }
                });
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
