package br.com.nutrition.validator;

import br.com.nutrition.Consulta.Consulta;
import br.com.nutrition.Consulta.ConsultaRepository;
import br.com.nutrition.Consulta.ConsultaRequest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class ExistConsultaValidator implements ConstraintValidator<ExistConsulta, ConsultaRequest> {
    @Autowired
    private ConsultaRepository repository;

    @Override
    public boolean isValid(ConsultaRequest consultaRequest, ConstraintValidatorContext constraintValidatorContext) {
        LocalDateTime time=LocalDateTime.parse(consultaRequest.getHorario(),  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Optional<Consulta> ultimaConsulta=repository.findFirstConsultaByNutricionistaIdOrderByIdDesc(consultaRequest.getIdNutricionista());
        if(ultimaConsulta.isPresent()){
            Integer horaRequest=time.getHour();
            Integer minutoRequest=time.getMinute();
            Integer horaUltimaConsulta=ultimaConsulta.get().getHorario().getHour();
            Integer minutoUltimaConsulta=ultimaConsulta.get().getHorario().getMinute();

            if(horaRequest.equals(horaUltimaConsulta) && (minutoRequest-minutoUltimaConsulta)>=30){
                return true;
            }
            else if(!horaRequest.equals(horaUltimaConsulta) &&  ((horaRequest-horaUltimaConsulta)==1) && ((60+minutoRequest)-minutoUltimaConsulta)>=30){
                return true;
            }
            else if(ultimaConsulta.get().getHorario().isAfter(time)){
                return false;
            }
        }
        return false;

    }
}
