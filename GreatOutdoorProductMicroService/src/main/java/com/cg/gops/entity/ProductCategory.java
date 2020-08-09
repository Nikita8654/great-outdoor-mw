package com.cg.gops.entity;

public enum ProductCategory {
	
    CAMPING_EQUIPMENT("Camping Equipment"),
    GOLF_EQUIPMENT("Golf Equipment"),
    MOUNTAINEERING_EQUIPMENT("Mountaineering Equipment"),
    OUTDOOR_PROTECTION("Outdoor Protection"),
    PERSONAL_ACCESSORIES("Personal Accessories");
    String displayValue;

    public String getDisplayValue() {
        return displayValue;
    }

    ProductCategory(String displayValue) {
        this.displayValue = displayValue;
    }

    public static ProductCategory getEnumByString(String code){
        for(ProductCategory e : ProductCategory.values()){
            if(e.displayValue.equals(code)) return e;
        }
        return null;
    }

}
