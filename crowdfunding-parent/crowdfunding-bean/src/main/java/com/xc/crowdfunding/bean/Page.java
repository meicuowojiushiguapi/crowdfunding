package com.xc.crowdfunding.bean;

import java.util.List;

public class Page{

    private Integer pageno;
    private  Integer startIndex;
    public Page(){
        this.pageno=0;
        this.pagesize=10;
        this.startIndex=getStartIndex();
    }
    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public List<User> getDatas() {
        return datas;
    }

    public void setDatas(List<User> datas) {
        this.datas = datas;
    }

    public Integer getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(Integer totalcount) {
        this.totalcount = totalcount;
    }

    public Integer getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(Integer totalsize) {
        this.totalsize = totalsize;
    }
    public Integer getStartIndex(){
        return this.pageno-1>0?(this.pageno-1)*this.pagesize:0;
    }
    private Integer pagesize;
    private List<User> datas;

    public Integer getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(Integer totalpages) {
        this.totalpages = totalpages;
    }

    private Integer totalcount;
    private Integer totalsize;
    private Integer totalpages;
}
