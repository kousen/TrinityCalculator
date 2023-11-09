package edu.trinity.astro;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AstroServiceTest {
    private final AstroService astroService = new AstroService();

    @Test
    void getAstroData() throws Exception {
        String astroData = astroService.getAstroData();
        System.out.println(astroData);
        assertThat(astroData).contains("success");
    }
}