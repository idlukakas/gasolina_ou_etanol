package br.com.bossini.tipcalculatorfatecipinoite;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private NumberFormat percentFormat =
            NumberFormat.getPercentInstance();
    private double billAmount = 0;
    private double percent = 0.15;

    private TextView percentEthanolTextView;
    private TextView percentGasTextView;
    private SeekBar percentEthanolSeekBar;
    private SeekBar percentGasSeekBar;
    private TextInputLayout tipTextView;
    private ImageView ethanolImageView;
    private ImageView gasImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        percentEthanolTextView = findViewById(R.id.percentEthanolTextView);
        percentEthanolSeekBar = findViewById(R.id.percentEthanolSeekBar);
        percentGasTextView = findViewById(R.id.percentGasTextView);
        percentGasSeekBar = findViewById(R.id.percentGasSeekBar);
        tipTextView = findViewById(R.id.tipTextView);

        percentEthanolSeekBar.
                setOnSeekBarChangeListener(seekBarChangeListener);
        percentGasSeekBar.
                setOnSeekBarChangeListener(seekBarChangeListener);
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    percent = progress / 100.;
                    percentEthanolTextView.setText(percentFormat.format(percent));
                    double tip = percent * billAmount;
                    double billTotal = tip + billAmount;
//                    tipTextView.setText(currencyFormat.format(tip));
//                    totalTextView.setText(currencyFormat.format(billTotal));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };
}
