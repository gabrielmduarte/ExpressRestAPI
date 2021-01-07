package com.express.cadastro.specification;

import com.express.cadastro.domain.StudentEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class StudentSpecification {

    private static Specification<StudentEntity> byName(final String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    private static Specification<StudentEntity> byEmail(final String email) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("email"), "%" + email + "%");
    }

    private static Specification<StudentEntity> active() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.isTrue(root.get("active"));
    }

    public static Specification<StudentEntity> getSpecification(final String name, final String email) {
        return (Specification<StudentEntity>) (root, query, criteriaBuilder) -> {
            final List<Predicate> predicates = new ArrayList<>();

            if(name != null) {
              predicates.add(byName(name).toPredicate(root, query, criteriaBuilder));
            }

            if(email != null) {
                predicates.add(byEmail(email).toPredicate(root, query, criteriaBuilder));
            }

            predicates.add(active().toPredicate(root, query, criteriaBuilder));

            return criteriaBuilder.and(predicates.toArray(new javax.persistence.criteria.Predicate[]{}));
        };
    }

}
