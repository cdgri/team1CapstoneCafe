package teamcapstonecafe.infra;
import teamcapstonecafe.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class PushMessageHateoasProcessor implements RepresentationModelProcessor<EntityModel<PushMessage>>  {

    @Override
    public EntityModel<PushMessage> process(EntityModel<PushMessage> model) {

        
        return model;
    }
    
}
