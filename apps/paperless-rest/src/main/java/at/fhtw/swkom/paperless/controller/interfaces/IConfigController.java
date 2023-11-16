package at.fhtw.swkom.paperless.controller.interfaces;

import at.fhtw.swkom.paperless.controller.generated.ApiUtil;
import at.fhtw.swkom.paperless.data.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

public interface IConfigController {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /api/saved_views
     *
     * @param page  (optional)
     * @param pageSize  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "getSavedViews",
            tags = { "Config" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GetSavedViews200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/saved_views/",
            produces = { "application/json" }
    )
    default ResponseEntity<GetSavedViews200Response> getSavedViews(
            @Parameter(name = "page", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "page", required = false) Integer page,
            @Parameter(name = "page_size", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "page_size", required = false) Integer pageSize
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
     * POST /api/saved_views
     *
     * @param createSavedViewsRequest  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "createSavedViews",
            tags = { "Config" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/saved_views/",
            consumes = { "application/json" }
    )
    default ResponseEntity<Void> createSavedViews(
            @Parameter(name = "CreateSavedViewsRequest", description = "") @Valid @RequestBody(required = false) CreateSavedViewsRequest createSavedViewsRequest
    ) {
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * GET /api/storage_paths
     *
     * @param page  (optional)
     * @param fullPerms  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "getStoragePaths",
            tags = { "Config" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GetStoragePaths200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/storage_paths/",
            produces = { "application/json" }
    )
    default ResponseEntity<GetStoragePaths200Response> getStoragePaths(
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
     * POST /api/storage_paths
     *
     * @param createStoragePathRequest  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "createStoragePath",
            tags = { "Config" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CreateStoragePath200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/storage_paths/",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<CreateStoragePath200Response> createStoragePath(
            @Parameter(name = "CreateStoragePathRequest", description = "") @Valid @RequestBody(required = false) CreateStoragePathRequest createStoragePathRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"owner\" : 1, \"path\" : \"path\", \"matching_algorithm\" : 6, \"user_can_change\" : true, \"is_insensitive\" : true, \"name\" : \"name\", \"match\" : \"match\", \"id\" : 0, \"slug\" : \"slug\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * PUT /api/storage_paths/{id}
     *
     * @param id  (required)
     * @param updateStoragePathRequest  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "updateStoragePath",
            tags = { "Config" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateStoragePath200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/api/storage_paths/{id}/",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<UpdateStoragePath200Response> updateStoragePath(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
            @Parameter(name = "UpdateStoragePathRequest", description = "") @Valid @RequestBody(required = false) UpdateStoragePathRequest updateStoragePathRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"owner\" : 5, \"path\" : \"path\", \"matching_algorithm\" : 6, \"user_can_change\" : true, \"document_count\" : 1, \"is_insensitive\" : true, \"name\" : \"name\", \"match\" : \"match\", \"id\" : 0, \"slug\" : \"slug\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * DELETE /api/storage_paths/{id}
     *
     * @param id  (required)
     * @return Success (status code 204)
     */
    @Operation(
            operationId = "deleteStoragePath",
            tags = { "Config" },
            responses = {
                    @ApiResponse(responseCode = "204", description = "Success")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/api/storage_paths/{id}/"
    )
    default ResponseEntity<Void> deleteStoragePath(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * GET /api/logs
     *
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "getLogs",
            tags = { "Config" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = String.class)))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/logs/",
            produces = { "application/json" }
    )
    default ResponseEntity<List<String>> getLogs(

    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ \"\", \"\" ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * GET /api/logs/{id}
     *
     * @param id  (required)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "getLog",
            tags = { "Config" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = String.class)))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/logs/{id}/",
            produces = { "application/json" }
    )
    default ResponseEntity<List<String>> getLog(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ \"\", \"\" ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * GET /api/ui_settings
     *
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "getUISettings",
            tags = { "Config" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GetUISettings200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/ui_settings/",
            produces = { "application/json" }
    )
    default ResponseEntity<GetUISettings200Response> getUISettings(

    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = """
                            {
                                "user": {
                                    "id": 3,
                                    "username": "demo",
                                    "is_superuser": true,
                                    "groups": []
                                },
                                "settings": {
                                    "tour_complete": true,
                                    "update_checking": {
                                        "backend_setting": "default"
                                    }
                                },
                                "permissions": [
                                    "delete_note",
                                    "view_permission",
                                    "add_mailrule",
                                    "delete_contenttype",
                                    "change_paperlesstask",
                                    "change_permission",
                                    "change_chordcounter",
                                    "delete_mailaccount",
                                    "change_tag",
                                    "view_paperlesstask",
                                    "add_tokenproxy",
                                    "delete_chordcounter",
                                    "delete_userobjectpermission",
                                    "change_savedviewfilterrule",
                                    "view_chordcounter",
                                    "delete_groupobjectpermission",
                                    "add_groupobjectpermission",
                                    "delete_savedviewfilterrule",
                                    "view_storagepath",
                                    "change_savedview",
                                    "view_mailaccount",
                                    "add_userobjectpermission",
                                    "add_note",
                                    "add_storagepath",
                                    "delete_documenttype",
                                    "view_group",
                                    "change_documenttype",
                                    "add_chordcounter",
                                    "change_note",
                                    "delete_groupresult",
                                    "change_document",
                                    "view_user",
                                    "change_taskresult",
                                    "add_log",
                                    "view_groupresult",
                                    "delete_permission",
                                    "view_tag",
                                    "view_correspondent",
                                    "view_processedmail",
                                    "view_logentry",
                                    "view_session",
                                    "change_contenttype",
                                    "add_savedviewfilterrule",
                                    "view_documenttype",
                                    "add_session",
                                    "change_logentry",
                                    "add_paperlesstask",
                                    "view_savedview",
                                    "add_savedview",
                                    "delete_correspondent",
                                    "change_uisettings",
                                    "change_tokenproxy",
                                    "view_mailrule",
                                    "add_uisettings",
                                    "view_taskresult",
                                    "change_token",
                                    "view_token",
                                    "change_correspondent",
                                    "delete_paperlesstask",
                                    "change_groupresult",
                                    "add_mailaccount",
                                    "add_document",
                                    "view_userobjectpermission",
                                    "change_storagepath",
                                    "delete_taskresult",
                                    "delete_log",
                                    "view_groupobjectpermission",
                                    "delete_user",
                                    "delete_document",
                                    "add_contenttype",
                                    "delete_processedmail",
                                    "delete_session",
                                    "add_permission",
                                    "change_userobjectpermission",
                                    "view_document",
                                    "add_tag",
                                    "add_correspondent",
                                    "delete_uisettings",
                                    "view_uisettings",
                                    "add_logentry",
                                    "delete_token",
                                    "view_note",
                                    "change_mailrule",
                                    "add_processedmail",
                                    "change_group",
                                    "delete_storagepath",
                                    "change_user",
                                    "add_user",
                                    "delete_logentry",
                                    "view_log",
                                    "change_session",
                                    "add_taskresult",
                                    "add_groupresult",
                                    "delete_mailrule",
                                    "view_tokenproxy",
                                    "add_token",
                                    "view_contenttype",
                                    "change_groupobjectpermission",
                                    "view_savedviewfilterrule",
                                    "delete_group",
                                    "add_documenttype",
                                    "add_group",
                                    "delete_savedview",
                                    "change_log",
                                    "change_mailaccount",
                                    "delete_tokenproxy",
                                    "change_processedmail",
                                    "delete_tag"
                                ]
                            }""";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * POST /api/ui_settings
     *
     * @param createUISettingsRequest  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "createUISettings",
            tags = { "Config" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CreateUISettings200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/ui_settings/",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<CreateUISettings200Response> createUISettings(
            @Parameter(name = "CreateUISettingsRequest", description = "") @Valid @RequestBody(required = false) CreateUISettingsRequest createUISettingsRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : true }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
