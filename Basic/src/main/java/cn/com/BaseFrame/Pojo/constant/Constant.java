package cn.com.BaseFrame.Pojo.constant;

/**
 * 常量类,定义一系列常量
 *
 * @author xyh
 * @create 2018-03-06 11:20
 **/
public class Constant {

    public static final String ZERO = "0";
    public static final String ONE = "1";
    public static final Integer ZERO_NUM = 0;

    /**
     * 请求状态定义
     * @author huangy
     * @create 2018-03-16 18:50
     */
    public interface AjaxStatus {
         String AJAX_SUCCESS = "1";//请求成功
         String AJAX_FAIL = "0";//请求失败
    }

    /**
     *  数据请求状态码
     *  @author huangy
     *  @Date 2018/4/5
     **/
    public interface DataCode {
        String FAIL = "0";//失败
        String SUCCESS = "1";//成功
    }

    private interface PageSize {
        Integer NUM_FIVE = 5;
        Integer NUM_SIX = 6;
        Integer NUM_SEVEN = 7;
        Integer NUM_EIGHT = 8;
        Integer NUM_NINE = 9;
        Integer NUM_TEN = 10;
    }

}
