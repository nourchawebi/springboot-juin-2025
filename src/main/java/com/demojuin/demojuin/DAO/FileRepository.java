package com.demojuin.demojuin.DAO;

import com.demojuin.demojuin.model.File;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FileRepository extends MongoRepository<File,String> {
    Optional<File> findByFilename(String filename);
    boolean existsByFilename(String filename);
    /*@Query("{'filename': ?0}")
      Optional<File> getFileByFilename(String filename);
    @Query(value = "{'filename': ?0}", exists = true)
    boolean existsFilename(String filename);
    @Query("{'size':{ $gte:?0, $lte:?1}}")
    List<File> findfilesinsizerange(Long minSize,Long maxSize);
    @Query("{'filename': {$regex: ?0,$options: 'i'}}")
      List<File>searchfilebykeyword(String keyword);
@Query(value="{'filename':?0}", delete=true)
void deletebyfilename(String filename);*/
}