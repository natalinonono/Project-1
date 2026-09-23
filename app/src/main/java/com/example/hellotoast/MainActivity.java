package com.example.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    private static final String STATE_COUNT = "state_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = findViewById(R.id.show_count);

        // Restore state if available (e.g., after screen rotation)
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt(STATE_COUNT, 0);
            if (mShowCount != null) {
                mShowCount.setText(String.valueOf(mCount));
            }
        }
    }

    /**
     * Menampilkan pesan Toast ketika tombol Toast ditekan.
     */
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Menambah nilai hitungan dan memperbarui tampilan angka ketika tombol Count ditekan.
     */
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(String.valueOf(mCount));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_COUNT, mCount);
    }
}
