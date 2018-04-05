package cn.com.BaseFrame.Vo;

import java.util.List;

/**
 * @author huangy
 * @Description: 前台数据封装
 * @Date 2018/03/20 19:00
 **/
public class DataVo {

    private List<? extends Object> datalist;

    public List<? extends Object> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<? extends Object> datalist) {
        this.datalist = datalist;
    }

}
