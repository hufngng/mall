# Variables
# Detect mvnw, if not found use system mvn
MVN := $(shell if [ -f ./mvnw ]; then echo ./mvnw; else echo mvn; fi)

# Default module name if 'm' is not provided
m ?= all

.PHONY: all build clean install test package run help

# Internal helper to handle -pl argument
# If m=all, we don't add the -pl flag (runs on entire project)
ifeq ($(m),all)
    PL_FLAG :=
else
    PL_FLAG := -pl $(m) -am
endif

## build: Compile the source code (use m=module-name to target specific module)
build:
	@echo "==> Building module: $(m)..."
	$(MVN) compile $(PL_FLAG)

## clean: Remove build artifacts
clean:
	@echo "==> Cleaning $(m)..."
	$(MVN) clean $(PL_FLAG)

## install: Build and install to local repository
install:
	@echo "==> Installing $(m)..."
	$(MVN) install $(PL_FLAG) -DskipTests -Ddocker.skip=true

## package: Create a JAR file
package:
	@echo "==> Packaging $(m)..."
	$(MVN) package $(PL_FLAG) -DskipTests -Ddocker.skip=true

## run: Start a Spring Boot module
run:
	@echo "==> Starting Spring Boot module: $(m)..."
	$(MVN) spring-boot:run -pl $(m)

## help: Display this help message
help:
	@echo "Usage:"
	@echo "  make [target] m=[module-name]"
	@echo ""
	@echo "Examples:"
	@echo "  make install            # Install all modules"
	@echo "  make build m=core-lib   # Build only core-lib"
	@echo "  make run m=api-service  # Run api-service"
	@echo ""
	@echo "Targets:"
	@sed -n 's/^##//p' Makefile
