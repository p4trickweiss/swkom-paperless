package at.fhtw.swkom.paperless.data.mapper;

import org.mapstruct.Mapper;
import org.openapitools.jackson.nullable.JsonNullable;

@Mapper
public interface JsonNullableMapper {
    default <T> JsonNullable<T> map(T entity) {
        return JsonNullable.of(entity);
    }
    default <T> T map(JsonNullable<T> jsonNullable) {
        return jsonNullable == null ? null : jsonNullable.orElse(null);
    }
}