package com.br.consultapramim.domains.specifications;

import com.br.consultapramim.domains.CarHunter;
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

}