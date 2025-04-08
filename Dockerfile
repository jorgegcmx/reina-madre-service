ARG BUILD_IMAGE=maven:3.9.8-amazoncorretto-21-al2023
ARG RUNTIME_IMAGE=amazoncorretto:21
ARG AZURE_PROJECT_ID=reina-madre

#############################################################################################
###                Stage where Docker is pulling all maven dependencies                   ###
#############################################################################################
FROM ${BUILD_IMAGE} as dependencies

WORKDIR /app

COPY pom.xml ./


#############################################################################################

#############################################################################################
###              Stage where Docker is building spring boot app using maven               ###
#############################################################################################
FROM dependencies as build

COPY src ./src

RUN mkdir ./target

RUN mvn clean package

#############################################################################################



#############################################################################################
###   Image config                                   Main stage                                      ###
#############################################################################################

FROM ${RUNTIME_IMAGE} as main

ARG TARGET_DIR=target

WORKDIR /opt/app

EXPOSE 8080

COPY --from=build /app/target/*.jar /opt/app/service.jar


ENTRYPOINT ["java","-jar","/opt/app/service.jar"]