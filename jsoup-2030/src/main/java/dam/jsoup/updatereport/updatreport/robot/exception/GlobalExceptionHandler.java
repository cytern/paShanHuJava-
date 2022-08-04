package dam.jsoup.updatereport.updatreport.robot.exception;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.pojo.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.List;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2020/3/25
 * @Description: ~
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);






    @ExceptionHandler(value = Exception.class)
    public JSONObject handleException(Exception e) {
        logger.error("发生异常 原因是:", e);
        return ApiResult.fail(e.getMessage());
    }

    @ExceptionHandler(value = RobotException.class)
    public JSONObject handleAppException(RobotException e) {
        logger.error("发生异常 原因是:", e);
        return ApiResult.fail(e.getMessage());
    }

}
