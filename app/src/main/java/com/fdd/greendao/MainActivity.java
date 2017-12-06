package com.fdd.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.fdd.greendao.db.DBUtil;
import com.fdd.greendao.db.DaoSession;
import com.fdd.greendao.db.PersonBean;
import com.fdd.greendao.db.PersonBeanDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private DaoSession mDaoSession;
    private PersonBeanDao mPersonDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDaoSession = DBUtil.getInstance(this).getDaoSession();
    }

    public void onMainClick(View view){
        switch (view.getId()){
            case R.id.bt_add:
                mPersonDao = mDaoSession.getPersonBeanDao();
                PersonBean bean = new PersonBean();
                bean.setName("张三");
                bean.setAge(20);
                bean.setAddress("郑州升龙");
                mPersonDao.insert(bean);
                break;
            case R.id.bt_delete:
                mPersonDao.deleteAll();
                break;
            case R.id.bt_query:
                List<PersonBean> personBeens = mPersonDao.loadAll();
                for (PersonBean be:personBeens) {
                    Log.d(TAG, be.toString());
                }
                break;
            case R.id.bt_update:

                break;
        }
    }

}
