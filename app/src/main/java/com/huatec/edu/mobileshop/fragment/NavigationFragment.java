package com.huatec.edu.mobileshop.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.media.Image;
import android.view.View;
import android.widget.ImageButton;
import com.huatec.edu.mobileshop.R;


import com.huatec.edu.mobileshop.common.BaseFragment;

public class NavigationFragment extends BaseFragment implements View.OnClickListener {

    private ImageButton mIbHome;
    private ImageButton mIbCategroy;
    private ImageButton mIdCart;
    private ImageButton mIbPersonal;
    private HomeFragment homeFragment;
    private CategroyFragment categroyFragment;
    private CartFragment cartFragment;
    private PersonalFragment personalFragment;

    @Override
    public int getContentViewId(){return R.layout.fragment_navigation;}

    @Override
    protected void initView(View view){
        super.initView(view);
        mIbHome=view.findViewById(R.id.ib_home);
        mIbCategroy=view.findViewById(R.id.ib_categroy);
        mIdCart=view.findViewById(R.id.ib_cart);
        mIbPersonal=view.findViewById(R.id.ib_personal);
        mIbHome.setOnClickListener(this);
        mIbCategroy.setOnClickListener(this);
        mIdCart.setOnClickListener(this);
        mIbPersonal.setOnClickListener(this);

        select(mIbHome);
    }

    private void select(View v){
        mIbHome.setImageResource(R.drawable.tab_item_home_normal);
        mIbCategroy.setImageResource(R.drawable.tab_item_categroy_normal);
        mIdCart.setImageResource(R.drawable.tab_item_cart_normal);
        mIbPersonal.setImageResource(R.drawable.tab_item_personal_normal);
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        if(homeFragment!=null){
            fragmentTransaction.hide(homeFragment);
        }
        if(categroyFragment!=null){
            fragmentTransaction.hide(categroyFragment);
        }
        if(cartFragment!=null){
            fragmentTransaction.hide(cartFragment);
        }
        if(personalFragment!=null){
            fragmentTransaction.hide(personalFragment);
        }
        switch(v.getId()){
            case R.id.ib_home:
                mIbHome.setImageResource(R.drawable.tab_item_home_focus);
                if(homeFragment==null){
                    homeFragment=new HomeFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,homeFragment);
                }else {
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.ib_categroy:
                mIbCategroy.setImageResource(R.drawable.tab_item_categroy_focus);
                if(categroyFragment==null){
                    categroyFragment=new CategroyFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,categroyFragment);
                }else {
                    fragmentTransaction.show(categroyFragment);
                }
                break;
            case R.id.ib_cart:
                mIdCart.setImageResource(R.drawable.tab_item_cart_focus);
                if(cartFragment==null){
                    cartFragment=new CartFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,cartFragment);
                }else {
                    fragmentTransaction.show(cartFragment);
                }
                break;
            case R.id.ib_personal:
                mIbPersonal.setImageResource(R.drawable.tab_item_personal_focus);
                if(personalFragment==null){
                    personalFragment=new PersonalFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,personalFragment);
                }else {
                    fragmentTransaction.show(personalFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v){
        select(v);
    }
}
