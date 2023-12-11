package at.technikumwien.swkom.paperlessrest.controller;

import at.technikumwien.swkom.paperlessrest.controller.generated.ApiUtil;
import at.technikumwien.swkom.paperlessrest.data.dto.CreateCorrespondentRequest;
import at.technikumwien.swkom.paperlessrest.data.dto.GetCorrespondents200Response;
import at.technikumwien.swkom.paperlessrest.data.dto.UpdateCorrespondent200Response;
import at.technikumwien.swkom.paperlessrest.data.dto.UpdateCorrespondentRequest;
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

public interface ICorrespondentsController {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /api/correspondents
     *
     * @param page  (optional)
     * @param fullPerms  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "getCorrespondents",
            tags = { "Correspondents" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GetCorrespondents200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/correspondents/",
            produces = { "application/json" }
    )
    default ResponseEntity<GetCorrespondents200Response> getCorrespondents(
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
     * POST /api/correspondents
     *
     * @param createCorrespondentRequest  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "createCorrespondent",
            tags = { "Correspondents" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CreateCorrespondentRequest.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/correspondents/",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<CreateCorrespondentRequest> createCorrespondent(
            @Parameter(name = "CreateCorrespondentRequest", description = "") @Valid @RequestBody(required = false) CreateCorrespondentRequest createCorrespondentRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"owner\" : 6, \"matching_algorithm\" : 0, \"is_insensitive\" : true, \"name\" : \"name\", \"match\" : \"match\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * PUT /api/correspondents/{id}
     *
     * @param id  (required)
     * @param updateCorrespondentRequest  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "updateCorrespondent",
            tags = { "Correspondents" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateCorrespondent200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/api/correspondents/{id}/",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<UpdateCorrespondent200Response> updateCorrespondent(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
            @Parameter(name = "UpdateCorrespondentRequest", description = "") @Valid @RequestBody(required = false) UpdateCorrespondentRequest updateCorrespondentRequest
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
     * DELETE /api/correspondents/{id}
     *
     * @param id  (required)
     * @return Success (status code 204)
     */
    @Operation(
            operationId = "deleteCorrespondent",
            tags = { "Correspondents" },
            responses = {
                    @ApiResponse(responseCode = "204", description = "Success")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/api/correspondents/{id}/"
    )
    default ResponseEntity<Void> deleteCorrespondent(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
