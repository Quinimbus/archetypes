group "default" {
    targets = ["backend", "admin-ui-source"]
}

variable "IMAGE_TAG" {
    default = "latest"
}

variable "IMAGE_REGISTRY" {
    default = ""
}

variable "IMAGE_NAME" {
    default = "${artifactId}"
}

target "backend" {
    context = "."
    dockerfile = "Dockerfile"
    target = "backend-final-stage"
    tags = ["${IMAGE_REGISTRY}${IMAGE_NAME}-backend:${IMAGE_TAG}"]
}

target "admin-ui-source" {
    context = "."
    dockerfile = "Dockerfile"
    target = "admin-ui-output-stage"
    output = ["type=local,dest=.docker-output"]
}

target "admin-ui" {
    context = ".docker-output/output/magic/admin-ui"
    dockerfile = "Dockerfile"
    tags = ["${IMAGE_REGISTRY}${IMAGE_NAME}-admin-ui:${IMAGE_TAG}"]
}
