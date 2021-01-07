package com.express.cadastro.specification;

import com.express.cadastro.domain.TeacherEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class TeacherSpecification {

    private static Specification<TeacherEntity> byName(final String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    private static Specification<TeacherEntity> byDocument(final String document) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("document"), "%" + document + "%");
    }

    private static Specification<TeacherEntity> byEmail(final String email) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("email"), "%" + email + "%");
    }

    private static Specification<TeacherEntity> active() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.isTrue(root.get("active"));
    }

    public static Specification<TeacherEntity> getSpecification(final String name, final String document, final String email) {
        return (Specification<TeacherEntity>) (root, query, criteriaBuilder) -> {
            final List<javax.persistence.criteria.Predicate> predicates = new ArrayList<>();

            if(name != null) {
                predicates.add(byName(name).toPredicate(root, query, criteriaBuilder));
            }

            if(document!=null) {
                predicates.add(byDocument(document).toPredicate(root, query, criteriaBuilder));
            }

            if(email!=null) {
                predicates.add(byEmail(email).toPredicate(root, query, criteriaBuilder));
            }

            predicates.add(active().toPredicate(root, query, criteriaBuilder));

            return criteriaBuilder.and(predicates.toArray(new javax.persistence.criteria.Predicate[]{}));
        };
    }
}
