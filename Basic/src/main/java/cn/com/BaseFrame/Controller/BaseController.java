package cn.com.BaseFrame.Controller;

import cn.com.BaseFrame.BaseUtils.BeanUtils.BeanUtils;
import cn.com.BaseFrame.Pojo.BaseControllerContext;
import cn.com.BaseFrame.Pojo.BaseServiceParamModel;
import cn.com.BaseFrame.Pojo.BaseServiceResultModel;
import java.lang.reflect.Method;

/**
 * controller基础类
 *
 * @author xyh
 * @create 2018-02-23 22:18
 **/
public class BaseController extends BaseDispatcherController {
    /**
     *  在每次执行方法之前,都要先来调用这里,这里就需要考虑要传递哪些参数.
     *      1.要执行的方法。
     *          参数 : 执行方法的类 : Class clazz : 需要执行方法类的Class
     *                要执行的方法名称 ： String methodName
     *                可能方法重载了,所以要通过参数来确定 : paramModel（因为所有的参数类都继承自BaseParamModel,所以传递一个BaseParamModel即可）
     *
     *      2.在方法执行前要进行哪些判断
     *          A.判断用户是否有权限执行该方法
     *              如何判断,在数据库里面进行配置,然后再session中取值
     *
     *          B.用户是不是直接通过url直接来访问,跳过了登录这一步
     *
     */

    public BaseServiceResultModel invokeMethod(Class clazz, String methodName, BaseServiceParamModel paramModel, BaseControllerContext context){
        //获取到需要执行方法的实体类
        Object object = BeanUtils.getBean(clazz);

        beforeInvoke();

        try {
            //获取到对应的方法
            Method method = clazz.getMethod(methodName,paramModel.getClass());

            /**
             *  执行service中的方法
             */
            BaseServiceResultModel srModel = (BaseServiceResultModel) method.invoke(object,paramModel);

            afterInvoke();

            return srModel;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     *  @Description: 在方法调用之前执行
     *  @author xyh
     *  @Date 22:57 2018/3/5
     *  @method beforeInvoke
     *  params  
     *  @return 
     *  @exception 
     **/
    public void beforeInvoke() {
    
    }
    
    /**
     *  @Description: 在方法调用之后执行
     *  @author xyh
     *  @Date 22:57 2018/3/5
     *  @method afterInvoke
     *  params  
     *  @return 
     *  @exception 
     **/
    public void afterInvoke() {

    }
}
