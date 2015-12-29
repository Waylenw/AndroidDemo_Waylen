package com.example.rxjava;


import java.util.Observer;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

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
     * 简化订阅(用于之接受事件)
     */
    public static void subscribeSplit(){
        //ubscribe方法有一个重载版本，接受三个Action1类型的参数，分别对应OnNext，OnComplete， OnError函数。
        //myObservable.subscribe(onNextAction, onErrorAction, onCompleteAction);
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
        Observable.just("1").flatMap(new Func1<String, Observable<?>>() {
            @Override
            public Observable<?> call(String s) {
                return null;
            }
        });


    }


}
