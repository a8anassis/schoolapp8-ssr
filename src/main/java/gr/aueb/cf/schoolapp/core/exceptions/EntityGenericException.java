package gr.aueb.cf.schoolapp.core.exceptions;

import lombok.Getter;

@Getter
public class EntityGenericException extends Exception {
    private final String code;

    public EntityGenericException(String code, String message) {
        super(message);
        this.code = code;
    }
}
