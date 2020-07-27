package com.icbc.itsp.springboottemplate.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kfzx-ganhy
 * @since 2020-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String caseName;

    private String caseDesc;

    private String interfaceIds;

    private String inputJson;

    private String assertIds;

    private String belongMan;

    //fill属性用来控制切面拦截新增或者修改需要统一填值的字段
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateOn;


}
