package at.technikumwien.swkom.paperlessrest.controller.impl;

import at.technikumwien.swkom.paperlessrest.controller.IDocumentTypesController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class DocumentTypesController implements IDocumentTypesController {
    private final NativeWebRequest request;

    @Autowired
    public DocumentTypesController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
}
