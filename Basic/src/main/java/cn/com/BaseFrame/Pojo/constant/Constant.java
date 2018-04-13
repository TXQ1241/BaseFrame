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
     * 当前用户
     */
    public static final String CURRENT_USER = "user";

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

    public interface PageSize {
        Integer NUM_FIVE = 5;
        Integer NUM_SIX = 6;
        Integer NUM_SEVEN = 7;
        Integer NUM_EIGHT = 8;
        Integer NUM_NINE = 9;
        Integer NUM_TEN = 10;
    }

    /**
     *  @Description: 用户管理常量接口
     *  @author huangy
     *  @Date 2018/4/11
     **/
    public interface UserConstants {
        /**
         * 用户类型
         */
        String SYSTEM_ADMIN = "0"; //系统管理员
        String SYSTEM_USER = "1"; //系统用户
        String GENERAL_USER = "2"; //普通用户
    }

}
