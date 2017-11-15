package csu.cas.poac.valueobject;

public class MetadataCtccRawForm {
 private String  st;
 private String  t1No;
 private String  recvBegTime;
 private String  fileBegTime;
 private String  fileGeneratedTime;
 private String  mb;
 private Integer seq;
 private String  ext;
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
public Integer getSeq() {
	return seq;
}
public void setSeq(Integer seq) {
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
	return "MetadataCtccRawForm [st=" + st + ", t1No=" + t1No + ", recvBegTime=" + recvBegTime + ", fileBegTime="
			+ fileBegTime + ", fileGeneratedTime=" + fileGeneratedTime + ", mb=" + mb + ", seq=" + seq + ", ext=" + ext
			+ "]";
}
 
}
