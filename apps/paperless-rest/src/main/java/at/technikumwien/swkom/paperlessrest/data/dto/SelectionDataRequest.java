package at.technikumwien.swkom.paperlessrest.data.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * SelectionDataRequest
 */

@JsonTypeName("SelectionData_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-18T10:57:25.027163Z[Etc/UTC]")
public class SelectionDataRequest {

  @Valid
  private List<Integer> documents = new ArrayList<>();

  public SelectionDataRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SelectionDataRequest(List<Integer> documents) {
    this.documents = documents;
  }

  public SelectionDataRequest documents(List<Integer> documents) {
    this.documents = documents;
    return this;
  }

  public SelectionDataRequest addDocumentsItem(Integer documentsItem) {
    if (this.documents == null) {
      this.documents = new ArrayList<>();
    }
    this.documents.add(documentsItem);
    return this;
  }

  /**
   * Get documents
   * @return documents
  */
  @NotNull 
  @Schema(name = "documents", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("documents")
  public List<Integer> getDocuments() {
    return documents;
  }

  public void setDocuments(List<Integer> documents) {
    this.documents = documents;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelectionDataRequest selectionDataRequest = (SelectionDataRequest) o;
    return Objects.equals(this.documents, selectionDataRequest.documents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(documents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectionDataRequest {\n");
    sb.append("    documents: ").append(toIndentedString(documents)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

