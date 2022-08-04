//package dam.jsoup.updatereport.updatreport.robot.aspect;
//
//import com.alibaba.fastjson.JSONObject;
//import dam.jsoup.updatereport.updatreport.robot.exception.RobotException;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 给app方法用的参数校验器 抛出app异常
// */
//@Aspect
//@Component
//@Slf4j
//public class JsonNullValidateAspect {
//    @Pointcut("execution(* *(..))")
//    public void controllerAspect() {
//    }
//
//    @Around("controllerAspect()")
//    public Object doAround(ProceedingJoinPoint point) throws Throwable {
//        //目标方法实体
//        Method method = ((MethodSignature) point.getSignature()).getMethod();
//        boolean hasMethodLogAnno = method
//                .isAnnotationPresent(JsonNullValidate.class);
//        //没加注解 直接执行返回结果
//        if (!hasMethodLogAnno) {
//            return point.proceed();
//        }
//        //方法注解实体
//        JsonNullValidate jsonNullValidate = method.getAnnotation(JsonNullValidate.class);
//        String[] keys = jsonNullValidate.keys();
//        int type = jsonNullValidate.type();
//        //获取方法的入参
//        MethodSignature signature = (MethodSignature) point.getSignature();
//        String[] methodParamNames = signature.getParameterNames();
//        Map<String, Object> argsMap = getArgsMap(point, methodParamNames);
//        validateArgsParams(argsMap, keys, type);
//        //执行目标方法内容，获取执行结果
//        return point.proceed();
//    }
//
//
//    /**
//     * 组装入参Map
//     *
//     * @param point            切点
//     * @param methodParamNames 　参数名称集合
//     */
//    private Map<String, Object> getArgsMap(ProceedingJoinPoint point,
//                                           String[] methodParamNames) {
//        HashMap<String, Object> result = new HashMap<>();
//        Object[] args = point.getArgs();
//        if (null == methodParamNames) {
//            return new HashMap<>();
//        }
//        for (int i = 0; i < methodParamNames.length; i++) {
//            result.put(methodParamNames[i], args[i]);
//        }
//        return result;
//    }
//
//    /**
//     * 校验参数
//     */
//    private void validateArgsParams(Map<String, Object> argsMap, String[] keys, int type) {
//        //获取第一个是json对象的参数
//        for (Map.Entry<String, Object> next : argsMap.entrySet()) {
//            String k = next.getKey();
//            Object v = next.getValue();
//            if (v instanceof JSONObject) {
//                JSONObject body = (JSONObject) v;
//                for (String key : keys) {
//                    if (key.contains("$")) {
//                        String[] sKey = key.split("\\.");
//                        if (sKey.length > 1) {
//                            JSONObject nowBody = new JSONObject(body);
//                            for (int i = 1; i < sKey.length; i++) {
//                                if (!nowBody.containsKey(sKey[i])) {
//                                    throw new RobotException("参数不完整 缺少 " + key);
//                                } else {
//                                    if (i != sKey.length - 1) {
//                                        nowBody = nowBody.getJSONObject(sKey[i]);
//                                    }
//                                }
//                            }
//                        }
//                    } else {
//                        if (!body.containsKey(key)) {
//                            if (type == 1) {
//                                throw new RobotException("参数不完整 缺少 " + key);
//                            } else {
//                                throw new RobotException("参数不完整 缺少 " + key);
//                            }
//                        }
//                    }
//                }
//            }
//            return;
//        }
//    }
//
//}
