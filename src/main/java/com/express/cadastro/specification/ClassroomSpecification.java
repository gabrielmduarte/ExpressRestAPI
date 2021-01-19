package com.express.cadastro.specification;

import com.express.cadastro.domain.ClassroomEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ClassroomSpecification {

    private static Specification<ClassroomEntity> byTeacherName(String teacherName) {
        return (root, query, criteriaBuilder) -> {
            Join<Object, Object> teacherJoin = root.join("teacher", JoinType.INNER);
            return criteriaBuilder.like(teacherJoin.get("name"), "%" + teacherName +"%");
        };
    }

    private static Specification<ClassroomEntity> byLanguageName(String languageName) {
        return (root, query, criteriaBuilder) -> {
            Join<Object, Object> teacherJoin = root.join("course", JoinType.INNER);
            return criteriaBuilder.like(teacherJoin.get("language"), "%" + languageName +"%");
        };
    }

    private static Specification<ClassroomEntity> active() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.isTrue(root.get("active"));
    }

    public static Specification<ClassroomEntity> getSpecification(final String teacherName, final String languageName) {
        return (Specification<ClassroomEntity>) (root, query, criteriaBuilder) -> {
            final List<Predicate> predicates = new ArrayList<>();

            if(teacherName != null) {
              predicates.add(byTeacherName(teacherName).toPredicate(root, query, criteriaBuilder));
            }

            if(languageName != null) {
                predicates.add(byLanguageName(languageName).toPredicate(root, query, criteriaBuilder));
            }

            predicates.add(active().toPredicate(root, query, criteriaBuilder));

            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        };
    }

}
