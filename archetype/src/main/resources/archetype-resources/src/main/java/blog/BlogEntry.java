package ${package}.blog;

import cloud.quinimbus.magic.annotations.GenerateRepository;
import cloud.quinimbus.magic.annotations.GenerateRestEndpoints;
import cloud.quinimbus.persistence.api.annotation.Entity;
import cloud.quinimbus.persistence.api.annotation.EntityField;
import cloud.quinimbus.persistence.api.annotation.EntityIdField;
import cloud.quinimbus.persistence.api.annotation.Schema;
import cloud.quinimbus.persistence.api.annotation.Searchable;
import java.time.LocalDate;
import java.util.List;

@Entity(schema = @Schema(id = "qnblog", version = 1))
@GenerateRepository
@GenerateRestEndpoints
public record BlogEntry(
        @EntityIdField String uid,
        @Searchable String title,
        String text,
        @EntityField(type = String.class) List<String> tags,
        LocalDate published
        ) {
    
}
