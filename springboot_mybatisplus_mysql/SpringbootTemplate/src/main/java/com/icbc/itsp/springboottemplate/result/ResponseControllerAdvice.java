package com.icbc.itsp.springboottemplate.result;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = {"com.icbc.itsp.springboottemplate.controller"})
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass){
        return !returnType.getGenericParameterType().equals(Result.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest request, ServerHttpResponse response){
        Result result = new Result();
        if(returnType.getGenericParameterType().equals(String.class)){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                result.setResults(data);
                return objectMapper.writeValueAsString(response);
            }catch (JsonProcessingException e){
                throw new ApiException("返回的String类型错误");
            }
        }else if (returnType.getGenericParameterType().equals(Result.class)){
            return data;
        }else {
            result.setResults(data);
            return result;
        }
    }

}
