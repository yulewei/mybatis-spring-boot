package com.example.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 保险公司
 *
 * @author yulewei on 2017/8/15
 */
@Getter
@NoArgsConstructor
public class EInsurerCorp extends EnumBase {
    public static final EInsurerCorp TEST00 = new EInsurerCorp("00", "400-999-9595");
    public static final EInsurerCorp TEST01 = new EInsurerCorp("01", " 95511");

    private EInsurerCorp(String code, String desc) {
        super(code);
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

//    public static void main(String[] args) {
//        System.out.println(EInsurerCorp.TEST01.code);
//        EInsurerCorp tmp = EInsurerCorp.parse("00");
//        System.out.println(tmp);
//        System.out.println(TEST00.equals(EInsurerCorp.parse("00")));
//    }
}
