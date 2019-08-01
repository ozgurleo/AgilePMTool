package io.ozguraslan.ppmtool.repository;

import io.ozguraslan.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>{
    @Override
    Iterable findAllById(Iterable iterable);
//    Project save(Project project);
    Project findByProjectIdentifier(String projectId);


}