package org.domain;


import lombok.Data;

import java.util.Date;

@Data
public class MovieVO {
    private String mtitle, cmt, mimg, userid, rtitle;
    private int mno,views;
    private Date regdate;
}
