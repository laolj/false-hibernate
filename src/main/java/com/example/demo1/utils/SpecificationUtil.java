package com.example.demo1.utils;


import org.apache.logging.log4j.util.Strings;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

public class SpecificationUtil {
    private static final String __ = "%";

    public static String blur(String kw) {
        return __ + kw + __;
    }

    public static Predicate skipBlank(CriteriaBuilder cb, String condition, Supplier<Predicate> search) {

        return Strings.isBlank(condition) ?
                cb.conjunction() :
                search.get();
    }

    public static Predicate skipNull(CriteriaBuilder cb, Object condition, Supplier<Predicate> search) {
        return Objects.isNull(condition) ?
                cb.conjunction() :
                search.get();
    }

    public static Predicate skipEmptyCollection(CriteriaBuilder cb, Collection<?> condition, Supplier<Predicate> search) {
        return CollectionUtils.isEmpty(condition) ?
                cb.conjunction() :
                search.get();
    }
}
