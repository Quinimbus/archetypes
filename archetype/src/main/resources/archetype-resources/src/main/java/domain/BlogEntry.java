package ${package}.domain;

import cloud.quinimbus.binarystore.persistence.EmbeddableBinary;
import cloud.quinimbus.common.annotations.modelling.Naming;
import cloud.quinimbus.common.annotations.modelling.References;
import cloud.quinimbus.common.annotations.modelling.Searchable;
import cloud.quinimbus.magic.annotations.GenerateAdminListView;
import cloud.quinimbus.magic.annotations.GenerateRepository;
import cloud.quinimbus.magic.annotations.GenerateRestEndpoints;
import cloud.quinimbus.persistence.api.annotation.Entity;
import cloud.quinimbus.persistence.api.annotation.EntityField;
import cloud.quinimbus.persistence.api.annotation.EntityIdField;
import cloud.quinimbus.persistence.api.annotation.GenerateID;
import cloud.quinimbus.persistence.api.annotation.Schema;
import java.time.LocalDate;
import java.util.List;

@Entity(schema = @Schema(id = "${artifactId}", version = 1))
@GenerateRepository
@GenerateRestEndpoints
@GenerateAdminListView
public record BlogEntry(
        @EntityIdField(generate = @GenerateID(generate = true, generator = "friendly")) String uid,
        @Naming @Searchable String title,
        String text,
        @EntityField(type = String.class) List<String> tags,
        LocalDate published,
        EmbeddableBinary image,
        @References(Category.class) String category) {}
