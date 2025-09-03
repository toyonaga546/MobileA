package jp.ac.meijou.android.s241205123;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import javax.xml.transform.Result;

import jp.ac.meijou.android.s241205123.databinding.ActivityMain2Binding;
import jp.ac.meijou.android.s241205123.databinding.ActivityMain4Binding;

public class MainActivity4 extends AppCompatActivity {

    private ActivityMain4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        var editText = getIntent().getStringExtra("title");
        binding.textView4.setText(editText);

        binding.button8.setOnClickListener( v -> {
            var intent = new Intent();
            intent.putExtra("ret", "OK");
            setResult(RESULT_OK,intent);
            finish();
        });

        binding.button9.setOnClickListener(v ->{
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}