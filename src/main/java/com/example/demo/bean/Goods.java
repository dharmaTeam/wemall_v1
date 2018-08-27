package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "wemall_goods")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "addtime")

    private Date addtime;
    private boolean deletestatus;
    private Integer goods_click;
    private String goods_details;
    private String goods_fee;
    private Integer goods_inventory;
    private String goods_inventory_detail;
    private String goods_name;
    private Double goods_price;
    private String goods_property;
    private Integer goods_recommend;
    private Integer goods_salenum;
    private String goods_seller_time;
    private String goods_serial;
    private Integer goods_status;
    private Integer goods_transfee;
    private Double goods_weight;
    private String inventory_type;
    private String seo_description;
    private String seo_keywords;
    private Double store_price;
    private Integer store_recommend;
    private String store_recommend_time;
    private String ztc_admin_content;
    private String ztc_apply_time;
    private String ztc_begin_time;
    private Integer ztc_click_num;
    private Integer ztc_dredge_price;
    private Integer ztc_gold;
    private Integer ztc_pay_status;
    private Integer ztc_price;
    private Integer ztc_status;
    private Long gc_id;
    private Long goods_brand_id;
    private Long goods_main_photo_id;
    private Long goods_store_id;
    private Long ztc_admin_id;
    private Integer goods_collect;
    private Integer group_buy;
    private Integer goods_choice_type;
    private Long group_id;
    private Integer activity_status;
    private Integer bargain_status;
    private Integer delivery_status;
    private Double goods_current_price;
    private Double goods_volume;
    private Double ems_trans_fee;
    private Double express_trans_fee;
    private Double mail_trans_fee;
    private Long transport_id;
    private Integer combin_status;
    private String combin_begin_time;
    private String combin_end_time;
    private Double combin_price;
    private Double description_evaluate;
    private Integer weixin_shop_hot;
    private String weixin_shop_hottime;
    private Integer weixin_shop_recommend;
    private String weixin_shop_recommendtime;

}
