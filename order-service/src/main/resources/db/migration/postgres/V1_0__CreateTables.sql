CREATE TABLE IF NOT EXISTS orders
(
    id         bigint PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    uid        uuid                                                NOT NULL,
    order_date timestamp                                           NOT NULL
);
CREATE UNIQUE INDEX idx_orders_uid ON orders (uid);


CREATE TABLE IF NOT EXISTS order_item
(
    id             bigint PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    order_item_uid uuid                                                NOT NULL,
    order_uid      uuid REFERENCES orders (uid)                        NOT NULL,
    item_uid       uuid                                                NOT NULL,
    item_count     int                                                 NOT NULL
);
CREATE UNIQUE INDEX idx_order_item_order_item_uid ON order_item (order_item_uid);
CREATE INDEX idx_order_item_order_uid ON order_item (order_uid);
CREATE INDEX idx_order_item_item_uid ON order_item (item_uid);

