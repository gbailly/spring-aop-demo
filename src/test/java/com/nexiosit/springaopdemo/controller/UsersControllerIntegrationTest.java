package com.nexiosit.springaopdemo.controller;

import static io.restassured.RestAssured.given;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nexiosit.springaopdemo.SpringAopDemoApplication;
import com.nexiosit.springaopdemo.model.UserRequest;

import io.restassured.RestAssured;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = "server.port",
        classes = SpringAopDemoApplication.class)
@ActiveProfiles("test")
class UsersControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    @DisplayName("when querying for a user, then it should return the user")
    void getUser() {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/users/123")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(sameJSONAs("{\"id\":123,\"firstName\":\"Fred\",\"lastName\":\"Flintstone\"}"));
    }

    @Test
    @DisplayName("when creating a user, then it should create and return the user")
    void createUser() {
        final UserRequest user = new UserRequest("Wilma", "Flintstone");
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .body(user)
                .post("/users")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(sameJSONAs("{\"id\":456,\"firstName\":\"Wilma\",\"lastName\":\"Flintstone\"}"));
    }
}
