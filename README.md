# cursos
>- https://udemy.com/course/desarrollo-con-quarkus-docker-y-graalvm-el-futuro-de-java/learn/lecture/27405784#overview
>- https://udemy.com/course/quarkus-starting-with-quarkus/learn/lecture/25098418#overview

# code-with-quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```
### https://developers.redhat.com/articles/2022/03/03/rest-api-error-modeling-quarkus-20#model_the_error_response
import com.fasterxml.jackson.annotation.JsonInclude;

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and Jakarta Persistence

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)



### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

### jakarta
https://blog.jetbrains.com/idea/2021/02/creating-a-simple-jakarta-persistence-application/

### agregar extensiones
./mvnw quarkus:add-extension -Dextension="quarkus-smallrye-openapi"

### ubicación de error
http://localhost:8765/q/swagger-ui/

### página web
http://localhost:8765/Product.html

### ubicación de swagger
http://localhost:8765/q/swaggerui/

## ruta de comando
https://github.com/agoncal/agoncal-course-quarkus-starting/blob/master/bootstrap.sh

```shell script
mvn -U io.quarkus:quarkus-maven-plugin:create \
-DprojectGroupId=org.agoncal.quarkus.starting \
-DprojectArtifactId=rest-book \
-DclassName="org.agoncal.quarkus.starting.BookResource" \
-Dpath="/api/books" \
-Dextensions="resteasy-jsonb" 
```

```shell script
mvn -U io.quarkus:quarkus-maven-plugin:create \
-DprojectGroupId=org.programacionparaaprender.quarkus.starting \
-DprojectArtifactId=rest-book \
-DclassName="org.programacionparaaprender.quarkus.starting.BookResource" \
-Dpath="/api/books" \
-Dextensions="resteasy-jsonb" 
```




```shell script
./mvnw quarkus:dev
```

```shell script
./mvnw test
./mvnw test -Dbooks.genre=IT
```

```shell script
curl http://localhost:8765/api/books/hello
curl http://localhost:8765/api/books/1
curl http://localhost:8765/api/books
curl http://localhost:8765/api/books/count
```

## configuración
>- http://localhost:8765/q/dev-ui/configuration-form-editor

>- %dev
>- %test
>- %prod
>- custom

```
mvn quarkus:dev
mvn test
java -jar
-Dquarkus.profile
```

```
./mvnw quarkus:dev
./mvnw quarkus:dev -Dquarkus.profile=staging
```

```
./mvnw package
java -jar target/quarkus-app/quarkus-run.jar
mvn package
mvn package -Dquarkus.package.type=jar
mvn package -Dquarkus.package.type=legacy-jar
mvn package -Dquarkus.package.type=uber-jar
java -jar target/quarkus-app/quarkus-run.jar
```

# otros comandos
```
mvn package -DskipTests -Dquarkus.package.type=uber-jar
java -jar target/rest-book-1.0.0-SNAPSHOT-runner.jar
```


```
mvn package -Dquarkus.package.type=native
target\rest-book-1.0.0-SNAPSHOT-runner.exe
mvn verify -Pnative
mvn package -Pnative
./target/rest-book-runner
```

```
mvn quarkus:add-extension -Dextensions="container-image-docker"
mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=jar
mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=legacy -Dquarkus.container-image.tag=jvm
mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=jar -Dquarkus.container-image.tag=jvm

mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=jar
mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=legacy-jar
docker run -i --rm -p 8080:8080 agoncal/rest-book:1.0-SNAPSHOT
```

```
mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=jar -Dquarkus.container-image.tag=jvm
docker run -i --rm -p 8080:8080 luis1/rest-book:jvm
```


```shell script
systemctl status docker
docker ps -a
docker image ls
docker image ls | grep luis1
docker run -i --rm -p 8765:8765 luis1/rest-book:jvm 
docker build -f src/main/docker/Dockerfile.jvm -t luis13711/rest-book-jvm .
docker run -i --rm -p 8080:8080 luis13711/rest-book-jvm 
```

# de esta forma funciona
```
mvn package
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/rest-book-jvm .
docker run -i --rm -p 8765:8765 quarkus/rest-book-jvm 
```

# nuevo comando
```
mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=native
mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=native -Dquarkus.container-image.build=true -Dquarkus.package.type=jar -Dquarkus.container-image.tag=native
docker run -i --rm -p 8765:8765 luis1/rest-book:native
```