package io.ozguraslan.ppmtool.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {

    public ResponseEntity<?> errorValidation(BindingResult result){
        if(result.hasErrors()){//eger bu hata mesaji iceririse

            Map<String,String> errorMap = new HashMap<>();

            for(FieldError error : result.getFieldErrors()){//getfielderrors ile aldiklari her field erroru mapini icne atiyorsun
                errorMap.put(error.getField(), error.getDefaultMessage());//error ve mesaji
            }
            return new ResponseEntity<Map<String ,String >>(errorMap, HttpStatus.BAD_REQUEST);//verecegin hhtp requesti responseenitiy ile yazdiriyorsun
        }
        return  null;

    }

}
