package com.huatec.edu.mobileshop.http.presenter;

import com.huatec.edu.mobileshop.http.HttpMethods;
import com.huatec.edu.mobileshop.http.entity.GoodsEntity;
import com.huatec.edu.mobileshop.http.entity.MemberEntity;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class GoodsPresenter extends HttpMethods{
    public static void listByKeywords(Subscriber<MemberEntity> subscriber, String keywords){
        Observable observable=goodsService.listByKeywords(keywords)
                .map(new HttpResultFunc<List<GoodsEntity>>());
        toSubscribe(observable,subscriber);
    }

    public static void list(Subscriber<List<GoodsEntity>>subscriber,int catId){
        Observable<List<GoodsEntity>>observable=goodsService.list(catId)
                .map(new HttpResultFunc<List<GoodsEntity>>());
        toSubscribe(observable,subscriber);
    }
}
