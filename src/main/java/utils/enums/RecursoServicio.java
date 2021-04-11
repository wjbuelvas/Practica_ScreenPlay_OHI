package utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RecursoServicio {
    PRESTADOR_JURIDICO("organizationproviders"),
    PRESTADOR_NATURAL("individualproviders");

    private final String recurso;

}