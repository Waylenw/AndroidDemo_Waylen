package com.example.rxjava;


import java.util.ArrayList;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created Waylenw on 2015/12/29.
 */
public class RxJavaHelper {

    /**
     * 基础概念
     */
    public static void  HelloWord(){
        //被观察者
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("Hello, world!");
                        sub.onCompleted();
                    }
                }
        );
        //观察者
        Subscriber<String>  observer=new Subscriber(){

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

            }
        };
        //订阅
        myObservable.subscribe(observer);
    }

    /**
     * 简化订阅(用于之接受不完整定义的回调事件)
     */
    public static void subscribeSplit(){
        //subscribe方法有一个重载版本，接受三个Action1类型的参数，分别对应OnNext，OnComplete， OnError函数。
        //myObservable.subscribe(onNextAction, onErrorAction, onCompleteAction);
        //这里我只关心成功的调用
       Observable.just("A","B","C").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {

            }
        });


    }
    /**
     * 转换(将一个对象转为另一个对象)
     */
    public static void subscribeChange(){
        Observable.just("1","2","2").map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {

                return Integer.valueOf(s);
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer o) {
                System.out.println(o);
            }
        });


    }
    /**
     * 转换(将一个对象转为另一个对象)
     */
    public static void subscribeOpeator(){
        //多个城市对应多个城市结果
        Observable.just("1").flatMap(new Func1<String, Observable<?>>() {
            @Override
            public Observable<?> call(String s) {
                return null;
            }
        });


    }
    /**
     * 过滤
     */
    public static void _RxJavaFilter(){
        //将大于100的内容过滤
        ArrayList<Integer> list=new ArrayList<>();
        list.add(90);
        list.add(100);
        list.add(101);
        list.add(102);
        final ArrayList<Integer> newlist=new ArrayList<>();

        Observable.from(list).filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer>100;
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                newlist.add(integer);
            }
        });
    }
    /**
     * 线程调度
     */
    public static void _RxJavaSchedulers(){
        Observable.just("A","B").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {

                    }
                });


    }

    /**
     * 防止重复点击
     */
    public  static void _RxjavaOnclick(){
//        RxView.clickEvents(button) // RxBinding 代码，后面的文章有解释
//                .throttleFirst(500, TimeUnit.MILLISECONDS) // 设置防抖间隔为 500ms
//                .subscribe(subscriber);
    }
    /**
     * lift
     *
     * 述 lift() 的原理只是为了让你更好地了解 RxJava ，从而可以更好地使用它。然而不管你是否理解了 lift() 的原理，
     * RxJava 都不建议开发者自定义 Operator 来直接使用 lift()，
     * 而是建议尽量使用已有的 lift() 包装方法（如 map() flatMap() 等）进行组合来实现需求，因为直接使用 lift() 非常容易发生一些难以发现的错误。
     */
    public  static void _Rxjavalift(){
        Observable.just("123").lift(new Observable.Operator<Object, String>() {
            @Override
            public Subscriber<? super String> call(Subscriber<? super Object> subscriber) {
                return null;
            }
        });
    }



}
