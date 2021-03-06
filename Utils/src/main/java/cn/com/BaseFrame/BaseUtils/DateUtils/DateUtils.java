package cn.com.BaseFrame.BaseUtils.DateUtils;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;

/**
 * 日期的工具类
 *
 * @author xyh
 * @create 2018-02-22 13:42
 **/
public class DateUtils implements Serializable {
    private static Calendar calendar = Calendar.getInstance(Locale.CHINA);

    /**
     * @return 返回当前月份有多少天
     * @throws
     * @Description: 获取当前月份有多少天
     * @author xyh
     * @Date 14:01 2018/2/22
     * @method getMaxDayForMonth
     * params
     **/
    public static int getMaxDayForMonth() {
        return calendar.getActualMaximum(Calendar.DATE);
    }

    /**
     * @return 返回当前月份
     * @throws
     * @Description: 获取当前是几月
     * @author xyh
     * @Date 14:03 2018/2/22
     * @method getMonth
     * params
     **/
    public static int getMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * @return 返回当前年份
     * @throws
     * @Description: 获取当前年份
     * @author xyh
     * @Date 14:03 2018/2/22
     * @method getMonth
     * params
     **/
    public static int getYear() {
        return calendar.get(Calendar.YEAR);
    }
}
