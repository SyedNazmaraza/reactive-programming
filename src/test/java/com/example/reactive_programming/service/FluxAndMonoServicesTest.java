package com.example.reactive_programming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoServicesTest {
    FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

    @Test
    void fruitsFlux() {
        var flux = fluxAndMonoServices.fruitsFlux();
        StepVerifier.create(flux)
                .expectNext("apple","orange","mango")
                .verifyComplete();
    }

    @Test
    void fruitsMono() {
        var mono = fluxAndMonoServices.fruitsMono();
        StepVerifier.create(mono)
                .expectNext("apple")
                .verifyComplete();
    }

    @Test
    void fruitsFluxMap() {
        var fluxMap = fluxAndMonoServices.fruitsFluxMap();
        StepVerifier.create(fluxMap)
                .expectNext("APPLE","ORANGE","MANGO")
                .verifyComplete();
    }
}