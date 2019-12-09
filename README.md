# spring-aop-demo

Demo for illustrating AOP concepts with the Spring framework in Java.

## Application

To start the application:

    $ mvn spring-boot:run

## Endpoints

To retrieve a user, use the following URL:

    $ curl -X GET \
        http://localhost:9876/users/123 \
        -H 'Content-Type: application/json' \
        -H 'Postman-Token: df1de567-ca05-4340-a2d4-76ead9820e4f' \
        -H 'cache-control: no-cache'

To create a user, use the following URL:

    $ curl -X POST \
        http://localhost:9876/users \
        -H 'Accept: */*' \
        -H 'Accept-Encoding: gzip, deflate' \
        -H 'Cache-Control: no-cache' \
        -H 'Connection: keep-alive' \
        -H 'Content-Length: 57' \
        -H 'Content-Type: application/json' \
        -H 'Host: localhost:9876' \
        -H 'Postman-Token: a51e23e7-2555-446b-96ec-c269ca54cac2,d08a8e1b-9fd0-4820-9ce6-02b5a289ea25' \
        -H 'User-Agent: PostmanRuntime/7.20.1' \
        -H 'cache-control: no-cache' \
        -d '{
        "firstName": "Wilma",
        "lastName": "Flintstone"
        }'

## Tests

To run the tests:

    $ mvn test
