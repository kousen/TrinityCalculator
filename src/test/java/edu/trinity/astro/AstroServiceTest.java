package edu.trinity.astro;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AstroServiceTest {
    private final AstroService astroService = new AstroService();

    @Test
    void getAstroData() throws Exception {
        AstroResponse astroData = astroService.getAstroData();
        System.out.println(astroData);
        assertThat(astroData.message()).isEqualTo("success");
        System.out.println("There are " + astroData.number() + " people in space.");
        astroData.people().forEach(person ->
                System.out.println(person.name() + " is in the " + person.craft()));
    }
}