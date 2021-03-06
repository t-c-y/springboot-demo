package com.tcy.config.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tongchengyu
 */
@ControllerAdvice
public class GlobalErrorHandler {

    private static final Integer OK = 200;
    private static final Integer ERROR = 403;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> defaultErrorHandler(HttpServletRequest req, Exception e) {
        ErrorInfo<String> r = new ErrorInfo<String>();
        r.setCode(ERROR);
        r.setMessage(e.getMessage());
        r.setData("全局自定义异常");
        r.setUrl(req.getRequestURI());
        return r;
    }

    public class ErrorInfo<T> {

        private int code;
        private String message;
        private String url;
        private T data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "ErrorInfo{" +
                    ", code=" + code +
                    ", message='" + message + '\'' +
                    ", url='" + url + '\'' +
                    ", data=" + data +
                    '}';
        }
    }
}
