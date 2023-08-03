package com.br.consultapramim.application.domains.specifications;

import com.br.consultapramim.application.domains.CarHunter;
import com.br.consultapramim.application.domains.ServiceRange;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class CarHunterSpecification {
    private CarHunterSpecification() {
    }

    public static Specification<CarHunter> withName(String name) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<CarHunter> withTradingName(String tradingName) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("tradingName")), "%" + tradingName.toLowerCase() + "%");
    }

    public static Specification<CarHunter> withCity(Long cityId) {
        return (root, query, cb) -> cb.equal(root.get("city").get("id"), cityId);
    }

    public static Specification<CarHunter> isActive(Integer isActive) {
        Boolean value = isActive == 1 ? Boolean.TRUE : isActive == 0 ? Boolean.FALSE : null;
        return (root, query, cb) -> cb.equal(root.get("isActive"), value);
    }

    public static Specification<CarHunter> withSearchRadius(Integer searchRadius) {
        return (root, query, cb) -> {
            Join<CarHunter, ServiceRange> serviceRangeJoin = root.join("serviceRange");
            return cb.lessThanOrEqualTo(serviceRangeJoin.get("searchRadius"), searchRadius);
        };
    }

    public static Specification<CarHunter> withYearMin(Integer yearMin) {
        return (root, query, cb) -> {
            Join<CarHunter, ServiceRange> serviceRangeJoin = root.join("serviceRange");
            return cb.greaterThanOrEqualTo(serviceRangeJoin.get("yearMin"), yearMin);
        };
    }

    public static Specification<CarHunter> withYearMax(Integer yearMax) {
        return (root, query, cb) -> {
            Join<CarHunter, ServiceRange> serviceRangeJoin = root.join("serviceRange");
            return cb.lessThanOrEqualTo(serviceRangeJoin.get("yearMax"), yearMax);
        };
    }

    public static Specification<CarHunter> withPriceMin(Double priceMin) {
        return (root, query, cb) -> {
            Join<CarHunter, ServiceRange> serviceRangeJoin = root.join("serviceRange");
            return cb.greaterThanOrEqualTo(serviceRangeJoin.get("priceMin"), priceMin);
        };
    }

    public static Specification<CarHunter> withPriceMax(Double priceMax) {
        return (root, query, cb) -> {
            Join<CarHunter, ServiceRange> serviceRangeJoin = root.join("serviceRange");
            return cb.lessThanOrEqualTo(serviceRangeJoin.get("priceMax"), priceMax);
        };
    }

    public static Specification<CarHunter> withBrandNew(Integer brandNew) {
        Boolean value = brandNew == 1 ? Boolean.TRUE : brandNew == 0 ? Boolean.FALSE : null;
        return (root, query, cb) -> {
            Join<CarHunter, ServiceRange> serviceRangeJoin = root.join("serviceRange");
            return cb.equal(serviceRangeJoin.get("brandNew"), value);
        };
    }

    public static Specification<CarHunter> withServiceDescription(String serviceDescription) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("serviceDescription")), "%" + serviceDescription.toLowerCase() + "%");
    }
}