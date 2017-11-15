package csu.cas.poac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cctcraw")
public class CctcRaw implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	long metadataid;
	@Column(name="st")
	String st;
	@Column(name="t1no")
	String t1No;
	@Column(name="recvbegtime")
	String  recvBegTime;
	@Column(name="filebegtime")
	String  fileBegTime;
	@Column(name="filegeneratedtime")
	String  fileGeneratedTime;
	@Column(name="mb")
	String  mb;
	@Column(name="seq")
	int seq;
	@Column(name="ext")
	String  ext;
	
	public long getMetadataid() {
		return metadataid;
	}
	public void setMetadataid(long metadataid) {
		this.metadataid = metadataid;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	public String getT1No() {
		return t1No;
	}
	public void setT1No(String t1No) {
		this.t1No = t1No;
	}
	public String getRecvBegTime() {
		return recvBegTime;
	}
	public void setRecvBegTime(String recvBegTime) {
		this.recvBegTime = recvBegTime;
	}
	public String getFileBegTime() {
		return fileBegTime;
	}
	public void setFileBegTime(String fileBegTime) {
		this.fileBegTime = fileBegTime;
	}
	public String getFileGeneratedTime() {
		return fileGeneratedTime;
	}
	public void setFileGeneratedTime(String fileGeneratedTime) {
		this.fileGeneratedTime = fileGeneratedTime;
	}
	public String getMb() {
		return mb;
	}
	public void setMb(String mb) {
		this.mb = mb;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	@Override
	public String toString() {
		return "CctcRaw [metadataid=" + metadataid + ", st=" + st + ", t1No=" + t1No + ", recvBegTime=" + recvBegTime
				+ ", fileBegTime=" + fileBegTime + ", fileGeneratedTime=" + fileGeneratedTime + ", mb=" + mb + ", seq="
				+ seq + ", ext=" + ext + "]";
	}
	
}
