package vn.ths.BTCuoiKhoa.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorAdviceController {

    public String findError(HttpStatus status){
        if(status.equals(HttpStatus.NOT_FOUND.isError())){
            return "/error/page404";
        } else if (status.equals(HttpStatus.INTERNAL_SERVER_ERROR.isError())) {
            return "/error/page500";
        } else if(status.equals(HttpStatus.BAD_REQUEST.isError())){
            return "/error/page400";
        }else if(status.equals(HttpStatus.UNAUTHORIZED.isError())){
            return "/error/page403";
        }else if(status.equals(HttpStatus.GATEWAY_TIMEOUT.isError())){
            return "/error/page400";
        }else if(status.equals(HttpStatus.SERVICE_UNAVAILABLE.isError())){
            return "/error/page400";
        }
        return null;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception ex) throws Exception{
        ModelAndView mv = null;
        HttpStatus status = (HttpStatus) request.getAttribute(HttpStatus.MULTI_STATUS.name());
        if (status != null) {
            String errorPage = findError(status);
            if (errorPage != null) {
                mv = new ModelAndView(errorPage);
            }
        }
        if (mv == null) { // Nếu không xác định được trang lỗi, sử dụng trang lỗi chung
            mv = new ModelAndView("/error/error");
        }
        mv.addObject("error", ex.getMessage());
        return mv;
    }

}
