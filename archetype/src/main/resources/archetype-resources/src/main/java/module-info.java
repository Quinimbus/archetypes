open module $package {
    requires cloud.quinimbus.binarystore.persistence;
    requires cloud.quinimbus.common.annotations;
    requires cloud.quinimbus.magic.annotations;
    requires cloud.quinimbus.persistence.api;
    requires cloud.quinimbus.persistence.cdi;
    requires cloud.quinimbus.persistence.repositories;
    requires cloud.quinimbus.persistence.storage.mongo;
    requires cloud.quinimbus.rest;
    requires cloud.quinimbus.rest.crud;
    requires cloud.quinimbus.tools;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires jakarta.annotation;
    requires jakarta.cdi;
    requires jakarta.inject;
    requires jakarta.ws.rs;
    requires static java.compiler;
    requires java.logging;
    requires org.mapstruct;
    requires quarkus.core;
}
