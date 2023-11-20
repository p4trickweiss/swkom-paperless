package at.fhtw.swkom.paperless.controller.impl;

import at.fhtw.swkom.paperless.controller.ITagsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class TagsController implements ITagsController {
    private final NativeWebRequest request;

    @Autowired
    public TagsController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
}
