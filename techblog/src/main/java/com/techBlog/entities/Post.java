package com.techBlog.entities;

import java.sql.Timestamp;

public class Post {

    private int pid, cid,id;
    private String ptitle, pcontent, ppic, pprogram;
    private Timestamp puploaddate;

    public Post() {
    }
    //const without post id,puploaddate

    public Post(int cid, String ptitle, String pcontent,String pprogram ,String ppic,int id) {
        this.cid = cid;
        this.ptitle = ptitle;
        this.pcontent = pcontent;
        this.ppic = ppic;
        this.pprogram = pprogram;
        this.id=id;
    }
    
    //const without cid
    
    public Post(int pid, String ptitle, String pcontent,String pprogram, String ppic,Timestamp puploaddate,int cid,int id) {
        this.pid = pid;
        this.ptitle = ptitle;
        this.pcontent = pcontent;
        this.pprogram = pprogram;
        this.ppic = ppic;
        this.puploaddate = puploaddate;
        this.cid=cid;
        this.id=id;
    }

    //const with all attribute
    public Post(String ptitle, String pcontent, String pprogram, String ppic, Timestamp puploaddate, int cid, int id) {
       
        this.ptitle = ptitle;
        this.pcontent = pcontent;
        this.pprogram = pprogram;
        this.ppic = ppic;
        this.puploaddate = puploaddate;
        this.cid=cid;
        this.id=id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public String getPpic() {
        return ppic;
    }

    public void setPpic(String ppic) {
        this.ppic = ppic;
    }


    public String getPprog() {
        return pprogram;
    }

    public void setPprog(String pprogram) {
        this.pprogram = pprogram;
    }

    public Timestamp getPuploaddate() {
        return puploaddate;
    }

    public void setPuploaddate(Timestamp puploaddate) {
        this.puploaddate = puploaddate;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

}

