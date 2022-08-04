package dam.jsoup.updatereport.updatreport.robot.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cytern
 * @DATE 2022年6月21日14:59:33
 * @desc 比较多的对外接口的参数校验中，body体数据结构复杂且很多业务数据并不在方法中使用，构建实体类使用springValidate有些笨重。
 * 多数仅需校验是否为空即可。此注解可以对json中的键值做非空校验
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonNullValidate {
    /**
     * 校验的keys
     */
    String[] keys() default {};

    /**
     * type 为1 抛出app异常
     */
    int type() default 1;
}
