package com.goyin.mvp.model;


import com.goyin.mvp.base.BasePresenter;
import com.goyin.mvp.base.BaseView;
import com.goyin.mvp.model.annotation.Implement;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class ContractProxy {
    private static final ContractProxy m_instance = new ContractProxy();

    public static ContractProxy getInstance() {
        return m_instance;
    }

    private ContractProxy() {
        m_objects = new HashMap<>();
    }

    private Map<Class, Object> m_objects;

    public void init(Class... clss) {
        for (Class cls : clss) {
            if (cls.isAnnotationPresent(Implement.class)) {
//                list.add(cls);
                for (Annotation ann : cls.getDeclaredAnnotations()) {
                    if (ann instanceof Implement) {
                        try {
                            m_objects.put(cls, ((Implement) ann).value().newInstance());
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    // 初始化presenter add map
    public <T> T bind(Class clzz, BaseView var1) {
        if (!m_objects.containsKey(clzz)) {
            init(clzz);
        }
        BasePresenter presenter = ((BasePresenter) m_objects.get(clzz));
        if (var1 != presenter.getView()) {
            if (presenter.getView() != null) {
                presenter.detachView();
            }
            presenter.attachView(var1);
        }
        return (T) presenter;
    }

    // 解除绑定 移除map
    public void unbind(Class clzz, BaseView var1) {
        if (m_objects.containsKey(clzz)) {
            BasePresenter presenter = ((BasePresenter) m_objects.get(clzz));
            if (var1 != presenter.getView()) {
                if (presenter.getView() != null)
                    presenter.detachView();
                m_objects.remove(clzz);
            }

        }
    }
}