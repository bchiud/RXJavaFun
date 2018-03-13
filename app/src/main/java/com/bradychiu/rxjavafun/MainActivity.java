package com.bradychiu.rxjavafun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.jakewharton.rxbinding2.view.RxView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;
    private Observable<String> someObservable;
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.some_button);
        mTextView = (TextView) findViewById(R.id.some_textview);

        // mButton.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View v) {
        //         Toast.makeText(MainActivity.this, "RxView.clicks", Toast.LENGTH_SHORT).show();
        //     }
        // });


        RxView.clicks(mButton)
                .subscribe(aVoid -> {
                    Log.d(TAG, "Button clicked");
                    Toast.makeText(MainActivity.this, "RxView.clicks", Toast.LENGTH_SHORT).show();
                    mTextView.append("\nButton Clicked");
                });




        // mButton.setOnClickListener(v -> Observable.just("Button clicked"));

        // Observer<String> observer = new Observer<String>() {
        //     @Override
        //     public void onSubscribe(Disposable d) {
        //         Log.d(TAG, "Observer onSubscribe");
        //     }
        //
        //     @Override
        //     public void onNext(String s) {
        //         Log.d(TAG, "Observer onNext");
        //         mTextView.append("\n" + s);
        //     }
        //
        //     @Override
        //     public void onError(Throwable e) {
        //         Log.d(TAG, "Observer onError");
        //     }
        //
        //     @Override
        //     public void onComplete() {
        //         Log.d(TAG, "Observer onComplete");
        //         mTextView.append("\nComplete");
        //     }
        // };


    }
}
