package com.source11.worknotes.domain;

import java.io.Serializable;

/**
 * 工作日志 VO
 */
public class Worknote implements Serializable  {
    private long pk_worknoteID;
    private int fk_personID;
    private short workstateID;
    private String todayAim;
    private String outPlan;
    private String helping;
    private String tomorrowPlan;
    private String workDate;      //Date
    private short resultID;
    private int FK_inspectorPID;
    private String comment;
    private String updateTime;
    private String will1;
    private String will2;

    public Worknote(){

    }

    public long getPk_worknoteID(){
        return pk_worknoteID;
    }

    public void setPk_worknoteID(long pk_worknoteID){
        this.pk_worknoteID=pk_worknoteID;
    }
    public int getFk_personID() {
        return fk_personID;
    }

    public void setFk_personID(int fk_personID) {
        this.fk_personID = fk_personID;
    }

    public short getWorkstateID() {
        return workstateID;
    }

    public void setWorkstateID(short workstateID) {
        this.workstateID = workstateID;
    }

    public String getTodayAim() {
        return todayAim;
    }

    public void setTodayAim(String todayaim) {
        this.todayAim = todayaim;
    }

    public String getOutPlan() {
        return outPlan;
    }

    public void setOutPlan(String outPlan) {
        this.outPlan = outPlan;
    }

    public String getHelping() {
        return helping;
    }

    public void setHelping(String helping) {
        this.helping = helping;
    }

    public String getTomorrowPlan(){
        return tomorrowPlan;
    }

    public void setTomorrowPlan(String tomorrowPlan){
        this.tomorrowPlan=tomorrowPlan;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String work_date) {
        this.workDate = work_date;
    }

    public short getResultID(){
        return resultID;
    }

    public void setResultID(short resultId){
        this.resultID=resultId;
    }

    public int getFK_inspectorPID(){
        return FK_inspectorPID;
    }

    public void setFK_inspectorPID(int fk_inspectorPid){
        this.FK_inspectorPID=fk_inspectorPid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getWill1() {
        return will1;
    }

    public void setWill1(String will1) {
        this.will1 = will1;
    }

    public String getWill2() {
        return will2;
    }

    public void setWill2(String will2) {
        this.will2 = will2;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}
