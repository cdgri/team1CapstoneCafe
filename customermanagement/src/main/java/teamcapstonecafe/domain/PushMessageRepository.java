package teamcapstonecafe.domain;

import teamcapstonecafe.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="pushMessages", path="pushMessages")
public interface PushMessageRepository extends PagingAndSortingRepository<PushMessage, Long>{

}
