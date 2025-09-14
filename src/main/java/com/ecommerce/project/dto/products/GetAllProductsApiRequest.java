package com.ecommerce.project.dto.products;

import lombok.AllArgsConstructor;
import lombok.Data;

public class GetAllProductsApiRequest {
   private int page;
   private String search;
   private int limit;
   private Long category_id;

    public GetAllProductsApiRequest(int page, String search, int limit, Long category_id) {
        this.page = page;
        this.search = search;
        this.limit = limit;
        this.category_id = category_id;
    }

    public GetAllProductsApiRequest() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}
