all: prepare run
PACKAGE_PATH=target
VERSION=4.0
PROJECT_NAME=SmartCalc-$(VERSION)
FILENAME=$(PROJECT_NAME).jar

clean:
	rm -rf $(PACKAGE_PATH)
	./mvnw clean
	make -C src/main/cpp clean
	rm -rf src/main/resources/lib/*.dylib src/test/resources/lib/*.dylib src/main/java/edu/school/calc/*.class
	find . -name ".DS_Store" -type f -delete

prepare: clean
	./mvnw package -DskipTests

run: open
	@if [ -f $(PACKAGE_PATH)/$(FILENAME) ]; then \
	java -jar $(PACKAGE_PATH)/$(FILENAME); \
	else \
	echo not found: $(PACKAGE_PATH)/$(FILENAME); \
	fi

open:
	@if [ -f $(PACKAGE_PATH)/$(FILENAME) ]; then \
	open -a 'google chrome' http://localhost:8080; \
	else \
	echo not found: $(PACKAGE_PATH)/$(FILENAME); \
	fi

test:
	./mvnw test

report: test
	open -a 'google chrome' target/site/jacoco/edu.school.calc/PageController.html
