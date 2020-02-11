package com.rongxianren.opensrc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStore;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Debug;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Debug.startMethodTracing("browser.trace");


        Debug.stopMethodTracing();


    }


    public static void main(String[] args) {
//        String a = "abc";
//        String b = "abc";
//        System.out.println("a==b = " + (a == b));
//
//        String aa = new String("abc");
//        String bb = new String("abc");
//        System.out.println("aa==bb = " + (aa == bb));
//        System.out.println("aa.quals(bb) = " + (aa.equals(bb)));


        test_gc2();
    }

    private static void test_gc1() {

        String a = new String("wohenhao");

        SoftReference<?> softReference = new SoftReference(a);

        WeakReference<?> weakReference = new WeakReference(a);
        System.out.println("强引用：" + a + "\n软引用" + softReference.get() + "\n弱引用" + weakReference.get() + "\n");

        a = null;
        System.out.println("强引用：" + a + "\n软引用" + softReference.get() + "\n弱引用" + weakReference.get() + "\n");
        softReference.clear();
        System.gc();
        System.out.println("强引用：" + a + "\n软引用" + softReference.get() + "\n弱引用" + weakReference.get() + "\n");
    }

    private static void test_gc2() {

        String a = new String("wohenhao");

        SoftReference<?> softReference = new SoftReference("");

        ReferenceQueue referenceQueue = new ReferenceQueue<String>();
        WeakReference<?> weakReference = new WeakReference(a, referenceQueue);
        System.out.println("强引用：" + a + "\n软引用" + softReference.get() + "\n弱引用" + weakReference.get() + "\n");
        a = null;
        System.out.println("强引用：" + a + "\n软引用" + softReference.get() + "\n弱引用" + weakReference.get() + "\n");
//        softReference.clear();
        System.gc();
        Runtime.getRuntime().gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WeakReference<String> tempReference = (WeakReference<String>) referenceQueue.poll();
        System.out.println("tempReference.get() = " + tempReference.getClass());

        System.out.println("强引用：" + a + "\n软引用" + softReference.get() + "\n弱引用" + weakReference.get() + "\n");
    }
}
