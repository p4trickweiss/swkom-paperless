/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package at.fhtw.swkom.paperless.controller.generated;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-18T10:57:25.027163Z[Etc/UTC]")
@Validated
@Tag(name = "Config", description = "the Config API")
public interface WsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /ws/status
     *
     * @return Success (status code 200)
     */
    @Operation(
        operationId = "get",
        tags = { "Config" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/ws/status/"
    )
    default ResponseEntity<Void> get(
        
    ) {
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
