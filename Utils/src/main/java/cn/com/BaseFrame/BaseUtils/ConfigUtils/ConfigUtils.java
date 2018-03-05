package cn.com.BaseFrame.BaseUtils.ConfigUtils;

import javax.servlet.http.HttpSession;

/**
 * 关于配置表的工具类
 *
 * @author xyh
 * @create 2018-03-05 16:43
 **/
public class ConfigUtils {
    private HttpSession session;

    public ConfigUtils() {
    }

    public ConfigUtils(HttpSession session) {
        this.session = session;
    }
}
