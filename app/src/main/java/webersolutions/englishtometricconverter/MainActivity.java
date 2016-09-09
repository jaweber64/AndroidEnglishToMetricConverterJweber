package webersolutions.englishtometricconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

// CDM 290 Java App Development I       Janet Weber     9/8/16
// Create an app that converts English measurements to Metric
// Include all the most common conversions on the first page of your UI

public class MainActivity extends AppCompatActivity {

    double qty;
    double metricResult;
    int convChoice;
    String outputTxt1 = "", outputTxt2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText numUnits  = (EditText)findViewById(R.id.txtNumUnits);
        final Spinner conversion = (Spinner)findViewById(R.id.txtConversion);
        Button convert = (Button)findViewById(R.id.btnConvert);
        convert.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.txtResult));

            @Override
            public void onClick(View view) {
                // Get the quantity of English units
                qty = Double.parseDouble(numUnits.getText().toString());

                // Set the format of the Metric result - precision to 4 decimal places.
                DecimalFormat metricPrecision = new DecimalFormat("###,###,###.####");

                // Get the conversion choice - actually the index of user selection
                convChoice = conversion.getSelectedItemPosition();
                // Based on the choice, perform the required calculation. Prepare for output units.
                switch (convChoice) {
                   case 0: metricResult = 2.54 * qty;
                       outputTxt1 = " inches --> ";
                       outputTxt2 = " centimeters";
                       break;
                    case 1: metricResult = .3 * qty;
                        outputTxt1 = " feet --> ";
                        outputTxt2 = " meters";
                        break;
                    case 2: metricResult = .91 * qty;
                        outputTxt1 = " yards --> ";
                        outputTxt2 = " meters";
                        break;
                    case 3: metricResult = 1.61 * qty;
                        outputTxt1 = " miles --> ";
                        outputTxt2 = " kilometers";
                        break;
                    case 4: metricResult = .96 * qty;
                        outputTxt1 = " quarts --> ";
                        outputTxt2 = " liters";
                        break;
                    case 5: metricResult = 3.8 * qty;
                        outputTxt1 = " gallons --> ";
                        outputTxt2 = " liters";
                        break;
                    case 6: metricResult = 28.35 * qty;
                        outputTxt1 = " ounces --> ";
                        outputTxt2 = " grams";
                        break;
                    case 7: metricResult = .45 * qty;
                        outputTxt1 = " pounds --> ";
                        outputTxt2 = " kilograms";
                        break;
                    default:
                }
                // display the result by using strings and results from switch statement.
                result.setText(qty + outputTxt1 + metricPrecision.format(metricResult) + outputTxt2);

            }  // end of onClick()
        });  // end of setOnClickLisener()
    } // end of onCreate()
} // end of MainActivity()
