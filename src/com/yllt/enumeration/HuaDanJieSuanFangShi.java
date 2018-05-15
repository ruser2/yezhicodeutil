package com.yllt.enumeration;

/**
 * Created by Administrator on 2016/3/7.
 */
public enum  HuaDanJieSuanFangShi {

    //    ALLSTATE(0),//所有状态
    XIANJIN(1),//, "启用"),
    GUAZHANG(0);


    private Integer value;

    HuaDanJieSuanFangShi(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public String toString() {
        return "HuaDanJieSuanFangShi{" +
                "value=" + value +
                '}';
    }
}
