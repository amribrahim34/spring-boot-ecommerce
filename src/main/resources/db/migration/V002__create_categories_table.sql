CREATE TABLE categories (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name_ar VARCHAR(255),
    name_en VARCHAR(255),
    image_url VARCHAR(255),
    category_id BIGINT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);


ALTER TABLE categories
ADD CONSTRAINT fk_category_parent
FOREIGN KEY (category_id) REFERENCES categories(id);
