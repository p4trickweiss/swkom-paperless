package at.fhtw.swkom.paperless.controller.interfaces;

import at.fhtw.swkom.paperless.controller.generated.ApiUtil;
import at.fhtw.swkom.paperless.services.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

public interface ITagsController {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /api/tags
     *
     * @param page  (optional)
     * @param fullPerms  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "getTags",
            tags = { "Tags" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GetTags200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/tags/",
            produces = { "application/json" }
    )
    default ResponseEntity<GetTags200Response> getTags(
            @Parameter(name = "page", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "page", required = false) Integer page,
            @Parameter(name = "full_perms", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "full_perms", required = false) Boolean fullPerms
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{\"count\":0,\"next\":null,\"previous\":null,\"all\":[],\"results\":[]}";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * POST /api/tags
     *
     * @param createTagRequest  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "createTag",
            tags = { "Tags" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CreateTag200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/tags/",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<CreateTag200Response> createTag(
            @Parameter(name = "CreateTagRequest", description = "") @Valid @RequestBody(required = false) CreateTagRequest createTagRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"owner\" : 1, \"matching_algorithm\" : 6, \"user_can_change\" : true, \"color\" : \"color\", \"is_insensitive\" : true, \"name\" : \"name\", \"match\" : \"match\", \"id\" : 0, \"text_color\" : \"text_color\", \"is_inbox_tag\" : true, \"slug\" : \"slug\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * PUT /api/tags/{id}
     *
     * @param id  (required)
     * @param updateTagRequest  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "updateTag",
            tags = { "Tags" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateTag200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/api/tags/{id}/",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<UpdateTag200Response> updateTag(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
            @Parameter(name = "UpdateTagRequest", description = "") @Valid @RequestBody(required = false) UpdateTagRequest updateTagRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"owner\" : 5, \"matching_algorithm\" : 6, \"user_can_change\" : true, \"document_count\" : 1, \"color\" : \"color\", \"is_insensitive\" : true, \"name\" : \"name\", \"match\" : \"match\", \"id\" : 0, \"text_color\" : \"text_color\", \"is_inbox_tag\" : true, \"slug\" : \"slug\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * DELETE /api/tags/{id}
     *
     * @param id  (required)
     * @return Success (status code 204)
     */
    @Operation(
            operationId = "deleteTag",
            tags = { "Tags" },
            responses = {
                    @ApiResponse(responseCode = "204", description = "Success")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/api/tags/{id}/"
    )
    default ResponseEntity<Void> deleteTag(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
