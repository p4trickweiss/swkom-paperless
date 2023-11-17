package at.fhtw.swkom.paperless.controller;

import at.fhtw.swkom.paperless.controller.generated.ApiUtil;
import at.fhtw.swkom.paperless.data.dto.*;
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

public interface ILoginController {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api
     *
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "root",
            tags = { "Login" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/"
    )
    default ResponseEntity<Void> root(

    ) {
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * GET /api
     *
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "apiGet",
            tags = { "Login" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/"
    )
    default ResponseEntity<Void> apiGet(

    ) {
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * GET /api/statistics
     *
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "statistics",
            tags = { "Login" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Statistics200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/statistics/",
            produces = { "application/json" }
    )
    default ResponseEntity<Statistics200Response> statistics(

    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = """
                            {
                                "documents_total": 0,
                                "documents_inbox": null,
                                "inbox_tag": null,
                                "document_file_type_counts": 0,
                                "character_count": null
                            }
                            """;
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * POST /api/token
     *
     * @param userInfo  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "getToken",
            tags = { "Login" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/token/",
            consumes = { "application/json", "text/json", "application/*+json" }
    )
    default ResponseEntity<Void> getToken(
            @Parameter(name = "UserInfo", description = "") @Valid @RequestBody(required = false) UserInfo userInfo
    ) {
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * GET /api/groups
     *
     * @param page  (optional)
     * @param pageSize  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "getGroups",
            tags = { "Login" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GetGroups200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/groups/",
            produces = { "application/json" }
    )
    default ResponseEntity<GetGroups200Response> getGroups(
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
     * POST /api/groups
     *
     * @param createGroupRequest  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "createGroup",
            tags = { "Login" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/groups/",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<Object> createGroup(
            @Parameter(name = "CreateGroupRequest", description = "") @Valid @RequestBody(required = false) CreateGroupRequest createGroupRequest
    ) {
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * PUT /api/groups/{id}
     *
     * @param id  (required)
     * @param updateGroupRequest  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "updateGroup",
            tags = { "Login" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateGroup200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/api/groups/{id}/",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<UpdateGroup200Response> updateGroup(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
            @Parameter(name = "UpdateGroupRequest", description = "") @Valid @RequestBody(required = false) UpdateGroupRequest updateGroupRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"permissions\" : [ \"permissions\", \"permissions\" ], \"name\" : \"name\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * DELETE /api/groups/{id}
     *
     * @param id  (required)
     * @return Success (status code 204)
     */
    @Operation(
            operationId = "deleteGroup",
            tags = { "Login" },
            responses = {
                    @ApiResponse(responseCode = "204", description = "Success")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/api/groups/{id}/"
    )
    default ResponseEntity<Void> deleteGroup(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * GET /api/users
     *
     * @param page  (optional)
     * @param pageSize  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "getUsers",
            tags = { "Login" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GetUsers200Response.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/users/",
            produces = { "application/json" }
    )
    default ResponseEntity<GetUsers200Response> getUsers(
            @Parameter(name = "page", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "page", required = false) Integer page,
            @Parameter(name = "page_size", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "page_size", required = false) Integer pageSize
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = """
                            {
                                "count": 1,
                                "next": null,
                                "previous": null,
                                "all": [
                                    3
                                ],
                                "results": [
                                    {
                                        "id": 3,
                                        "username": "demo",
                                        "email": "demo@localhost",
                                        "password": "**********",
                                        "first_name": "",
                                        "last_name": "",
                                        "date_joined": "2023-10-13T20:49:13.178865+02:00",
                                        "is_staff": true,
                                        "is_active": true,
                                        "is_superuser": true,
                                        "groups": [],
                                        "user_permissions": [],
                                        "inherited_permissions": [
                                            "paperless_mail.view_mailrule",
                                            "sessions.add_session",
                                            "contenttypes.delete_contenttype",
                                            "documents.change_tag",
                                            "documents.view_storagepath",
                                            "auth.change_permission",
                                            "documents.change_paperlesstask",
                                            "django_celery_results.delete_chordcounter",
                                            "documents.change_documenttype",
                                            "paperless_mail.delete_processedmail",
                                            "documents.view_savedview",
                                            "auth.delete_group",
                                            "documents.change_savedview",
                                            "documents.add_uisettings",
                                            "documents.view_uisettings",
                                            "auth.change_user",
                                            "documents.delete_log",
                                            "documents.add_note",
                                            "documents.delete_savedview",
                                            "documents.change_document",
                                            "paperless_mail.view_processedmail",
                                            "contenttypes.add_contenttype",
                                            "documents.change_correspondent",
                                            "documents.change_log",
                                            "documents.view_paperlesstask",
                                            "authtoken.view_token",
                                            "auth.view_permission",
                                            "admin.delete_logentry",
                                            "authtoken.view_tokenproxy",
                                            "sessions.delete_session",
                                            "documents.delete_document",
                                            "documents.delete_note",
                                            "django_celery_results.add_taskresult",
                                            "admin.add_logentry",
                                            "guardian.view_userobjectpermission",
                                            "documents.change_uisettings",
                                            "documents.add_log",
                                            "auth.add_permission",
                                            "documents.view_savedviewfilterrule",
                                            "admin.change_logentry",
                                            "documents.add_storagepath",
                                            "guardian.add_groupobjectpermission",
                                            "documents.view_tag",
                                            "django_celery_results.change_chordcounter",
                                            "admin.view_logentry",
                                            "authtoken.add_tokenproxy",
                                            "django_celery_results.delete_taskresult",
                                            "sessions.view_session",
                                            "auth.change_group",
                                            "documents.change_note",
                                            "paperless_mail.view_mailaccount",
                                            "django_celery_results.change_groupresult",
                                            "documents.delete_paperlesstask",
                                            "documents.delete_uisettings",
                                            "documents.add_tag",
                                            "auth.delete_permission",
                                            "auth.view_user",
                                            "paperless_mail.change_processedmail",
                                            "paperless_mail.change_mailaccount",
                                            "authtoken.delete_token",
                                            "guardian.change_groupobjectpermission",
                                            "authtoken.change_tokenproxy",
                                            "django_celery_results.view_groupresult",
                                            "paperless_mail.delete_mailrule",
                                            "authtoken.change_token",
                                            "documents.view_correspondent",
                                            "django_celery_results.delete_groupresult",
                                            "django_celery_results.view_chordcounter",
                                            "documents.add_document",
                                            "documents.delete_savedviewfilterrule",
                                            "documents.add_savedviewfilterrule",
                                            "django_celery_results.view_taskresult",
                                            "guardian.delete_groupobjectpermission",
                                            "documents.delete_tag",
                                            "django_celery_results.add_chordcounter",
                                            "documents.change_storagepath",
                                            "auth.delete_user",
                                            "auth.add_group",
                                            "guardian.delete_userobjectpermission",
                                            "authtoken.add_token",
                                            "documents.change_savedviewfilterrule",
                                            "django_celery_results.change_taskresult",
                                            "documents.view_note",
                                            "paperless_mail.delete_mailaccount",
                                            "guardian.change_userobjectpermission",
                                            "guardian.add_userobjectpermission",
                                            "documents.view_document",
                                            "documents.add_savedview",
                                            "auth.view_group",
                                            "auth.add_user",
                                            "guardian.view_groupobjectpermission",
                                            "documents.delete_documenttype",
                                            "contenttypes.change_contenttype",
                                            "documents.view_documenttype",
                                            "sessions.change_session",
                                            "documents.view_log",
                                            "paperless_mail.add_mailrule",
                                            "documents.add_paperlesstask",
                                            "documents.delete_storagepath",
                                            "authtoken.delete_tokenproxy",
                                            "contenttypes.view_contenttype",
                                            "paperless_mail.add_processedmail",
                                            "documents.add_correspondent",
                                            "documents.delete_correspondent",
                                            "paperless_mail.add_mailaccount",
                                            "documents.add_documenttype",
                                            "paperless_mail.change_mailrule",
                                            "django_celery_results.add_groupresult"
                                        ]
                                    }
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
     * POST /api/users
     *
     * @param createUserRequest  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "createUser",
            tags = { "Login" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GetUsers200ResponseResultsInner.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/users/",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<GetUsers200ResponseResultsInner> createUser(
            @Parameter(name = "CreateUserRequest", description = "") @Valid @RequestBody(required = false) CreateUserRequest createUserRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"is_active\" : true, \"is_superuser\" : true, \"user_permissions\" : [ \"\", \"\" ], \"is_staff\" : true, \"last_name\" : \"last_name\", \"groups\" : [ \"\", \"\" ], \"password\" : \"password\", \"id\" : 5, \"date_joined\" : \"date_joined\", \"first_name\" : \"first_name\", \"email\" : \"email\", \"username\" : \"username\", \"inherited_permissions\" : [ \"inherited_permissions\", \"inherited_permissions\" ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * PUT /api/users/{id}
     *
     * @param id  (required)
     * @param updateUserRequest  (optional)
     * @return Success (status code 200)
     */
    @Operation(
            operationId = "updateUser",
            tags = { "Login" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GetUsers200ResponseResultsInner.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/api/users/{id}/",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<GetUsers200ResponseResultsInner> updateUser(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
            @Parameter(name = "UpdateUserRequest", description = "") @Valid @RequestBody(required = false) UpdateUserRequest updateUserRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"is_active\" : true, \"is_superuser\" : true, \"user_permissions\" : [ \"\", \"\" ], \"is_staff\" : true, \"last_name\" : \"last_name\", \"groups\" : [ \"\", \"\" ], \"password\" : \"password\", \"id\" : 5, \"date_joined\" : \"date_joined\", \"first_name\" : \"first_name\", \"email\" : \"email\", \"username\" : \"username\", \"inherited_permissions\" : [ \"inherited_permissions\", \"inherited_permissions\" ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * DELETE /api/users/{id}
     *
     * @param id  (required)
     * @return Success (status code 204)
     */
    @Operation(
            operationId = "deleteUser",
            tags = { "Login" },
            responses = {
                    @ApiResponse(responseCode = "204", description = "Success")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/api/users/{id}/"
    )
    default ResponseEntity<Void> deleteUser(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
