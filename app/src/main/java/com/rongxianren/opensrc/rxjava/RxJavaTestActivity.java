package com.rongxianren.opensrc.rxjava;

import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.rongxianren.opensrc.R;
import com.rongxianren.opensrc.rxjava.backpressure.BackPressure;
import com.rongxianren.opensrc.rxjava.backpressure.FlowableBackPressure;
import com.rongxianren.opensrc.rxjava.operators.MergeOperators;
import com.rongxianren.opensrc.rxjava.subscribeFlow.MyEmitter;
import com.rongxianren.opensrc.rxjava.subscribeFlow.MyObservable;
import com.rongxianren.opensrc.rxjava.subscribeFlow.MyObservableOSubscribe;
import com.rongxianren.opensrc.rxjava.subscribeFlow.MyObserver;
import com.rongxianren.opensrc.rxjava.threadswitch.ThreadSwitch;

public class RxJavaTestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava_activity_main);
        ////hahha
    }

    public void mergeTest(View view) {
        MergeOperators.merge();

    }

    public void switcherSubscribeLight(View view) {
        LightAndSwitcher lightAndSwitcher = new LightAndSwitcher();
        lightAndSwitcher.lightSubscribeSwitcher();
    }


    public void threadSwitch(View view) {
        ThreadSwitch threadSwitch = new ThreadSwitch();
        threadSwitch.threadSwitch();
    }

    public void flatMap(View view) {

    }


    public void simulateRxJava(View view) {
        MyObservable<String> observable = MyObservable.create(new MyObservableOSubscribe<String>() {
            @Override
            public void subscribe(MyEmitter<String> emitter) {
                emitter.onext("手动模仿rxJava的订阅触发流程");
            }
        });

        observable
                .opreator()
                .opreator()
                .opreator()
                .subscribe(
                        new MyObserver<String>() {
                            @Override
                            public void next(String item) {
                                System.out.println(item);
                            }
                        }
                );
    }

    public void backPressure(View view) {
        BackPressure backPressure = new BackPressure();
        backPressure.backpressure();
    }

    public void flowableBackPressure(View view) {
        FlowableBackPressure flowableBackPressure = new FlowableBackPressure();
        flowableBackPressure.backPressure();
    }
}
