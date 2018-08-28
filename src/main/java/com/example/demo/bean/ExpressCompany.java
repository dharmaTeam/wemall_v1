package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "wemall_express_company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpressCompany {

    @Id
    private Long id;
    private Date addTime;
    private boolean deleteStatus;
    private String company_mark;
    private String  company_name;
    private Integer company_status;
    private Integer company_sequence;
    private String company_type;

}
