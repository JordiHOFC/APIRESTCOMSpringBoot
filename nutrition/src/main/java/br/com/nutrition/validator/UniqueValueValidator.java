package br.com.nutrition.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue,String> {
    private Class<?> classe;
    private String atributo;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.classe=constraintAnnotation.domainClass();
        this.atributo= constraintAnnotation.field();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
      String jpql="select 1 from "+classe.getName()+" where "+atributo+" =:s";
      Query query= manager.createQuery(jpql);
      query.setParameter("s",s);
      List<?> result=query.getResultList();
      return result.isEmpty();
    }
}
