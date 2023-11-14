package edu.trinity.astro;

import java.util.List;

public record AstroResponse(int number, List<Assignment> people, String message) {
}
