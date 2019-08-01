package io.ozguraslan.ppmtool.web;

import io.ozguraslan.ppmtool.domain.Project;
import io.ozguraslan.ppmtool.exception.ProjectIdException;
import io.ozguraslan.ppmtool.service.MapValidationErrorService;
import io.ozguraslan.ppmtool.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;


    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){//binding request ile bir tane result elde edersin

        ResponseEntity<?> errorMap = mapValidationErrorService.errorValidation(result);
        if(errorMap!=null){
            return errorMap;
        }
        projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> findProjectByIdentifier(@PathVariable String projectId){
        Project project = projectService.findProjectBYIdentifier(projectId);
        if(project == null){
            throw new ProjectIdException("The project with "+projectId+" does not exist");
        }

        return new ResponseEntity<Project>(project,HttpStatus.OK);
    }
}
