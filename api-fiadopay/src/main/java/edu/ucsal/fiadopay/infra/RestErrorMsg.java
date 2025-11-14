package edu.ucsal.fiadopay.infra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class RestErrorMsg {
        private HttpStatus status;
        private String msg;
}
