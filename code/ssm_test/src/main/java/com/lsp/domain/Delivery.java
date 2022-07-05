package com.lsp.domain;

import java.sql.Timestamp;

/**
 * @Author:
 * @createTime: 2022年07月05日 09:39:59
 * @version:
 * @Description:
 */
public class Delivery {
    private Integer deliver_id;
    private Integer d_driver_id;
    private Integer d_vehicle_id;
    private Integer d_order_id;
    private Timestamp deliver_time;
    private String deliver_address;
    private char deliver_status;
    private String notice;

}
