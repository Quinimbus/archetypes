package ${package}.domain;

import cloud.quinimbus.common.annotations.modelling.Owner;
import cloud.quinimbus.common.annotations.modelling.Searchable;
import cloud.quinimbus.magic.annotations.GenerateAdminListView;
import cloud.quinimbus.magic.annotations.GenerateRepository;
import cloud.quinimbus.magic.annotations.GenerateRestEndpoints;
import cloud.quinimbus.persistence.api.annotation.Entity;
import cloud.quinimbus.persistence.api.annotation.EntityIdField;
import cloud.quinimbus.persistence.api.annotation.Schema;
import java.time.LocalDate;

@Entity(schema = @Schema(id = "${artifactId}", version = 1))
@GenerateRepository
@GenerateRestEndpoints
@GenerateAdminListView
@Owner(owningEntity = BlogEntry.class, field = "blogEntry")
public record BlogEntryComment(
        @EntityIdField String uid, @Searchable String title, String text, LocalDate published, String blogEntry) {}
