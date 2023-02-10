package io.claiton;

import feign.Headers;
import feign.RequestLine;

interface EchoAPI {

    @RequestLine("POST /post")
    @Headers({
        "Accept: application/json",
        "Content-Type: application/json"
    })
    String echo(String body);
}
