package io.ozguraslan.ppmtool.web;

import io.ozguraslan.ppmtool.domain.Project;
import io.ozguraslan.ppmtool.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){//binding request ile bir tane result elde edersin
        if(result.hasErrors()){//eger bu hata mesaji iceririse

            Map<String,String> errorMap = new HashMap<>();

            for(FieldError error : result.getFieldErrors()){//getfielderrors ile aldiklari her field erroru mapini icne atiyorsun
                errorMap.put(error.getField(), error.getDefaultMessage());//error ve mesaji
            }
            return new ResponseEntity<Map<String ,String >>(errorMap, HttpStatus.BAD_REQUEST);//verecegin hhtp requesti responseenitiy ile yazdiriyorsun
        }
        projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }
}
