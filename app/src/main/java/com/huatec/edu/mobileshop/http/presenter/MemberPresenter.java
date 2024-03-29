package com.huatec.edu.mobileshop.http.presenter;

import com.huatec.edu.mobileshop.http.HttpMethods;
import com.huatec.edu.mobileshop.http.entity.GoodsEntity;
import com.huatec.edu.mobileshop.http.entity.MemberEntity;


import java.util.List;


import rx.Observable;
import rx.Subscriber;


public class MemberPresenter extends HttpMethods{
    public static void register(Subscriber<MemberEntity> subscriber, String username, String email, String password){
        Observable observable=memberService.register(username,password,email)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);
    }

    public static void login2(Subscriber<MemberEntity> subscriber,String username,String password){
        Observable observable=memberService.login2(username,password)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);
    }

    public static void changePassword(Subscriber subscriber,String memberId,String old_pwd,String new_pwd){
        rx.Observable<List<GoodsEntity>> observable=memberService.changePassword(memberId,old_pwd,new_pwd);
        toSubscribe(observable,subscriber);
    }
}
